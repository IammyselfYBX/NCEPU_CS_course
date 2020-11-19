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
				if (str.equalsIgnoreCase("�ټ�"))
					break;
				str = dis.readUTF();
				System.out.println("�Է�˵����: " + str);
				if (str.equalsIgnoreCase("�ټ�"))
					break;
			}
		}
		catch (SocketException e)
		{
			System.out.println("�������ӳ���,������ֹ");
		}
		catch (IOException e)
		{
			System.out.println("��д���ݳ���,������ֹ");
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
