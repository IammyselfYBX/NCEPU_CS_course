/*
	2009��7��3��10:47:37
	������֤���ˣ�
		ͨ���ֽ����������ͼ���ļ��ĸ���
		ʵ��������ͨ���ֽ���������������ʽ�ļ��ĸ���
*/

import java.io.*;

public class TestInputStreamOutputStreamCopy_2
{
	public static void main(String[] args) throws Exception
	{
		FileInputStream fr = new FileInputStream("C:\\1.jpg");
		FileOutputStream fw = new FileOutputStream("d:/zhangsan.haha");
		int ch;
		
		ch = fr.read();
		while (-1 != ch)
		{
			fw.write(ch);
			ch = fr.read();
		}		
		fw.flush();
		
		fr.close();
		fw.close();
	}
}