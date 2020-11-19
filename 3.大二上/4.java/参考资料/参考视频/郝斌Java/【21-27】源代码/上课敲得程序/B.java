class  A
{
	public  int i = 10;
	static int j = 20;
	
	public void f()
	{
		i = 88;
	}
	
}

class M
{
	public static void main(String[] args)
	{
		A aa1 = new A();
//		A aa2 = new A();
//		aa1.j = 40;
//		System.out.printf("%d\n", aa2.j);	
		//System.out.printf("%d\n", A.j);	
		System.out.printf("%d\n", aa1.j);	
	}
}