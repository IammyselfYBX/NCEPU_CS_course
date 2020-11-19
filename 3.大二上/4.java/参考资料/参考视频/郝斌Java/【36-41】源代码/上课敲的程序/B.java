interface It
{
	public static final int i = 20;
	public abstract void f();
}

interface It2 
{
	int i = 20;
	void f();
}

class A implements It2   //implements不能改为extends 因为累可以继承类，但类不能继承接口，逻辑意义不通， 类可以实现接口
{
	public void f()
	{
		//i = 99;  //error
		System.out.printf("i = %d\n", i);		
	}
}

class B
{
	public static void main(String[] args)
	{
		A aa = new A();
		aa.f();
	}
}