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
			//dos.writeUTF("����");
			dos.writeUTF("�ٺ�");			
		}
		catch (SocketException e)
		{
			System.out.println("�������ӳ���������ֹ");
			System.exit(-1);
		}
		catch (IOException e)
		{
			System.out.println("��д���ݳ���������ֹ");
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