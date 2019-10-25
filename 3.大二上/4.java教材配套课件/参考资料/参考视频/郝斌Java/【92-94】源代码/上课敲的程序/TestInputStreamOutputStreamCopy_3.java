/*
	2009年7月3日10:45:49
	本程序证明了：
		带缓冲区的字节流处理文件的速度要快于不带缓冲区的字节流处理文件的速度
		
		可以参考对比"TestInputStreamOutputStreamCopy.java"
*/

import java.io.*;

public class TestInputStreamOutputStreamCopy_3
{
	public static void main(String[] args) throws Exception
	{
		BufferedInputStream bis = new BufferedInputStream( new FileInputStream("E:\\IBM教学\\java\\lesson_io\\妹妹来看我.mp3"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("d:/zhangsan.haha"));
		byte[] buf = new byte[1024];
		int len;
		
		len = bis.read(buf);
		while (-1 != len)
		{
			bos.write(buf, 0, len);
			len = bis.read(buf);
		}		
		bos.flush();
		
		bos.close();
		bis.close();
	}
}