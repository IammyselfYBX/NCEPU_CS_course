/*
	2009��3��18��17:11:06
	������֤���ˣ�
		�ڲ�������з��������Է����ⲿ������г�Ա��
		���ۺ��ַ��ʿ��Ʒ��������ԣ���Ϊ�ڲ��౻�������ⲿ���һ����Ա
*/

class A
{
	private int j = 10;
	
	private void f()
	{
		System.out.println("FFFF");
	}

	class B
	{
		private int k;
		
		//�ڲ�������з��������Է����ⲿ������г�Ա�����ۺ��ַ��ʿ��Ʒ��������ԣ���Ϊ�ڲ��౻�������ⲿ���һ����Ա
		private void g()
		{
			System.out.println("j = " + j);  //�ڲ����˽�з������Է����ⲿ���˽������
			f();  //�ڲ����˽�з������Է����ⲿ���˽�з���
		}
	}

	public void m()
	{
		B bb = new B();
		bb.g();
	}
}


public class TestInnerClass_1
{
	public static void main(String[] args)
	{
		A aa = new A();	
		aa.m();
	}
}
/*
	��JDK 1.6�е����н���ǣ�
----------
j = 10
FFFF
----------
*/