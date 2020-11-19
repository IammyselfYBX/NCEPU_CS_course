class A
{
	public static int i;
	protected static int j;
	private static int k;
}

class B extends A
{
	private void g()
	{
		i = 22;
		//k = 20;
	}
}

class M
{
	public static void main(String[] args)
	{
		A.i = 99;
		//A.k = 99;  //error
		B.i = 99;
		//B.k = 99; //error
		
		B bb = new B();
		bb.i = 99;
		//bb.k = 99; //error
	}
}