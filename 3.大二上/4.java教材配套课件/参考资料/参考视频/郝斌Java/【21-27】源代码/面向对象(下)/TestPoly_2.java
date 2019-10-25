/*
	2009年2月11日17:03:59
	假设A派生出B  B派生出C
	编程实现调用A  B  C 类对象f方法的函数
*/

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

class C extends B
{
	public void f()
	{
		System.out.println("CCCC");
	}
}

public class TestPoly_2
{
	//m函数可以实现调用整个A类族所有对象f方法的功能
	public static void m(A aa)
	{
		aa.f();
	}
	
	public static void main(String[] args)
	{
		A aa = new A();
		B bb = new B();
		C cc = new C();
		
		m(aa);
		m(bb);
		m(cc);
	}
}