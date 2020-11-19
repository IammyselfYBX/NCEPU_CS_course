/*
	2009��2��4��14:26:39
	������֤���� FileReader �� FileWriter ֻ��������ı��ļ��ĸ��ƣ�
			ȴ�޷������Ƶ��ʽ�ļ��ĸ���
*/

import java.io.*;

public class TestFileReaderWriterCopy
{
	public static void main(String[] args)
	{
		FileReader fi = null;
		FileWriter fo = null;
		
		try
		{
			fi = new FileReader("E:\\����\\����\\����������.mp3");	
			fo = new FileWriter("d:/share/Output.txt");  //Output.txt�ñ���Ӱ����ʧ�ܣ� ������֤����FileWriter �� FileReader �޷������Ƶ�ļ��ĸ�ֵ��ʵ����FileWriter �� FileReader ֻ������ı��ļ��ĸ���
			int ch;
			
			while (-1 != (ch=fi.read()))
			{
				fo.write(ch);
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("�ļ�û���ҵ�!");
			System.exit(-1);
		}
		catch(IOException e)
		{
			System.out.println("�ļ���д����!");
			System.exit(-1);
		}
		finally
		{
			try
			{
				if (null != fi)
				{
					fi.close();
					fi = null;
				}
				if (null != fo)
				{	
					fo.close();
					fo = null;
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
				System.exit(-1);
			}
		}
		
		System.out.println("�ļ����Ƴɹ�!");
	}	
}