class A
{
	int divide(int a, int b)
	{
		return a / b;
	}
	
	int add(int a, int b)
	{
		return a + b;
	}
}


class Excep_1
{
	public static void main(String[] args)
	{
		A aa = new A();
		try
		{
			int i = aa.divide(3, 0);
			System.out.println(i);
		}
		catch (ArithmeticException e)
		{
			System.out.println("除数不能为零!");
		}
		
		int j = aa.add(2, 4);
		System.out.println("j = " + j);
	}
}