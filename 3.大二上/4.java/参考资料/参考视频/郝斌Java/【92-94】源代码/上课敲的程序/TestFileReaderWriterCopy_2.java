/*
	2009��7��3��10:43:18
	������֤����:
		ͨ���ַ����޷���ɷ��ı��ļ��ĸ���
		����˵��
			�ַ���ֻ�ܴ����ı��ļ�
			���ܴ�����ı��ļ�
	
*/

import java.io.*;

public class TestFileReaderWriterCopy_2
{
	public static void main(String[] args) throws Exception
	{
		FileReader fr = new FileReader("E:\\IBM��ѧ\\java\\lesson_io\\����������.mp3");
		FileWriter fw = new FileWriter("d:/zhangsan.haha");
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