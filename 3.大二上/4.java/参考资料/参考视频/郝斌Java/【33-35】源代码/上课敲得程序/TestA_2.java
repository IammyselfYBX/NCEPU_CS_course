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
}

public class TestA_2
{
	public static void main(String[] args)
	{
		A aa = new A();
		B bb = new B();
		
		aa = bb;
		
		//bb = aa;  //error
		bb = (B)aa;
		bb.f();
		aa.f();		
	}
}