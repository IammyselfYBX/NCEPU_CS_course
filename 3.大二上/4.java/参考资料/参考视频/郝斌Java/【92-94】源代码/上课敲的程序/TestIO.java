/*
	2009��7��3��10:41:25
	��ϰ�Ͻڿε�����
*/


import java.io.*;

public class TestIO
{
	public static void main(String[] args) throws Exception
	{
		FileReader fr = new FileReader("D:/share/S5/di-20 ��/TestIO.java");
		int ch;
		int cnt = 0;
		
		ch = fr.read();
		while (-1 != ch)
		{
			++cnt;
			System.out.printf("%c", (char)ch);
			ch = fr.read();
		}
		System.out.printf("���ļ��ַ��ĸ�����:%d\n", cnt);
		fr.close();
	}
}