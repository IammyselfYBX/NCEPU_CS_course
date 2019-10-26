/*
	2009年3月18日17:11:06
	本程序证明了：
		内部类的所有方法都可以访问外部类的所有成员，
		无论何种访问控制符，都可以，因为内部类被当作了外部类的一个成员
*/

class A
{
	private int j = 10;
	
	private void f()
	{
		System.out.println("FFFF");
	}

	class B
	{
		private int k;
		
		//内部类的所有方法都可以访问外部类的所有成员，无论何种访问控制符，都可以，因为内部类被当作了外部类的一个成员
		private void g()
		{
			System.out.println("j = " + j);  //内部类的私有方法可以访问外部类的私有属性
			f();  //内部类的私有方法可以访问外部类的私有方法
		}
	}

	public void m()
	{
		B bb = new B();
		bb.g();
	}
}


public class TestInnerClass_1
{
	public static void main(String[] args)
	{
		A aa = new A();	
		aa.m();
	}
}
/*
	在JDK 1.6中的运行结果是：
----------
j = 10
FFFF
----------
*/