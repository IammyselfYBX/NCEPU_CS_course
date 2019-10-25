class A
{
	public int i;
	
	public A(int j)
	{
		i = j;
	}
	
	public void show()
	{
		System.out.println("i = " + i);
	} 
}

class TestThis1
{
	public static void main(String[] args)
	{
		A aa1 = new A(5);
		A aa2 = new A(8);
		aa1.show();
		aa2.show();
	}
}