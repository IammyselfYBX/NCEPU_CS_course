class A
{
	public void f()
	{
		System.out.printf("AAAA\n");
	}
	
	public void f(int i)
	{
		System.out.printf("����\n");
	}
}

class B extends A
{
	public void f()
	{
		super.f();  //���ôӸ���̳й�����f����
		f(10);
		System.out.printf("BBBB\n");
	}
}

public class TestOver_2
{
	public static void main(String[] zhangsan)
	{
		B bb = new B();
		bb.f();	
	}
}