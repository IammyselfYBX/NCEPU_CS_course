package webbook.chapter2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
	/** 默认使用的服务器Socket端口号 */
	public static final int HTTP_PORT = 8080;
	private ServerSocket serverSocket;

	public void startServer(int port) {
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("Web Server startup on  " + port);
			while (true) {
				Socket socket = serverSocket.accept();
				// 通过线程的方式来处理客户的请求
				new Processor(socket).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * WebServer类的启动方法，可以通过命令行参数指定当前Web服务器所使用的端口号。
	 */
	public static void main(String[] argv) throws Exception {
		WebServer server = new WebServer();
		if (argv.length == 1) {
			server.startServer(Integer.parseInt(argv[0]));
		} else {
			server.startServer(WebServer.HTTP_PORT);
		}
	}
}
