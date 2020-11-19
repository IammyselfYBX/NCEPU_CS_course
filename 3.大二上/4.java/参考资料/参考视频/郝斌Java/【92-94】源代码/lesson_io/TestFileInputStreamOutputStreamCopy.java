/*
	2009��2��4��14:13:46
	����FileInputStream �� FileOutputStream ����������и�ʽ�ļ��ĸ�ֵ
	��Ϊ�ֽ��ǲ���Ҫ����ͱ���ģ����ֽ�ת��Ϊ�ַ��Ŵ��ڽ��������
	
	�������������Ƶ�ļ��ĸ���
*/

import java.io.*;

public class TestFileInputStreamOutputStreamCopy
{
	public static void main(String[] args)
	{
		FileInputStream fi = null;
		FileOutputStream fo = null;
		
		try
		{
			fi = new FileInputStream("E:\\����\\����\\����������.mp3");	
			fo = new FileOutputStream("d:/share/Output.txt");  //Output.txt�ñ���Ӱ����
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