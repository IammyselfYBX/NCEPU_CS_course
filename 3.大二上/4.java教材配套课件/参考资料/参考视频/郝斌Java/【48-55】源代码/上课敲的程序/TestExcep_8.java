import java.io.*;

class A
{
	public void f() throws ArithmeticException  
	{
		//throw new ArithmeticException(); //throw Å×³öÒì³£
	}
}

public class TestExcep_8
{
	public static void main(String[] args) //throws IOException
	{
		A aa = new A();		
		
		try
		{
			aa.f();		
		}
		catch (ArithmeticException e)
		{
			System.out.printf("haha ");
		}
		
	}
}