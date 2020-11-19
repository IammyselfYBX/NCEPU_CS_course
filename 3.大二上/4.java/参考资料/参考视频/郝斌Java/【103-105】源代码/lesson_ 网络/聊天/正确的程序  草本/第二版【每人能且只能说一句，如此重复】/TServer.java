import java.io.*;
import java.net.*;

public class TServer 
{
	public static void main(String[] args) 
	{
		ServerSocket ss = null;
		Socket s = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		BufferedReader br = null;
		
		try
		{
			ss = new ServerSocket(8888);
			s = ss.accept();
			
			dis = new DataInputStream(s.getInputStream());
			dos = new DataOutputStream(s.getOutputStream());
			br = new BufferedReader(new InputStreamReader(System.in));
			
			while (true)
			{
				String str = dis.readUTF();
				System.out.println("�Է�˵����: " + str);
				if (str.equalsIgnoreCase("�ټ�"))
					break;
				str = br.readLine();
				dos.writeUTF(str);
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
				ss.close();
			}
			catch (Exception e)
			{
			}	
		}		
		
	}
}
