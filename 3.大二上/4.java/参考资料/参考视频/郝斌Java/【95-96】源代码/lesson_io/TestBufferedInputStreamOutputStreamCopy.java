/*
	2009年2月4日15:38:44
	利用BufferedOutputStream 和 BufferedInputStream完成大容量文件的复制
	这远比单纯利用 FileInputStream  和 FileOutputStream 要快得多

	BufferedOutputStream 和 BufferedInputStream 都是包裹流，必须的依附于
	OutputStream  和 OutputStream 
*/


import java.io.*;

public class TestBufferedInputStreamOutputStreamCopy
{
	public static void main(String[] args)
	{
		BufferedOutputStream bos = null;
		BufferedInputStream bis = null;
		
		try
		{
			bos = new BufferedOutputStream (
										new FileOutputStream("e:/OutputView.txt")
									);  //bos 输出流有个默认的缓冲区，大小为32个字节	
									
			bis = new BufferedInputStream(
										new FileInputStream("c:\\[高清在线www.66ys.cn]海底总动员DVD中英字幕.rmvb")
									);  //bis 输入流有个默认的缓冲区，大小为32个字节	
			byte[] buf = new byte[1024];
			int len = bis.read(buf, 0, 1024); //一定要注意，这不是从buf中读数据，而是从bis所关联到的D:\\综艺\\电影\\猫和老鼠\\CD4.rmvb文件中读取数据，并将读取的数据写入bis自己的默认缓冲区中，然后再将缓冲区的内容写入buf数组中，每次最多向buf数组中写入1024个字节，返回实际写入buf数组的字节个数，如果读到了文件的末尾，无法再向buf数组中写入数据，则返回-1
			while (-1 != len)
			{
				bos.write(buf, 0, len);  //不是写入buf数组，而是将buf数组中下标从0开始的到len-1为止的所有数据写入bos所关联到的"d:/share/OutputView.txt"文件中
				len = bis.read(buf); //bis.read(buf);  等价于 bis.read(buf, 0, buf.length);
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