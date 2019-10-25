/*
	2009年7月3日10:47:37
	本程序证明了：
		通过字节流可以完成图像文件的复制
		实际上我们通过字节流可以完成任意格式文件的复制
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