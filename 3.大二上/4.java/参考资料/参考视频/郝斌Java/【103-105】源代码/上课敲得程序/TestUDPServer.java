import java.net.*;
import java.io.*;

public class TestUDPServer
{
	public static void main(String args[]) throws Exception
	{
		//������ͷ
		DatagramSocket ds = new DatagramSocket(5678);  //5678��ʾ����ͷռ�õ���5678�����ţ���Ϊһ̨����������ж����ͷ���ն�����ݣ���Щ��ͷ�ò�ͬ�ı������ʾ����Щ��ŵ�רҵ������Ƕ˿ں�
		
		
		//������������������ݵļ�װ��
		byte buf[] = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		
		try
		{
			while(true)
			{
				//����ͷ���ü�װ����ܶԷ����͹���������
				ds.receive(dp); //ע�⣺�����ִ����Ͼ���ζ�ţ�dp���ݰ��о��Ѿ������˴ӿͻ��˽��չ���������
				
				//�Ӽ�װ����ȡ���Է����͹���������
				ByteArrayInputStream bais = new ByteArrayInputStream(dp.getData()); //1�� ByteArrayInputStream���ں˱����Ǹ��ֽ����飬�����ǴӸ��ֽ������ж�ȡ����  2��dp.getData()��ʾ��dp��װ���е�����ת��Ϊһ���ֽ����鲢���ظ��ֽ�����  
				DataInputStream dis = new DataInputStream(bais);
				System.out.println(dis.readLong()); 
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			ds.close();  //�ر���ͷ
		}
		
	}
}
/*
	��JDK 1.6�е����н���ǣ�
----------------------------------
10000
����Դ��: 127.0.0.1 : 1464
10000
����Դ��: 127.0.0.1 : 1471
10000
����Դ��: 127.0.0.1 : 1474
----------------------------------
*/