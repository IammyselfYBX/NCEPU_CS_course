class A
{
	public int i;

	public A()
	{
	}
	
	public A(int i)
	{
		this.i = i;
	}
}

class B extends A
{
	public int j;
	
	public B(int i, int j)
	{
		//this.j = j;  
		super();
		//super(i);
		//super(i);		
		
	}
	
	public void f(int i)
	{
		//super(i); //��ͨ�����в��ܵ��ø���Ĺ��췽��
	}
}

public class TestSuper_3
{
	public static void main(String[] args)
	{		
	}
}