class A 
{
	public void f()
	{
		System.out.printf("AAAA\n");
	}
}

class B extends A
{
	public void f() //重写方法的权限不能低于被重写方法的访问权限
	{
		System.out.printf("BBBB\n");
	}
}

public class TestA
{
	public static void main(String[] args)
	{
		B bb = new B();
		//bb.f();
		A aa = new A();
		aa.f();
		
		aa = bb;
		aa.f(); //(*aa).f();
		
		//bb = aa; //error
	}
}