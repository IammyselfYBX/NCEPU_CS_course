/*
	2009��2��10��15:11:02
	��̬����ֻ�ܷ�����ľ�̬��Ա��
	���Ǿ�̬����ȴ���Է����������г�Ա��������̬��Ա
*/
class A
{
	public static int i;
	public int j;
	
	public static void f()
	{
		//g();  //error ��̬�������ܷ��ʷǾ�̬����
		i = 10; //OK
		//j = 99;  //error  ��̬�������ܷ��ʷǾ�̬����
	}
	
	public void g()
	{
		f();  //OK
		i = 20;  //OK
	}
}

public class TestStatic_2
{
	public static void main(String[] args)
	{
		System.out.println("2009��2��10��15:06:07");
	}
}