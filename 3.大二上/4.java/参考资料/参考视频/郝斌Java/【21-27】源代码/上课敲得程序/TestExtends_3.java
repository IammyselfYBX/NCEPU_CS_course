/*
	2009年5月31日14:59:26
	本程序证明了:
		1、 子类内部可以访问父类非私有的成员
			私有成员无法被子类方法访问
		
		2、 通过子类对象名只能访问从父类继承过来的非私有成员
		
	总结：	
		私有不能被继承
		私有物理上已经被继承过来，只不过逻辑上程序员不能去访问它
		因此继承必须慎重，否则会浪费内存		
*/

class A
{
	public int i;
	protected int j;
	private int k;
	
	public void g()
	{
	}	
	
	private void s()
	{
	}
	
	protected void b()
	{
	}
}

class B extends A
{
	private void m()
	{
		i = 10;
		j = 20;
		//k = 30; //error 私有属性不能被继承
		
		g();
		b();
		//s(); // error 私有方法不能被继承
	}
	
	public void f()
	{
		i = 10;
		j = 20;
		//k = 30; //error 私有属性不能被继承
		
		g();
		b();
		//s(); // error 私有方法不能被继承
	}
}

class M
{
	public static void main(String[] args)
	{
		B bb = new B();
		bb.i = 20;
		bb.j = 30;
		bb.b();
		bb.g();
		
		//bb.s(); //error
		//bb.k = 22;
		
		
	}
}