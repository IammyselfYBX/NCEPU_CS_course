import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class ChatServer 
{
	public static void main(String[] args) 
	{
		boolean started = false; // 判断服务器是否启动了，先假定没有启动
		ServerSocket ss = null;
		DataInputStream dis = null;
		
		try 
		{
			ss = new ServerSocket(8888);
			started = true; // 服务器已经启动了，设置started为true
			while (started) 
			{ //当服务器端启动时。。。。
				boolean bConnect = false;  //判断服务器和客户端的连接是否已经建立， 没有为false，连接成功返回true
				Socket s = ss.accept(); //accept()与readUTF()方法一样，都是一个阻塞式方法，如果没有收到连接请求，则一直等待。。。。。
				bConnect = true;  //连接成功，设置bConnect为true
				System.out.println("一个连接已经建立!"); // --------------------------
				dis = new DataInputStream(s.getInputStream());
				while (bConnect) 
				{
					String str = null;
					str = dis.readUTF();  //如果客户端突然断开连接,该语句就会抛出异常EOFException，所以我们必须得对dis.readUTF();进行异常处理
								//readUTF()是阻塞式方法，如果得不到数据，则继续等待，直到读取到数据为止
					System.out.println("从客户端接受的数据是:" + str);
				}
			}
		}
		catch (BindException e)
		{
			System.out.println("端口已被占用，其使用其他端口");
			System.out.println("请关闭相关程序，重新运行!");
			System.exit(-1);
		}
		catch (EOFException  e)
		{
			System.out.println("客户端已经断开连接!");
		}
		catch (IOException e) 
		{
			//e.printStackTrace();
			System.out.println("服务器端读写错误!");
		}
		finally
		{
			try
			{
				if (null != ss)  //如果监听程序打开了，则关闭网络监听程序
				{
					ss.close();
					ss = null;
				}
				
				if (null != dis)  //如果输入流打开了，则关闭输入流
				{
					dis.close();
					dis = null;
				}
			}
			catch (Exception e)
			{
			}
		}
	}	
}
