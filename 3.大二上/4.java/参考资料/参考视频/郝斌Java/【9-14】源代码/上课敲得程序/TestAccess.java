class A
{
	private int i;
	public int j;
	protected int m;
	
	private void f()
	{
		i = 1;
		j = 2;
		m = 3;
		//k();
		g(); 
	}
	
	protected void k()
	{
	}
	
	public void g()
	{
		i = 1;
		j = 2;
		m = 3;
		f();
		k();		
	}
}

class TestAccess
{
	public static void main(String[] args)
	{
		A aa = new A();
		//aa.i = 10;  //error ��Ϊi��˽�е�
		//aa.j = 20;  //OK  ��Ϊj��public
		//aa.m = 22;   //OK ��Ϊm��protected 
		
		//aa.f();
		aa.g();
	}
}