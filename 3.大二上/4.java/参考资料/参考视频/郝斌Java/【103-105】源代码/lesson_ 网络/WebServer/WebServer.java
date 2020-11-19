package webbook.chapter2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
	/** Ĭ��ʹ�õķ�����Socket�˿ں� */
	public static final int HTTP_PORT = 8080;
	private ServerSocket serverSocket;

	public void startServer(int port) {
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("Web Server startup on  " + port);
			while (true) {
				Socket socket = serverSocket.accept();
				// ͨ���̵߳ķ�ʽ������ͻ�������
				new Processor(socket).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * WebServer�����������������ͨ�������в���ָ����ǰWeb��������ʹ�õĶ˿ںš�
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
