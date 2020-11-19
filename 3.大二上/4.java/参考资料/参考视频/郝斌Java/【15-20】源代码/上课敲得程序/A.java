class A
{
	private int i = 10;
	
	private void f()
	{
		System.out.printf("%d\n", i);
		g();
	}
	
	public void g()
	{
	}
	
}

class M
{
	public static void main(String[] args)
	{
		A aa = new A(); 
		//System.out.printf("%d\n", aa.i);  //error
		//aa.f();  //error
	}
}