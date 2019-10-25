class A
{
	public int i;
	
	public A(int i)
	{
		this.i = i;
	}
	
	public boolean equals(Object ob)
	{
		A aa = (A)ob;
			
		return this.i == aa.i;
	}
	
//	public int hashCode()
//	{
//		
//	}
}

class M
{
	public static void main(String[] args)
	{
		A aa1 = new A(2);
		A aa2 = new A(2);
		if (aa1 == aa2)
			System.out.println("aa1 == aa2");
		else
			System.out.println("aa1 != aa2");
			
		System.out.println(aa1.equals(aa2));  //	
		System.out.println(aa1.hashCode());
	}
}