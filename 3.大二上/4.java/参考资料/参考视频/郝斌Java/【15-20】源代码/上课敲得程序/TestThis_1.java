class A
{
	public int i;
	
	public A(int j)
	{
		i = j;
	}

	public void show()  //this������ǵ�ǰ���ڵ���show�����Ķ���
	{
		System.out.printf("i = %d\n", i); //i���Ի���this.i
	}
}

public class TestThis_1
{
	public static void main(String[] args)
	{
		A aa1 = new A(10);
		A aa2 = new A(20);
		aa1.show();// aa1.show(aa1);
		aa2.show();// aa2.show(aa2);
	}
}