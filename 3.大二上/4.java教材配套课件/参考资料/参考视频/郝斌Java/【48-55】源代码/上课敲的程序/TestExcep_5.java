import java.io.*;

class A
{
	public void f() throws IOException  
	{
		throw new IOException(); //throw Å×³öÒì³£
	}
	
	public void g()
	{
		throw new ArithmeticException();
	}
}

public class TestExcep_5
{
	public static void main(String[] args) //throws IOException
	{
		A aa = new A();		
		
		try
		{
			aa.f();
		}
		catch (IOException e)
		{
		}
		
	}
}