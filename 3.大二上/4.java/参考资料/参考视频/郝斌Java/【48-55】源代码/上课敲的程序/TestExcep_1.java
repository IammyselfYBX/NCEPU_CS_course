class A
{
	int divide(int a, int b)
	{
		int m = 0;
		
		try
		{
			m = a/b;
		}
		catch (ArithmeticException e)
		{
			System.out.printf("除数不能为零!\n");
		}
		
		//System.out.printf("1111");
		return m;
	}
}

public class TestExcep_1
{
	public static void main(String[] args)
	{
		new A().divide(6, 2);
		//System.out.printf("2222");
	}
}
