/*
	本程序读写速度要慢于  "TestBufferedInputStreamOutputStreamCopy.java" 程序
	即：
	利用BufferedOutputStream 和 BufferedInputStream完成大容量文件的复制
	这远比单纯利用 FileInputStream  和 FileOutputStream 要快得多

	BufferedOutputStream 和 BufferedInputStream 都是包裹流，必须的依附于
	OutputStream  和 OutputStream 
*/

import java.io.*;

public class TestBufferedInputStreamOutputStreamCopy_2
{
	public static void main(String[] args)
	{
		FileOutputStream bos = null;
		FileInputStream bis = null;
		
		try
		{
			bos = new FileOutputStream("e:/OutputView.txt");
			bis = new FileInputStream("c:\\[高清在线www.66ys.cn]海底总动员DVD中英字幕.rmvb");
										
			byte[] buf = new byte[1024];
			int len = bis.read(buf, 0, 1024); 
			while (-1 != len)
			{
				bos.write(buf, 0, len);  
				len = bis.read(buf); 
			}
			bos.flush();
			bis.close();
			bos.close();						
		}
		catch (FileNotFoundException e)
		{
			System.out.println("没有找到文件!");
			System.exit(-1);
		}
		catch (IOException e)
		{
			System.out.println("文件读写错误!");
			System.exit(-1);
		}
		
		System.out.println("文件复制成功!");	
	}			
}