abstract class A
{
	public abstract void f();
}

class B extends A
{
	public void f()
	{
		System.out.println("����");
	}
}

public class TestAbs_1
{
	public static void main(String[] args)
	{
		//A aa1 = new A();  //error
		A aa2 = null;  //���Զ���һ�������������
		aa2 = new B(); //���������ĵ�ַ���������������
		aa2.f(); //�ó���������÷�������ķ���  ����Ƕ�̬
	}
}