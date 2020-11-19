class A
{
	public int i = 10;
	public int j = 20;
	
	public void show()
	{
		System.out.printf("%d\n", i);
	}
}

class M
{
	public static void main(String[] args)
	{
		A aa1 = new A();
		A aa2 = new A();
		aa1.show();
		aa2.show();
	}
}