/*
	���� BufferedReader �� BufferedWriter ����ı��ļ��ĸ���
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
						new FileReader("D:\\share\\S5\\di-20 ��\\TestBufferedReaderWriterCopy.java")
					);
			bw = new BufferedWriter(
						new FileWriter("d:/share/Writer.txt")
					);
			String str = null;
			
			while (null != (str=br.readLine()))  //br.readLine()��ȡһ���ַ������Ὣ��ȡ�Ļ��з��Զ�����,�����ص�String�����в����������з�
			{
				bw.write(str);
				bw.newLine();  //д��һ�����з�  ���в���ʡ
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