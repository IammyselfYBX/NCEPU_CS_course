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

class A implements It2   //implements���ܸ�Ϊextends ��Ϊ�ۿ��Լ̳��࣬���಻�ܼ̳нӿڣ��߼����岻ͨ�� �����ʵ�ֽӿ�
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