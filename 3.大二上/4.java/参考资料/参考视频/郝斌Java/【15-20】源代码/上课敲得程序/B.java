class B
{
	public int i = 10;
	
	public void show()
	{
		System.out.printf("%d\n", i);
	}
}

class M
{
	public static void main(String[] args)
	{
		B bb1 = new B();
		B bb2 = new B();
//		bb1 = bb2;
//		bb1.i = 20;
//		bb2.show();
		bb1.i = 20;
		bb2.show();	
	}
}