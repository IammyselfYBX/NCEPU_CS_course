/*
	2008��12��3��10:19:57
	����FileReader������ȡһ���ļ��е����ݣ�������ʾ�������!
*/

import java.io.*;

public class TestFileReader
{
	public static void main(String[] args)
	{
		FileReader fr = null;

		try
		{
			fr = new FileReader("C:\\Documents and Settings\\others\\����\\java\\TestFileReader.java");
			int cnt = 0;
			int ch;  

			while (-1 != (ch=fr.read())) //20��    
			{
				System.out.print((char)ch);  // System.out.print(int ch); ��������ʾ�������ch������ֵ�����Ա���Ľ�������ת����������Ҫ�������ch�������������Ӧ���ַ�
				++cnt;
			}

			System.out.printf("�ܹ���TestFileReader.java�ļ��ж�ȡ��%d���ַ�", cnt);			
		}
		catch (FileNotFoundException e)
		{
			System.out.println("�Ҳ����ļ�!");
			System.exit(-1);
		}
		catch (IOException e)
		{
			System.out.println("�ļ���ȡʧ��!");
			System.exit(-1);
		}
	}
}