/*
	2009年5月29日15:14:29
	本程序证明了: static属性i是属于类本身，或者讲：没有对象，我们仍然可以直接通过类名的方式访问该类内部的static属性
				  static方法g同理
*/

class A
{
	public static int i = 10;

	public static void f()
	{
		System.out.printf("2009年5月29日15:15:50");
	}
}

class TestStatic_2
{
	public static void main(String[] args)
	{
		System.out.printf("%d\n", A.i);
		A.f();
	}
}