/*
	DataOutputStream �е� writeXXX(data)����
		��
	PrintStream �е� println(data)������
	
	�ܽ�:
		DataOutputStream �е� writeXXX(data)�����ǰ�data���ڴ��еĶ���������д���ļ�
		PrintStream �е� println(data)д�����Ǹ����ݵĸ�ʽ������ַ���		
*/

import java.io.*;

public class TestPrintStream_1
{
	public static void main(String[] args) throws Exception 
	{
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("d:/kk.txt"));
		dos.writeLong(12345);  //ʵ��д���ļ�����00 00 00 00 00 00 30 39
		dos.close();
		System.out.printf("%#X\n", 12345);
		
		PrintStream ps = new PrintStream(new FileOutputStream("d:/kk2.txt"), true);
		ps.println(12345);  //ʵ��д���ļ�����'1' '2' '3' '4' '5'
		ps.close();
	}
}