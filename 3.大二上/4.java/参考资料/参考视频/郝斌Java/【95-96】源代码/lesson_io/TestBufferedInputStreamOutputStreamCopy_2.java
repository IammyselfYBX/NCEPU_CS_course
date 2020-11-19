/*
	�������д�ٶ�Ҫ����  "TestBufferedInputStreamOutputStreamCopy.java" ����
	����
	����BufferedOutputStream �� BufferedInputStream��ɴ������ļ��ĸ���
	��Զ�ȵ������� FileInputStream  �� FileOutputStream Ҫ��ö�

	BufferedOutputStream �� BufferedInputStream ���ǰ������������������
	OutputStream  �� OutputStream 
*/

import java.io.*;

public class TestBufferedInputStreamOutputStreamCopy_2
{
	public static void main(String[] args)
	{
		FileOutputStream bos = null;
		FileInputStream bis = null;
		
		try
		{
			bos = new FileOutputStream("e:/OutputView.txt");
			bis = new FileInputStream("c:\\[��������www.66ys.cn]�����ܶ�ԱDVD��Ӣ��Ļ.rmvb");
										
			byte[] buf = new byte[1024];
			int len = bis.read(buf, 0, 1024); 
			while (-1 != len)
			{
				bos.write(buf, 0, len);  
				len = bis.read(buf); 
			}
			bos.flush();
			bis.close();
			bos.close();						
		}
		catch (FileNotFoundException e)
		{
			System.out.println("û���ҵ��ļ�!");
			System.exit(-1);
		}
		catch (IOException e)
		{
			System.out.println("�ļ���д����!");
			System.exit(-1);
		}
		
		System.out.println("�ļ����Ƴɹ�!");	
	}			
}