/*
	2009年3月28日17:38:50
	通过键盘向一个文件中写入数据，即把用户从键盘敲入的数据自动写入某个文件中,
	如果敲入的是exit,则程序终止
*/

import java.util.*;
import java.io.*;

public class TestPrintWriter
{
	public static void main(String[] args)
	{
		BufferedReader br = new BufferedReader(
						new InputStreamReader(System.in)
					);
		PrintWriter ps = null;
		try
		{
			ps = new PrintWriter(new FileWriter("d:/share/java/BB.java"));
			String strRec = null;
			
			while (null != (strRec=br.readLine()))  //记住： 如果直接输入回车的话, br.readLine() 返回的是""  而不是 null  或者讲：br.readLine()遇到回车符时终止读取，并且会把读取到的回车符自动丢弃掉
			{
				if (strRec.equalsIgnoreCase("exit"))
					break;					
				ps.println(strRec);
			}			
			ps.flush();			
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.exit(-1);
		}
		finally
		{
			ps.close();
		}			
	}
}
