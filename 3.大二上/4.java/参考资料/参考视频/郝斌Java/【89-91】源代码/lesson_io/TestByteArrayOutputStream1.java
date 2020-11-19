/*
	���ܣ���һ��long���͵�����д��byte������,Ȼ���ٴ�byte�����ж�ȡ��
		  ���long���͵�����
		  
		  ��Ϊ�������о���Ҫ����ֵ�����ݴ���byte������Ȼ������
		  DatagramPacket�������紫�䵽Ŀ�Ļ���Ŀ�Ļ��ٴ�byte������
		  ��ԭ��ֵ�����ݻ�ԭ����
	
	Ŀ��: ByteArrayOutputStream   DataOutputStream  ByteInputStream DataInputStream ����ʹ��
		  ��ס: DataOutputStream���е�writeLong(long n)�ǰ�n�������ڴ�
		  		�еĶ����ƴ���д����������ӵ����豸��
		  		
	ע�⣺��API�ĵ���֪��
			����  ByteArrayOutputStream ����ʱ����ҪҲ����ָ���������飬��Ϊ��������Ĭ���Ѿ����ú��� 		
		  	����  ByteArrayInputStream ����ʱ�����ָ������������˭��
*/

import java.io.*;

public class TestByteArrayOutputStream1
{
	public static void main(String args[]) throws Exception
	{
		long n = 9876543210L;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();  //9��  API:"public ByteArrayOutputStream(): ����һ���µ� byte ���������������������������� 32 �ֽڣ����б�Ҫ���������С�� "
									//9�д���һ��ִ����ϣ���ζ������: 1�����ڴ���������һ����СΪ32���ֽڵ�byte����   2����һ������baos�Ĺܵ������ӵ��˸�byte�����У����ҿ���ͨ������ܵ����byte������д������
									//��Ȼ��ʱ����ͨ��baos��baos�����ӵ������ڴ��з���õ�byte������д�����ݣ�����ByteArrayOutputStream����û���ṩ����ֱ�Ӱ�long��������ֱ��д��ByteArrayOutputStream�������ӵ���byte�����еķ���, ��˵����û��ͨ��baos��baos�����ӵ���byte������д��long���͵�����, ��API�ĵ����Է���: ByteArrayOutputStream���в�û������writeLong()�����ķ���������DataOutputStream����ȴ��writeLong() writeFloat()�ȷ���
		DataOutputStream dos = new DataOutputStream(baos);
		
		dos.writeLong(n);  //��n�����������10000L���ڴ��еĶ����ƴ���д��dos��������baos�ܵ������ӵ����ڴ��еĴ�СΪ32�ֽڵ�byte�����У������н�����������Ƕ�����д�룬�Ȳ��ǰ�10000Lת��Ϊ�ַ�'1' '0' '0' '0' '0'д��byte�����У����ǰ�10000L���ڴ��е��ܹ�8���ֽڵĶ����ƴ���д��byte������
		
		dos.flush();
		byte[] buf = baos.toByteArray();  //DataOutputStream ���в�û��toByteArray()����������ByteArrayOutputStream ����ȴ��toByteArray()����, ���Բ����԰�baos ��Ϊdos���������ʱ�����! ByteArrayOutputStream����toByteArray()�����ĺ��壬ժ��API������һ���·���� byte ���顣���С�Ǵ�������ĵ�ǰ��С�����һ���������Ч�����Ѹ��Ƶ��������С�

		//����ByteArrayInputStream �� DataInputStream ���Դ�byte�����еõ�ԭlong���͵���ֵ10000L
		ByteArrayInputStream bais = new ByteArrayInputStream(buf);
		DataInputStream dis = new DataInputStream(bais);
		long l = dis.readLong();

		System.out.println("l = " + l);
		dos.close();
	}
}
/*
	��JDK 1.6�е����н���ǣ�
----------------
l = 9876543210
----------------
*/