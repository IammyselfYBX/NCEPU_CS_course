class A
{
	public void f()
	{
		System.out.printf("AAAA\n");
	}
}

class B extends A
{
	public void f()
	{
		super.f();  //���ôӸ���̳й�����f����
		System.out.printf("BBBB\n");
	}
}

public class TestOver_1
{
	public static void main(String[] zhangsan)
	{
		B bb = new B();
		bb.f();	
	}
}