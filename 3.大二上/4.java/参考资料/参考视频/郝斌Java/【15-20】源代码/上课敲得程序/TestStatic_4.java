/*
	2009��5��29��15:14:29
	������֤����:
		ֻ�з�private��static��Ա�ſ���ͨ�������ķ�ʽ����
		
		staticֻ�Ǳ����˸ó�Ա�����˿���ͨ���������ʵ�Ǳ������
		���Ƿ����ͨ���������ʣ�����������һ�������� �ó�Ա�����Ƿ�private 
*/

class A
{
	private static int i = 10;

	private static void f()
	{
		System.out.printf("2009��5��29��15:15:50\n");
	}
}

class TestStatic_4
{
	public static void main(String[] args)
	{
		//A.f();
		A.i = 22;
	}
}