/*
	����������£�
		��һ�� ����i �� flag��ֵ
		�ڶ����� ��i�� flag ��ֵ
		����������ӹ��캯��
*/

class A
{
	private int i = 5;  
	boolean flag = true;
	
	public A(int j, boolean f)
	{
		i = j;
		flag = f;
	}
	
	public void show()
	{	
		System.out.println(i + ",  " + flag);
	}
}

public class TestConst_2
{
	public static void main(String[] args)
	{
		new A(8, false).show();
	}
}
/*
	��JDK 1.6�е����н���ǣ�
-----------------
8,  false
-----------------
*/