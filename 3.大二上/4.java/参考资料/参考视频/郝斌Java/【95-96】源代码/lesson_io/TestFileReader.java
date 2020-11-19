/*
	2008年12月3日10:19:57
	利用FileReader流来读取一个文件中的数据，并在显示器上输出!
*/

import java.io.*;

public class TestFileReader
{
	public static void main(String[] args)
	{
		FileReader fr = null;

		try
		{
			fr = new FileReader("C:\\Documents and Settings\\others\\桌面\\java\\TestFileReader.java");
			int cnt = 0;
			int ch;  

			while (-1 != (ch=fr.read())) //20行    
			{
				System.out.print((char)ch);  // System.out.print(int ch); 这是在显示器上输出ch的整数值，所以必须的进行类型转化，我们需要输出的是ch所代表的整数对应的字符
				++cnt;
			}

			System.out.printf("总共从TestFileReader.java文件中读取了%d个字符", cnt);			
		}
		catch (FileNotFoundException e)
		{
			System.out.println("找不到文件!");
			System.exit(-1);
		}
		catch (IOException e)
		{
			System.out.println("文件读取失败!");
			System.exit(-1);
		}
	}
}