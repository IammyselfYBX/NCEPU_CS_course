/*
	2009��3��28��17:38:50
	ͨ��������һ���ļ���д�����ݣ������û��Ӽ�������������Զ�д��ĳ���ļ���,
	����������exit,�������ֹ
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
			
			while (null != (strRec=br.readLine()))  //��ס�� ���ֱ������س��Ļ�, br.readLine() ���ص���""  ������ null  ���߽���br.readLine()�����س���ʱ��ֹ��ȡ�����һ�Ѷ�ȡ���Ļس����Զ�������
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
