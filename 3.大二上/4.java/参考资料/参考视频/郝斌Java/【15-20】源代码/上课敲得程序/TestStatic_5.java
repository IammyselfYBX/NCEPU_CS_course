/*
	2009��5��29��15:14:29
	������֤����:
		��̬�������ܷ��ʷǾ�̬��Ա
		�Ǿ�̬�������Է��ʾ�̬��Ա
*/

class A
{
	private static int i = 10;
	public int j = 99;

	public static void f()  
	{
		//g();  //error ��̬�������ܷ��ʷǾ�̬��Ա
		//j = 22; //error
		System.out.printf("FFFF\n");
	}
	
	public void g()
	{
		//f();  //OK ˵���Ǿ�̬�������Է��ʾ�̬��Ա
		System.out.printf("GGGG\n");
		System.out.printf("%d\n", i);
	}
}

class TestStatic_5
{
	public static void main(String[] args)
	{
		A aa = new A();
		//aa.g();
		aa.f();
		
		//A.g(); //error
	}
}