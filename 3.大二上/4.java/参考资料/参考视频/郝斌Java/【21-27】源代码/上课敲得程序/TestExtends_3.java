/*
	2009��5��31��14:59:26
	������֤����:
		1�� �����ڲ����Է��ʸ����˽�еĳ�Ա
			˽�г�Ա�޷������෽������
		
		2�� ͨ�����������ֻ�ܷ��ʴӸ���̳й����ķ�˽�г�Ա
		
	�ܽ᣺	
		˽�в��ܱ��̳�
		˽���������Ѿ����̳й�����ֻ�����߼��ϳ���Ա����ȥ������
		��˼̳б������أ�������˷��ڴ�		
*/

class A
{
	public int i;
	protected int j;
	private int k;
	
	public void g()
	{
	}	
	
	private void s()
	{
	}
	
	protected void b()
	{
	}
}

class B extends A
{
	private void m()
	{
		i = 10;
		j = 20;
		//k = 30; //error ˽�����Բ��ܱ��̳�
		
		g();
		b();
		//s(); // error ˽�з������ܱ��̳�
	}
	
	public void f()
	{
		i = 10;
		j = 20;
		//k = 30; //error ˽�����Բ��ܱ��̳�
		
		g();
		b();
		//s(); // error ˽�з������ܱ��̳�
	}
}

class M
{
	public static void main(String[] args)
	{
		B bb = new B();
		bb.i = 20;
		bb.j = 30;
		bb.b();
		bb.g();
		
		//bb.s(); //error
		//bb.k = 22;
		
		
	}
}