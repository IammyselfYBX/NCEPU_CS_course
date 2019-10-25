/*
	2009年2月10日15:11:02
	静态方法只能访问类的静态成员，
	但非静态方法却可以访问类中所有成员，包括静态成员
*/
class A
{
	public static int i;
	public int j;
	
	public static void f()
	{
		//g();  //error 静态方法不能访问非静态方法
		i = 10; //OK
		//j = 99;  //error  静态方法不能访问非静态属性
	}
	
	public void g()
	{
		f();  //OK
		i = 20;  //OK
	}
}

public class TestStatic_2
{
	public static void main(String[] args)
	{
		System.out.println("2009年2月10日15:06:07");
	}
}