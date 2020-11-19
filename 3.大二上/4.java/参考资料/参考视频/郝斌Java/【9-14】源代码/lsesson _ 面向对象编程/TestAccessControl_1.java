/*
	2009年2月10日15:39:18
	在一个类的内部，所有的成员可以相互访问,访问控制符是针对外部访问而言的

*/

class A
{
	public int i = 10;
	private int j = 20;
	
	public void f()
	{
		i = j = 111;
		g();
	}	
	
	private void g()
	{
		j = i = 222;
		f();
	}
}

public class TestAccessControl_1
{
	public static void main(String[] args)
	{
		System.out.println("2009年2月10日15:30:43");
	}
}