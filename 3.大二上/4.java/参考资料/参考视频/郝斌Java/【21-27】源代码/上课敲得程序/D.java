/*
	2009��5��31��14:05:02
	������֤����: һ��������Կ����Ǹ������
*/

class A
{
	public void f()
	{
		System.out.printf("����\n");
	}
}

class C
{
	public int i = 10;
	public A aa = new A();  //aaһ���Ǹ�����, aa�Ƿ�Ҳ��C�����ԣ� ��

	public void g()
	{
		aa.f();
	}
}

class M
{
	public static void main(String[] args)
	{
		C cc = new C();
		cc.g();
	}	
}