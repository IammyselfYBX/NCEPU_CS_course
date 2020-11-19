/*
	利用 BufferedReader 和 BufferedWriter 完成文本文件的复制
*/

import java.io.*;

public class TestBufferedReaderWriterCopy
{
	public static void main(String[] args)
	{
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try
		{
			br = new BufferedReader(
						new FileReader("D:\\share\\S5\\di-20 流\\TestBufferedReaderWriterCopy.java")
					);
			bw = new BufferedWriter(
						new FileWriter("d:/share/Writer.txt")
					);
			String str = null;
			
			while (null != (str=br.readLine()))  //br.readLine()读取一行字符，但会将读取的换行符自动丢弃,即返回的String对象中并不包括换行符
			{
				bw.write(str);
				bw.newLine();  //写入一个换行符  这行不能省
			}
			bw.flush();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			System.exit(-1);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.exit(-1);
		}
		finally
		{
			try
			{
				bw.close();
				br.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
				System.exit(-1);
			}
		}
	}
}