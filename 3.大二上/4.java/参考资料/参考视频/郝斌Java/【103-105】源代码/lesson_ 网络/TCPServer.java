import java.net.*;
import java.io.*;

public class TCPServer
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(6666);//8行  6666是端口号，表示该服务器程序在监听666端口是否有客户端程序的连接
					//new出的ServerSocket对象ss并不会自动监听客户端有没有向6666端口发送请求，要想监听6666端口是否有客户端的请求，则必须的调用ss对象的accept方法
					//如果本程序只有8行这一行的代码的话，本程序运行时将无任何输出结果并会立即终止								
		
		while (true)
		{
			Socket s = ss.accept();  //accept()功能：等待客户端的连接，没有连接，则继续监听，程序停滞不前，如果接收到客户端的一个连接，则自动将该连接封装为一个Socket对象，程序将不再阻塞，而是继续放下执行  
						//这里的s实际是链接到客户端的s，服务器端的s.getInputStream() 和客户端的s.getOutputStream()实际是同一根管道
						//accept()是阻塞式方法，如果接收不到客户端的连接，则程序将停止不前
			System.out.println("一个连接已经建立!!!");
			DataInputStream dis = new DataInputStream(s.getInputStream()); //通过Socket对象可以获得InputStream和OutputStream两个管道
			System.out.println(dis.readUTF());  //readUTF()方法也是阻塞式方法，如果接收不到客户端数据，则程序将停止不前
			dis.close();  //DataInputStream 和 InputStream 流中都没有flush方法  DataOutputStream 和 OutputStream 流中都有flush方法
			s.close();
		}	
	}
}