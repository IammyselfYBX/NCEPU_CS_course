class A 
{
	public void f()
	{
		System.out.printf("AAAA\n");
	}
}

class B extends A
{
	public void f()
	{
		System.out.printf("BBBB\n");
	}
	
	public void g()
	{
		System.out.printf("GGGG\n");
	}
}

public class TestPoly_2
{
	public static void main(String[] args)
	{
		A aa = new A();
		B bb = new B();
	
		aa = bb;
		aa.g(); //error   (*aa).g();		
	}
}