abstract class A
{
	abstract public void f();
}

class B extends A
{
	public void f()
	{
		System.out.printf("BBBB\n");		
	}
}

public class TestAbsPoly_1
{
	public static void main(String[] args)
	{
		//A aa = new A();  //error  18��
		
		B bb = new B();  //OK
		bb.f(); //OK
		
		A aa;  //23��   OK ���Զ���һ������������ã����ǲ����Զ���һ��������Ķ�������18��error�� ����OK
		aa = bb;
		aa.f();
	}
}

