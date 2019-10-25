/*
	2009年7月3日10:43:18
	本程序证明了:
		通过字符流无法完成非文本文件的复制
		或者说：
			字符流只能处理文本文件
			不能处理非文本文件
	
*/

import java.io.*;

public class TestFileReaderWriterCopy_2
{
	public static void main(String[] args) throws Exception
	{
		FileReader fr = new FileReader("E:\\IBM教学\\java\\lesson_io\\妹妹来看我.mp3");
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