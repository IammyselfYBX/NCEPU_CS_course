/*
	2009年7月3日10:44:37
	本程序证明了：
		通过字节流可以完成音频格式文件的复制
		实际上我们通过字节流可以完成任意格式文件的复制
		
		但本程序有个缺点：
			没有缓冲区， 处理速度慢
			
		可以参考对比"TestInputStreamOutputStreamCopy_3.java"
*/

import java.io.*;

public class TestInputStreamOutputStreamCopy
{
	public static void main(String[] args) throws Exception
	{
		FileInputStream fr = new FileInputStream("E:\\IBM教学\\java\\lesson_io\\妹妹来看我.mp3");
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