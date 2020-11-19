import java.io.*;

class DivisorIsZeroException extends Exception
{
	public DivisorIsZeroException(String name)
	{
		super(name);
	}
}

class A
{
	public int divide(int a, int b) throws DivisorIsZeroException
	{
		int m = 0;
		
		if (0 == b)
			throw  new DivisorIsZeroException("除数不能为零! O(∩_∩)O哈哈~");
		else
			m = a/b;
			
		return m;
	}
}




public class TestExcep_7
{
	public static void main(String[] args) //throws IOException
	{
		A aa = new A();		
		
		try
		{
			aa.divide(6, 0);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}		
	}
}