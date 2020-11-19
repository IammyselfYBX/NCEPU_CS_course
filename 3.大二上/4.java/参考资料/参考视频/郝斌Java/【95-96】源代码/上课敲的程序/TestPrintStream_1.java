/*
	DataOutputStream 中的 writeXXX(data)方法
		与
	PrintStream 中的 println(data)的区别
	
	总结:
		DataOutputStream 中的 writeXXX(data)方法是把data在内存中的二进制数据写入文件
		PrintStream 中的 println(data)写出的是该数据的格式化后的字符串		
*/

import java.io.*;

public class TestPrintStream_1
{
	public static void main(String[] args) throws Exception 
	{
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("d:/kk.txt"));
		dos.writeLong(12345);  //实际写入文件的是00 00 00 00 00 00 30 39
		dos.close();
		System.out.printf("%#X\n", 12345);
		
		PrintStream ps = new PrintStream(new FileOutputStream("d:/kk2.txt"), true);
		ps.println(12345);  //实际写入文件的是'1' '2' '3' '4' '5'
		ps.close();
	}
}