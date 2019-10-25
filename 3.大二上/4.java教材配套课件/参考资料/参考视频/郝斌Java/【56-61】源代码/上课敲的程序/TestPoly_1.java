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
	}
}

public class TestPoly_1
{
	public static void main(String[] args)
	{
		A aa = new A();
		B bb = new B();
		//aa = bb;
		aa.f();
		
		B bb2 = (B)aa;		
	}
}