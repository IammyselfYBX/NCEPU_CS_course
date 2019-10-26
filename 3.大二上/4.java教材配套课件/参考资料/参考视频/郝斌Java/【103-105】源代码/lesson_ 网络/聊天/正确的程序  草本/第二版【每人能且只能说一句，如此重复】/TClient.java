import java.io.*;
import java.net.*;

public class TClient 
{
	public static void main(String[] args) throws Exception
	{
		Socket s = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		BufferedReader br = null;
		
		try
		{
			s = new Socket("127.0.0.1", 8888);
			dis = new DataInputStream(s.getInputStream());
			dos = new DataOutputStream(s.getOutputStream());
			br = new BufferedReader(new InputStreamReader(System.in));
			
			while (true)
			{
				String str = br.readLine();
				dos.writeUTF(str);
				if (str.equalsIgnoreCase("再见"))
					break;
				str = dis.readUTF();
				System.out.println("对方说的是: " + str);
				if (str.equalsIgnoreCase("再见"))
					break;
			}
		}
		catch (SocketException e)
		{
			System.out.println("网络连接出错,程序终止");
		}
		catch (IOException e)
		{
			System.out.println("读写数据出错,程序终止");
		}
		catch (Exception e)
		{
		}
		finally
		{
			try
			{
				dis.close();
				dos.close();
				s.close();
			}
			catch (Exception e)
			{
			}	
		}
	}
}
