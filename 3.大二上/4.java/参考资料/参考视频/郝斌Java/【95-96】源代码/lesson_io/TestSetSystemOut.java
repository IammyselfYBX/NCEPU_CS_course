import java.io.*;

public class TestSetSystemOut
{
	public static void main(String[] args)
	{
		PrintStream ps_out = null;
				
		try
		{
			ps_out = new PrintStream(new FileOutputStream("d:/share/ww.txt"));
			System.setOut(ps_out); //��System.out��ֵ��������Ϊps_out,��System.out���ڹ�������ʾ�������ǹ�����"d:/share/ww.txt"�ļ�
			System.out.println(12); //��ʵ�����ǰ�12�������System.out��������d:/share/ww.txt��
			System.out.println(55.5);  //ͬ��
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				ps_out.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
		}
	}
}