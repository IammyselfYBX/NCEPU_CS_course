/*
	����A�Ǹ�����
	new A()
	{
		��д��A��ķ�������
		�Լ���ӵ����Ժͷ������������飬��Ϊû��ʵ�����塿��
	}	
	
	���ܣ� ����һ��A���������󣬸����������̳���A�����з�private��Ա
*/

class A
{
	public void f()
	{
		System.out.println("����");
	}
}

public class TestAnonyClass_3
{
	public static void main(String[] args)
	{
		A aa = new A()
			{
				//��д�˸���A�ķ���
				public void f()
				{
					System.out.println("�ٺ�");
				}
				
				//���Զ����Լ��ķ�������û���κ�ʵ������
				public void g()
				{
					System.out.println("GGGG");
				}
			};
		
		aa.f();
		//aa.g();  //error
	}
}
/*
	��JDK 1.6�е����н���ǣ�
-----------------------------
FFFF
GGGG
-----------------------------
*/