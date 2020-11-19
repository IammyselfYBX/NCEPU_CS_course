class A
{
	int i = 10;
	
	public void f()
	{
		int i = 20;
		System.out.println("i = " + i);
	}
}

public class Test_2
{
	public static void main(String[] args)
	{
		new A().f();
	}
}