/*
	����ĳ���
*/

import java.io.*;
import java.net.*;

public class TServer_3
{
	public static void main(String[] args)
	{
		ServerSocket ss;  //�ᵼ��40�г���
		Socket s;    //�ᵼ��41�г��� 
		DataInputStream dis;  //�ᵼ��42�г���			
		
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
				dis.close();   //40��  error ��������Ϊdis���ܻ�û�б���ʼ��
				s.close();     //41��  error  ͬ��
				ss.close();    //42��  error  ͬ��
			}
			catch (Exception e)
			{
			}
		}
	}
}