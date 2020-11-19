package webbook.chapter2;

import java.io.*;
import java.net.Socket;

/**
 * 处理一个HTTP用户请求的线程类。
 */
public class Processor extends Thread {
	private PrintStream out;
	private InputStream input;
	/** 默认的服务器存放访问内容的目录 */
	public static final String WEB_ROOT = "e:\\workspace\\webserver\\htdocs";

	public Processor(Socket socket) {
		try {
			input = socket.getInputStream();
			out = new PrintStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			String fileName = parse(input);
			readFile(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 解析客户机发过的所有HTTP请求，如果是符合HTTP协议内容的， 就分析出客户机所要访问文件的名字，并且返回文件名。
	 */
	public String parse(InputStream input) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(input));
		String inputContent = in.readLine();
		if (inputContent == null || inputContent.length() == 0) {
			sendError(400, "Client invoke error");
			return null;
		}
		// 分析客户请求的HTTP信息，分析出到底想访问哪个文件，
		// 发过来的HTTP请求应该是三部分。

		String request[] = inputContent.split(" ");
		if (request.length != 3) {
			sendError(400, "Client invoke error");
			return null;
		}
		// 第一部分是请求的方法
		String method = request[0];
		// 第二部分是请求的文件名
		String fileName = request[1];
		// 第三部分是HTTP版本号
		String httpVersion = request[2];
		System.out.println("Method: " + method + ", file name: " + fileName + ", HTTP version: " + httpVersion);
		return fileName;
	}

	/**
	 * 处理调用一个文件的请求
	 */
	public void readFile(String fileName) throws IOException {
		File file = new File(Processor.WEB_ROOT + fileName);
		if (!file.exists()) {
			sendError(404, "File Not Found");
			return;
		}
		// 把文件的内容读取到in对象中。
		InputStream in = new FileInputStream(file);
		byte content[] = new byte[(int) file.length()];
		in.read(content);
		out.println("HTTP/1.0 200 sendFile");
		out.println("Content-length: " + content.length);
		out.println();
		out.write(content);
		out.flush();
		out.close();
		in.close();
	}

	/**
	 * 发送错误的信息
	 */
	public void sendError(int errNum, String errMsg) {
		out.println("HTTP/1.0 " + errNum + " " + errMsg);
		out.println("Content-type: text/html");
		out.println();
		out.println("<html>");
		out.println("<head><title>Error " + errNum + "--" + errMsg + "</title></head>");
		out.println("<h1>" + errNum + " " + errMsg + "</h1>");
		out.println("</html>");
		out.println();
		out.flush();
		out.close();
	}
}
