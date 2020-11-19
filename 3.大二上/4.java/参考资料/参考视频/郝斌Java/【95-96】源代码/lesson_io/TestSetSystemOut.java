import java.io.*;

public class TestSetSystemOut
{
	public static void main(String[] args)
	{
		PrintStream ps_out = null;
				
		try
		{
			ps_out = new PrintStream(new FileOutputStream("d:/share/ww.txt"));
			System.setOut(ps_out); //将System.out的值重新设置为ps_out,即System.out不在关联到显示器，而是关联到"d:/share/ww.txt"文件
			System.out.println(12); //这实际上是把12输出到了System.out所关联的d:/share/ww.txt中
			System.out.println(55.5);  //同上
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