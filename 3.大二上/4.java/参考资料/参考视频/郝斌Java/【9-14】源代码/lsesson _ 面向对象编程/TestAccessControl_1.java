/*
	2009��2��10��15:39:18
	��һ������ڲ������еĳ�Ա�����໥����,���ʿ��Ʒ�������ⲿ���ʶ��Ե�

*/

class A
{
	public int i = 10;
	private int j = 20;
	
	public void f()
	{
		i = j = 111;
		g();
	}	
	
	private void g()
	{
		j = i = 222;
		f();
	}
}

public class TestAccessControl_1
{
	public static void main(String[] args)
	{
		System.out.println("2009��2��10��15:30:43");
	}
}