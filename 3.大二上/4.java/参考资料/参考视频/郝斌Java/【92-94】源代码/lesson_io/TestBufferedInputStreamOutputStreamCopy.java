/*
	2009��2��4��15:38:44
	����BufferedOutputStream �� BufferedInputStream��ɴ������ļ��ĸ���
	��Զ�ȵ������� FileInputStream  �� FileOutputStream Ҫ��ö�

	BufferedOutputStream �� BufferedInputStream ���ǰ������������������
	OutputStream  �� OutputStream 
*/


import java.io.*;

public class TestBufferedInputStreamOutputStreamCopy
{
	public static void main(String[] args)
	{
		BufferedOutputStream bos = null;
		BufferedInputStream bis = null;
		
		try
		{
			bos = new BufferedOutputStream (
										new FileOutputStream("e:/OutputView.txt")
									);  //bos ������и�Ĭ�ϵĻ���������СΪ32���ֽ�	
									
			bis = new BufferedInputStream(
										new FileInputStream("c:\\[��������www.66ys.cn]�����ܶ�ԱDVD��Ӣ��Ļ.rmvb")
									);  //bis �������и�Ĭ�ϵĻ���������СΪ32���ֽ�	
			byte[] buf = new byte[1024];
			int len = bis.read(buf, 0, 1024); //һ��Ҫע�⣬�ⲻ�Ǵ�buf�ж����ݣ����Ǵ�bis����������D:\\����\\��Ӱ\\è������\\CD4.rmvb�ļ��ж�ȡ���ݣ�������ȡ������д��bis�Լ���Ĭ�ϻ������У�Ȼ���ٽ�������������д��buf�����У�ÿ�������buf������д��1024���ֽڣ�����ʵ��д��buf������ֽڸ���������������ļ���ĩβ���޷�����buf������д�����ݣ��򷵻�-1
			while (-1 != len)
			{
				bos.write(buf, 0, len);  //����д��buf���飬���ǽ�buf�������±��0��ʼ�ĵ�len-1Ϊֹ����������д��bos����������"d:/share/OutputView.txt"�ļ���
				len = bis.read(buf); //bis.read(buf);  �ȼ��� bis.read(buf, 0, buf.length);
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