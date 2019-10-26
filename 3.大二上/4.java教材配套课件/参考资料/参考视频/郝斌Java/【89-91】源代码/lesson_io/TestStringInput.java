/*
	2009年1月25日9:22:46
	如何将键盘输入的字符组成字符串直接赋给String 对象
	
	预备知识:
--------------------------------
Reader FileReader InputStream FileInputStream BufferedInputStream 
流中都没有 readLine 方法
	DataInputStream 流中有 readLine方法，但已经 被标记为过时
	BufferedReader 流中有readLine方法，并且该方法是可以正确被使用的
--------------------------------
*/

import java.io.*;

public class TestStringInput
{
	public static void main(String[] args) 
	{
		String str = null;
		BufferedReader br = new BufferedReader (   //21行
					new InputStreamReader(System.in)
				); //23行  查API：从21行到23行的代码是不会抛出任何异常的
				
		try
		{
			str = br.readLine(); //会抛出IOException异常
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.exit(-1);
		}	
		
		System.out.println("str = " + str);		
		try
		{
			br.close(); //会抛出IOException异常
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.exit(-1);
		}		
	}
}
/*
	在JDK 1.6中的运行结果是：
--------------------------------
sadd行政村123Asd?asd撒旦
str = sadd行政村123Asd?asd撒旦
--------------------------------
*/