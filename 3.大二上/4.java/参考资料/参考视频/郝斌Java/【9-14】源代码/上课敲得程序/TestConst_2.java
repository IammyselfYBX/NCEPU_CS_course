class A
{
	private int i;
	private int j;
	

	public A()
	{
		//System.out.printf("嘿嘿!\n\n");
	}
	
	//构造函数		
	public A(int a, int b)
	{
		i = a;
		j = b;
		System.out.printf("无参构造函数被调用了!\n");
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