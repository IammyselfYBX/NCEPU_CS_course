/*
	2008��6��17��11:15:25
	һ�����е����ݳ�Ա
		1�� ����ڶ����ʱ�򲻳�ʼ����������ֵ��ϵͳ�Զ�����õ�Ĭ��ֵ�� ��int��Ϊ�� boolean����false
			�籾�����A������������

		2�� ����ڶ����ͬʱ����ֵ�� ���ǿ��Եģ�Ҳ����˵��ֵ����Ч��.ע����C++���򲻿��ԣ���C++��һ��������ݳ�Ա�����ڶ����ͬʱ��ʼ������ֻ���ڹ��캯���г�ʼ��
			�籾�����A������������
			
		3�� ����ڶ����ͬʱ����ֵ����Ȼ��Ч��������ڹ��캯�����ָı��˶���ʱ���ĳ�ֵ��
			������ݳ�Ա���յ�ֵ���ǹ��캯�����޸�֮����Ǹ�ֵ,��Ϊ��
				ϵͳ����ִ�ж���ʱ���ĳ�ֵ��Ȼ����ִ�й��캯���и��ĳ�ֵ
			�籾�����B������������
*/

class A
{
	int i;
	int j = 10;
	boolean flag;

	void show()
	{
		System.out.println("i = " + i);
		System.out.println("j = " + j);		
		System.out.println("flag = " + flag);
	}
}

class B
{
	int i;
	int j = 10;
	boolean flag;

	public B()
	{	
		System.out.println("��ǰ��ֵ�� " + i + "  " + j + " " + flag);

		i = 88;
		j = 88;
		flag = true;
	}

	void show()
	{
		System.out.println("i = " + i);
		System.out.println("j = " + j);		
		System.out.println("flag = " + flag);
	}
}

class TestConst_3
{
	public static void main(String[] args)
	{
		A aa1 = new A();
		aa1.show();

		B bb1 = new B();
		bb1.show();
	}
}
/*
	��j2sdk1.4.2_16�е����н���ǣ�
--------------
i = 0
j = 10
flag = false
��ǰ��ֵ�� 0  10 false
i = 88
j = 88
flag = true
--------------
*/