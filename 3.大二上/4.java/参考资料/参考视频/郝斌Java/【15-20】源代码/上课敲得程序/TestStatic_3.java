/*
	2009��5��29��15:14:29
	������֤����: 
		static���Ժͷ�����Ȼ�����౾����Ȼ����ͨ�������ķ�ʽ����
		����static���Ժͷ���������Ҳ��������󣬵�ȻҲ����ͨ����������ķ�ʽ����
*/

class A
{
	public static int i = 10;

	public static void f()
	{
		System.out.printf("2009��5��29��15:15:50\n");
	}
}

class TestStatic_3
{
	public static void main(String[] args)
	{
		A aa = new A();
		//A.f();
		aa.f();
		System.out.printf("%d\n", aa.i);
	}
}