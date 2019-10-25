/*
	2009年2月10日17:45:28
	同包继承权限问题
*/

class A
{
	private int s;
	int m;
	public int g;
	protected int b;
	
	private void fs()
	{
	}
	
	public void fg()
	{
	}
	
	void fm()
	{
	}
	
	protected void fb()
	{
	}
}

class B extends A
{
	//子类的所有方法内部都可以访问父类除私有成员以外的所有成员
	private void g()
	{
		m = g = 10;
		fg();
		fm();
		fb();
		//s = 10;  //error
		//fs();  //error
	}
}

public class TestExtends_2
{
	public static void main(String[] args)
	{
		B bb = new B();
		
		//通过子类对象名可以访问父类除私有成员外的所有成员
		bb.g = bb.b = bb.m = 22;
		
		//bb.s = 11;  //error
		//bb.fs();  //error
		
		bb.fg();
		bb.fm();
		bb.fb();
		
		System.out.println("2009年2月10日17:44:37");	
	}
}