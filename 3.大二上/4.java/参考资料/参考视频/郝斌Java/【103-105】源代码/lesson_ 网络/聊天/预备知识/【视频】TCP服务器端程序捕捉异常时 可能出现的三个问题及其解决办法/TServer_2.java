/*
	����ĳ���
*/

import java.io.*;
import java.net.*;

public class TServer_2
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket ss = new ServerSocket(8888);
			Socket s = null;
			DataInputStream dis = null;		
			
			while (true)
			{
				s = ss.accept();
				dis = new DataInputStream(s.getInputStream());
				String str = dis.readUTF();
				System.out.println("�Է�˵����: " + str);
			}
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
				dos.close();   //error �ҵ�����dos
				s.close();     //error  ͬ��
				ss.close();    //error  ͬ��
			}
			catch (Exception e)
			{
			}
		}
	}
}