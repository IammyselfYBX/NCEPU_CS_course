/*
	����ĳ���
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
				System.out.println("�Է�˵����: " + str);
			}
			
			dis.close();  //����д�ʹ���,��Ϊ�������Զ�޷��õ�ִ��
			s.close();   //ͬ��
			ss.close();  //ͬ��
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
	}
}