/*
	2009��2��11��17:03:59
	����A������B  B������C
	���ʵ�ֵ���A  B  C �����f�����ĺ���
*/

class A
{
	public void f()
	{
		System.out.println("AAAA");
	}
}

class B extends A
{
	public void f()
	{
		System.out.println("BBBB");
	}
}

class C extends B
{
	public void f()
	{
		System.out.println("CCCC");
	}
}

public class TestPoly_2
{
	//m��������ʵ�ֵ�������A�������ж���f�����Ĺ���
	public static void m(A aa)
	{
		aa.f();
	}
	
	public static void main(String[] args)
	{
		A aa = new A();
		B bb = new B();
		C cc = new C();
		
		m(aa);
		m(bb);
		m(cc);
	}
}