/*
	2009年3月30日9:57:47
	功能： 将键盘输入的数据输入A文件中，如果输入有误，
		   则把出错信息输出到B文件中
		   
		   标准输入输出流的重定向	
*/

import java.io.*;
import java.util.*;

public class TestSetOutErr
{
	public static void main(String[] args) 
	{
		PrintStream psOut = null;
		PrintStream psError = null;
		Scanner sc = null;
		
		
		try
		{
			psOut = new PrintStream("d:/Out.txt");
			psError = new PrintStream("d:/error.txt");
			sc = new Scanner(System.in);
			int num;
			System.setOut(psOut);
			System.setErr(psError);
			
			while (true)
			{
				num = sc.nextInt();
				System.out.println(num);				
			}	
		}
		catch (Exception e)
		{
			System.err.println("出错的信息是:");  //不可以写成System.out.println("出错的信息是:");
			e.printStackTrace();  //e.printStackTrace(); 默认是输出到System.err所关联的设备中
		}			
	}
}