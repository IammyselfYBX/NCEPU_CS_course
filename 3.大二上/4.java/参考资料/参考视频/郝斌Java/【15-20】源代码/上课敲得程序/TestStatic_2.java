/*
	2009��5��29��15:14:29
	������֤����: static����i�������౾�����߽���û�ж���������Ȼ����ֱ��ͨ�������ķ�ʽ���ʸ����ڲ���static����
				  static����gͬ��
*/

class A
{
	public static int i = 10;

	public static void f()
	{
		System.out.printf("2009��5��29��15:15:50");
	}
}

class TestStatic_2
{
	public static void main(String[] args)
	{
		System.out.printf("%d\n", A.i);
		A.f();
	}
}