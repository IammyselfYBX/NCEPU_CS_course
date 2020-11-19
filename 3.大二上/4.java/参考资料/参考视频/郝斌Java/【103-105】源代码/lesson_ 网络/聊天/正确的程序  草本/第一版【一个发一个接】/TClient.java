import java.io.*;
import java.net.*;

public class TClient
{
	public static void main(String[] args)
	{
		Socket s = null;
		DataOutputStream dos = null;
		
		try
		{
			s = new Socket("127.0.0.1", 8888);
			dos = new DataOutputStream(s.getOutputStream());
			//dos.writeUTF("哈哈");
			dos.writeUTF("嘿嘿");			
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
				dos.close();
				s.close();
			}
			catch (Exception e)
			{
			}
		}		
	}
}