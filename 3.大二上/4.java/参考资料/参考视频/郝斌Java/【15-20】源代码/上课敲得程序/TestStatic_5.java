/*
	2009年5月29日15:14:29
	本程序证明了:
		静态方法不能访问非静态成员
		非静态方法可以访问静态成员
*/

class A
{
	private static int i = 10;
	public int j = 99;

	public static void f()  
	{
		//g();  //error 静态方法不能访问非静态成员
		//j = 22; //error
		System.out.printf("FFFF\n");
	}
	
	public void g()
	{
		//f();  //OK 说明非静态方法可以访问静态成员
		System.out.printf("GGGG\n");
		System.out.printf("%d\n", i);
	}
}

class TestStatic_5
{
	public static void main(String[] args)
	{
		A aa = new A();
		//aa.g();
		aa.f();
		
		//A.g(); //error
	}
}