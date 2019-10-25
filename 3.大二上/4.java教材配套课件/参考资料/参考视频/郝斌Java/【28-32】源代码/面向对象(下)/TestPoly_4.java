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
	
	public void g()
	{
		System.out.println("¹þ¹þ");
	}
}

public class TestPoly_4
{
	public static void main(String[] args)
	{
		A aa = new B();//µÈ¼ÛÓÚ A aa;  aa = new B();
		aa.f();
		//aa.g();  //error
	}
}