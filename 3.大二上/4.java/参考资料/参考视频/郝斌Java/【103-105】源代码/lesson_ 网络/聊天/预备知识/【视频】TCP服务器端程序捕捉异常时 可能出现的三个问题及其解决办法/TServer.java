/*
	错误的程序
*/


import java.io.*;
import java.net.*;

public class TServer
{
	public static void main(String[] args)
	{
		ServerSocket ss = null;
		Socket s = null;
		DataInputStream dis = null;
		
		try
		{
			ss = new ServerSocket(8888);
					
			while (true)
			{
				s = ss.accept();
				dis = new DataInputStream(s.getInputStream());
				String str = dis.readUTF();
				System.out.println("对方说的是: " + str);
			}
			
			dis.close();  //这样写就错了,因为本语句永远无法得到执行
			s.close();   //同上
			ss.close();  //同上
		}
		catch (SocketException e)
		{
			System.out.println("网络连接出错，程序终止");
			System.exit(-1);
		}
		catch (IOException e)
		{
			System.out.println("读写数据出错，程序终止");
			System.exit(-1);
		}
	}
}