package webbook.chapter2;

import java.io.*;
import java.net.Socket;

/**
 * ����һ��HTTP�û�������߳��ࡣ
 */
public class Processor extends Thread {
	private PrintStream out;
	private InputStream input;
	/** Ĭ�ϵķ�������ŷ������ݵ�Ŀ¼ */
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
	 * �����ͻ�������������HTTP��������Ƿ���HTTPЭ�����ݵģ� �ͷ������ͻ�����Ҫ�����ļ������֣����ҷ����ļ�����
	 */
	public String parse(InputStream input) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(input));
		String inputContent = in.readLine();
		if (inputContent == null || inputContent.length() == 0) {
			sendError(400, "Client invoke error");
			return null;
		}
		// �����ͻ������HTTP��Ϣ������������������ĸ��ļ���
		// ��������HTTP����Ӧ���������֡�

		String request[] = inputContent.split(" ");
		if (request.length != 3) {
			sendError(400, "Client invoke error");
			return null;
		}
		// ��һ����������ķ���
		String method = request[0];
		// �ڶ�������������ļ���
		String fileName = request[1];
		// ����������HTTP�汾��
		String httpVersion = request[2];
		System.out.println("Method: " + method + ", file name: " + fileName + ", HTTP version: " + httpVersion);
		return fileName;
	}

	/**
	 * �������һ���ļ�������
	 */
	public void readFile(String fileName) throws IOException {
		File file = new File(Processor.WEB_ROOT + fileName);
		if (!file.exists()) {
			sendError(404, "File Not Found");
			return;
		}
		// ���ļ������ݶ�ȡ��in�����С�
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
	 * ���ʹ������Ϣ
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
