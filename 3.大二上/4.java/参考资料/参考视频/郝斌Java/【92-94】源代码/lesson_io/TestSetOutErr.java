/*
	2009��3��30��9:57:47
	���ܣ� �������������������A�ļ��У������������
		   ��ѳ�����Ϣ�����B�ļ���
		   
		   ��׼������������ض���	
*/

import java.io.*;
import java.util.*;

public class TestSetOutErr
{
	public static void main(String[] args) 
	{
		PrintStream psOut = null;
		PrintStream psError = null;
		Scanner sc = null;
		
		
		try
		{
			psOut = new PrintStream("d:/Out.txt");
			psError = new PrintStream("d:/error.txt");
			sc = new Scanner(System.in);
			int num;
			System.setOut(psOut);
			System.setErr(psError);
			
			while (true)
			{
				num = sc.nextInt();
				System.out.println(num);				
			}	
		}
		catch (Exception e)
		{
			System.err.println("�������Ϣ��:");  //������д��System.out.println("�������Ϣ��:");
			e.printStackTrace();  //e.printStackTrace(); Ĭ���������System.err���������豸��
		}			
	}
}