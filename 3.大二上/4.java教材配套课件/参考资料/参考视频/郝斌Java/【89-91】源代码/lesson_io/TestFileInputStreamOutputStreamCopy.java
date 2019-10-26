/*
	2009年2月4日14:13:46
	利用FileInputStream 和 FileOutputStream 可以完成所有格式文件的赋值
	因为字节是不需要解码和编码的，将字节转化为字符才存在解码的问题
	
	本程序完成了视频文件的复制
*/

import java.io.*;

public class TestFileInputStreamOutputStreamCopy
{
	public static void main(String[] args)
	{
		FileInputStream fi = null;
		FileOutputStream fo = null;
		
		try
		{
			fi = new FileInputStream("E:\\综艺\\歌曲\\妹妹来看我.mp3");	
			fo = new FileOutputStream("d:/share/Output.txt");  //Output.txt用暴风影音打开
			int ch;
			
			while (-1 != (ch=fi.read()))
			{
				fo.write(ch);
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("文件没有找到!");
			System.exit(-1);
		}
		catch(IOException e)
		{
			System.out.println("文件读写错误!");
			System.exit(-1);
		}
		finally
		{
			try
			{
				if (null != fi)
				{
					fi.close();
					fi = null;
				}
				if (null != fo)
				{	
					fo.close();
					fo = null;
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
				System.exit(-1);
			}
		}
		
		System.out.println("文件复制成功!");
	}	
}