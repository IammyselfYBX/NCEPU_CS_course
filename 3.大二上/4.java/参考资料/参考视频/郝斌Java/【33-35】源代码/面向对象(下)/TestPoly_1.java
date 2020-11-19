class A
{
	public void f()
	{
		System.out.println("AAAA");
	}	
}

class B extends A
{
	public void f()
	{
		System.out.println("BBBB");
	}
}


public class TestPoly_1
{
	public static void main(String[] args)
	{
		A aa = new B();
		aa.f();
	
		aa = new A();
		aa.f();
	}									
}