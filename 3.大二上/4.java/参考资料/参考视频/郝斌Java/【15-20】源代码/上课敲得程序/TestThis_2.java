class A
{
	public int i = 99;
	
	public A(int i)
	{
		this.i = i; //this ����ǰʱ�����ڴ����Ķ���
		System.out.printf("%d\n", i);
	}
	
	public void show()
	{
		System.out.printf("%d\n", this.i);  //this �������ڵ���show�����Ķ���
	}
}

public class TestThis_2
{
	public static void main(String[] args)
	{
		A aa = new A(2);
		aa.show();
		//System.out.printf("%d\n", aa.i);	
	}	
}
