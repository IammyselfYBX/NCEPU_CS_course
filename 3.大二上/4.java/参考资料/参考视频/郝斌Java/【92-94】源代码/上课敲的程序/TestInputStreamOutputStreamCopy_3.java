/*
	2009��7��3��10:45:49
	������֤���ˣ�
		�����������ֽ��������ļ����ٶ�Ҫ���ڲ������������ֽ��������ļ����ٶ�
		
		���Բο��Ա�"TestInputStreamOutputStreamCopy.java"
*/

import java.io.*;

public class TestInputStreamOutputStreamCopy_3
{
	public static void main(String[] args) throws Exception
	{
		BufferedInputStream bis = new BufferedInputStream( new FileInputStream("E:\\IBM��ѧ\\java\\lesson_io\\����������.mp3"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("d:/zhangsan.haha"));
		byte[] buf = new byte[1024];
		int len;
		
		len = bis.read(buf);
		while (-1 != len)
		{
			bos.write(buf, 0, len);
			len = bis.read(buf);
		}		
		bos.flush();
		
		bos.close();
		bis.close();
	}
}