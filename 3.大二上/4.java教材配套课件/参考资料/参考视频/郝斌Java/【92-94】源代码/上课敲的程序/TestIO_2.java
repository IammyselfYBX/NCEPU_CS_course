/*
	2009年7月3日10:41:46
	本程序证明了:
		如果通过一个字节流把文本文件的内容输出到显示器上，当输出汉字时就会出现乱码
*/

import java.io.*;

public class TestIO_2
{
	public static void main(String[] args) throws Exception
	{
		FileInputStream fr = new FileInputStream("D:/share/S5/di-20 流/TestIO.java");
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