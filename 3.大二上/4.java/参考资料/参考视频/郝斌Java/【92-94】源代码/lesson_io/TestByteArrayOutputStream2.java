/*
	����:
		��long��������д��byte���飬Ȼ���ڴ�byte�����аѸ����ݶ�����
*/

import java.io.*;

public class TestByteArrayOutputStream2
{
	public static void main(String[] args) throws Exception
	{
		long n = 1234567;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeLong(n);
		
		byte[] buf = baos.toByteArray();
		ByteArrayInputStream bis = new ByteArrayInputStream(buf);
		DataInputStream dis = new DataInputStream(bis);
		long n2 = dis.readLong();
		System.out.println("n2 = " + n2);
		
		dos.close(); 
		dis.close();
	}
}