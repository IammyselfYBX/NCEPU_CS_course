class A
{
	private int i;
	private int j;
	

	public A()
	{
		//System.out.printf("�ٺ�!\n\n");
	}
	
	//���캯��		
	public A(int a, int b)
	{
		i = a;
		j = b;
		System.out.printf("�޲ι��캯����������!\n");
	}
	
	public void show()
	{
		System.out.printf("i = %d, j = %d\n", i, j);
	}
}

class TestConst_2
{
	public static void main(String[] args)
	{
		A aa = new A(1, 2);
		//A aa2 = new A(1,2,3);  //error
		A aa3 = new A();
//		
//		//System.out.printf("%d  %d\n", aa.i, aa.j);
//		aa.show();
	}
}