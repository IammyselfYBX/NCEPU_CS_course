interface It
{
	void f();
}

class A implements It
{
	public void f()
	{
		System.out.printf("AAAA");
	}
	
	public void g()
	{
	}
}

class D
{
	public static void main(String[] args)
	{	
		//int i;
		It it;
		it = new A();
		it.f();	
		
		//it.g(); //error	
		//It it2 = new It(); //error
			
	}
}