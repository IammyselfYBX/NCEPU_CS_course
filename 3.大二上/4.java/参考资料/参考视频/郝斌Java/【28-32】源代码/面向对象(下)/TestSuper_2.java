class A
{
	public int i;

	A(int i)
	{
		this.i = i;
	}
}

class B extends A
{
	public B()
	{
		super(2); //如果将本语句注释掉 则会出错，因为 “派生类构造函数中如果不写super(...);  则默认的会添加super();”
	}
}

class TestSuper_2
{
	public static void main(String[] args) 
	{
		A aa = new A(5);
		B bb = new B();

		System.out.println("Hello World!");
	}
}