/*
	2009年7月3日10:42:43
	通过字符流完成文本文件的复制
	
*/

import java.io.*;

public class TestFileReaderWriterCopy
{
	public static void main(String[] args) throws Exception
	{
		FileReader fr = new FileReader("D:\\share\\S5\\di-20 流\\TestFileReaderWriterCopy.java");
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