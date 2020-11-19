/*
	2009年2月4日14:26:39
	本程序证明了 FileReader 和 FileWriter 只可以完成文本文件的复制，
			却无法完成视频格式文件的复制
*/

import java.io.*;

public class TestFileReaderWriterCopy
{
	public static void main(String[] args)
	{
		FileReader fi = null;
		FileWriter fo = null;
		
		try
		{
			fi = new FileReader("E:\\综艺\\歌曲\\妹妹来看我.mp3");	
			fo = new FileWriter("d:/share/Output.txt");  //Output.txt用暴风影音打开失败！ 本程序证明了FileWriter 和 FileReader 无法完成视频文件的赋值，实际上FileWriter 和 FileReader 只能完成文本文件的复制
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