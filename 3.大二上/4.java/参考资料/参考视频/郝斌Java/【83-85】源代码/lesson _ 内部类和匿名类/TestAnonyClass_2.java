/*
	����A�ǳ�����
	new A()
	{
		ʵ����A������г�����ķ�������
		����Լ��ķ��������Դ��롾�����飬��Ϊû��ʵ�����塿
	}	
	
	���ܣ� ����һ�������࣬������������ʵ����A������г��󷽷���
		   ��Ȼ��������Ҳ���Զ����Լ������Ժͷ���
*/

abstract class A
{
	abstract public void f();
		
	public void g()
	{
	}
}

public class TestAnonyClass_2
{
	public static void main(String[] args)
	{
		A aa = new A()
			{
				//f���������Ա�ע�͵�, ��Ϊf�ǳ��󷽷�������������ʵ��
				public void f()
				{
					System.out.println("FFFF");
				}
				
				//g�������Ա�ע�͵�
				public void g()
				{
					System.out.println("GGGG");
				}
				
				public void k()
				{
				}
			};
		
		aa.f();
		aa.g();
		//aa.k();  
	}
}
/*
	��JDK 1.6�е����н���ǣ�
-----------------------------
FFFF
GGGG
-----------------------------
*/