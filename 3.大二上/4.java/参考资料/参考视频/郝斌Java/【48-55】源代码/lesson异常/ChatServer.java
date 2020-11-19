import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class ChatServer 
{
	public static void main(String[] args) 
	{
		boolean started = false; // �жϷ������Ƿ������ˣ��ȼٶ�û������
		ServerSocket ss = null;
		DataInputStream dis = null;
		
		try 
		{
			ss = new ServerSocket(8888);
			started = true; // �������Ѿ������ˣ�����startedΪtrue
			while (started) 
			{ //��������������ʱ��������
				boolean bConnect = false;  //�жϷ������Ϳͻ��˵������Ƿ��Ѿ������� û��Ϊfalse�����ӳɹ�����true
				Socket s = ss.accept(); //accept()��readUTF()����һ��������һ������ʽ���������û���յ�����������һֱ�ȴ�����������
				bConnect = true;  //���ӳɹ�������bConnectΪtrue
				System.out.println("һ�������Ѿ�����!"); // --------------------------
				dis = new DataInputStream(s.getInputStream());
				while (bConnect) 
				{
					String str = null;
					str = dis.readUTF();  //����ͻ���ͻȻ�Ͽ�����,�����ͻ��׳��쳣EOFException���������Ǳ���ö�dis.readUTF();�����쳣����
								//readUTF()������ʽ����������ò������ݣ�������ȴ���ֱ����ȡ������Ϊֹ
					System.out.println("�ӿͻ��˽��ܵ�������:" + str);
				}
			}
		}
		catch (BindException e)
		{
			System.out.println("�˿��ѱ�ռ�ã���ʹ�������˿�");
			System.out.println("��ر���س�����������!");
			System.exit(-1);
		}
		catch (EOFException  e)
		{
			System.out.println("�ͻ����Ѿ��Ͽ�����!");
		}
		catch (IOException e) 
		{
			//e.printStackTrace();
			System.out.println("�������˶�д����!");
		}
		finally
		{
			try
			{
				if (null != ss)  //�������������ˣ���ر������������
				{
					ss.close();
					ss = null;
				}
				
				if (null != dis)  //������������ˣ���ر�������
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
