/*
	2009��7��3��10:44:37
	������֤���ˣ�
		ͨ���ֽ������������Ƶ��ʽ�ļ��ĸ���
		ʵ��������ͨ���ֽ���������������ʽ�ļ��ĸ���
		
		���������и�ȱ�㣺
			û�л������� �����ٶ���
			
		���Բο��Ա�"TestInputStreamOutputStreamCopy_3.java"
*/

import java.io.*;

public class TestInputStreamOutputStreamCopy
{
	public static void main(String[] args) throws Exception
	{
		FileInputStream fr = new FileInputStream("E:\\IBM��ѧ\\java\\lesson_io\\����������.mp3");
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