class A
{
	private int i;
	private int j;
	
	public void set(int a, int b)
	{
		i = a;
		j = b;	
	}
	
	public A()
	{
		System.out.printf("�޲ι��캯����������!");
	}
	
	public void show()
	{
		System.out.printf("i = %d, j = %d\n", i, j);
	}
}

class TestConst_1
{
	public static void main(String[] args)
	{
		A aa = new A();
		//aa.show();
		
		
		
//		aa.set(1,2);
//		aa.i = 1;
//		aa.j = 2;
		
	}
}