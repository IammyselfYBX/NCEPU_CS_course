/*
	2009��2��10��17:45:28
	ͬ���̳�Ȩ������
*/

class A
{
	private int s;
	int m;
	public int g;
	protected int b;
	
	private void fs()
	{
	}
	
	public void fg()
	{
	}
	
	void fm()
	{
	}
	
	protected void fb()
	{
	}
}

class B extends A
{
	//��������з����ڲ������Է��ʸ����˽�г�Ա��������г�Ա
	private void g()
	{
		m = g = 10;
		fg();
		fm();
		fb();
		//s = 10;  //error
		//fs();  //error
	}
}

public class TestExtends_2
{
	public static void main(String[] args)
	{
		B bb = new B();
		
		//ͨ��������������Է��ʸ����˽�г�Ա������г�Ա
		bb.g = bb.b = bb.m = 22;
		
		//bb.s = 11;  //error
		//bb.fs();  //error
		
		bb.fg();
		bb.fm();
		bb.fb();
		
		System.out.println("2009��2��10��17:44:37");	
	}
}