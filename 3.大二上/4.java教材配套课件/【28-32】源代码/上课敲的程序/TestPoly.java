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

public class TestPoly
{
	public static void main(String[] args)
	{
		A aa = new A();
		B bb = new B();
		
		aa.f();
		bb.f();
		
		aa = bb;  // 把bb当做aa来看待  因为子类可以当做父类看待，所以本语句OK
		//bb = aa; // 把aa当做bb来看待， 因为父类不能当做子类看待，所以本语句error
	}
}