/*
	����new ����������󣬵������ó����������ָ��������������󣬼�������Ҳ����ʵ�ֶ�̬
*/

abstract class A
{
	abstract public void f();
}

class B extends A
{
	public void f()
	{
		System.out.println("BBB");
	}
}

public class TestAbsClass_2
{
	public static void main(String[] args)
	{
		//A aa = new A();  //error   ����new ����������� 
		A aa = new B();  //OK
		aa.f();  //��̬
	}
}