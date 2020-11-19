/*
	错误的程序
*/

import java.io.*;
import java.net.*;

public class TServer_3
{
	public static void main(String[] args)
	{
		ServerSocket ss;  //会导致40行出错
		Socket s;    //会导致41行出错 
		DataInputStream dis;  //会导致42行出错			
		
		try
		{
			ss = new ServerSocket(8888);
			s = null;
			dis = null;		
			
			while (true)
			{
				s = ss.accept();
				dis = new DataInputStream(s.getInputStream());
				String str = dis.readUTF();
				System.out.println("对方说的是: " + str);
			}
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
		finally
		{
			try
			{
				dis.close();   //40行  error 编译器认为dis可能还没有被初始化
				s.close();     //41行  error  同上
				ss.close();    //42行  error  同上
			}
			catch (Exception e)
			{
			}
		}
	}
}