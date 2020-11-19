/*
	2009��1��25��9:22:46
	��ν�����������ַ�����ַ���ֱ�Ӹ���String ����
	
	Ԥ��֪ʶ:
--------------------------------
Reader FileReader InputStream FileInputStream BufferedInputStream 
���ж�û�� readLine ����
	DataInputStream ������ readLine���������Ѿ� �����Ϊ��ʱ
	BufferedReader ������readLine���������Ҹ÷����ǿ�����ȷ��ʹ�õ�
--------------------------------
*/

import java.io.*;

public class TestStringInput
{
	public static void main(String[] args) 
	{
		String str = null;
		BufferedReader br = new BufferedReader (   //21��
					new InputStreamReader(System.in)
				); //23��  ��API����21�е�23�еĴ����ǲ����׳��κ��쳣��
				
		try
		{
			str = br.readLine(); //���׳�IOException�쳣
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.exit(-1);
		}	
		
		System.out.println("str = " + str);		
		try
		{
			br.close(); //���׳�IOException�쳣
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.exit(-1);
		}		
	}
}
/*
	��JDK 1.6�е����н���ǣ�
--------------------------------
sadd������123Asd?asd����
str = sadd������123Asd?asd����
--------------------------------
*/