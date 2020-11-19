/*
	2009年7月3日10:41:25
	复习上节课的例子
*/


import java.io.*;

public class TestIO
{
	public static void main(String[] args) throws Exception
	{
		FileReader fr = new FileReader("D:/share/S5/di-20 流/TestIO.java");
		int ch;
		int cnt = 0;
		
		ch = fr.read();
		while (-1 != ch)
		{
			++cnt;
			System.out.printf("%c", (char)ch);
			ch = fr.read();
		}
		System.out.printf("该文件字符的个数是:%d\n", cnt);
		fr.close();
	}
}