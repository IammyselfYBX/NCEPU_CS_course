class B
{
	public int i;
	
	public B(int i)
	{
		this.i = i;
	}
	
	public boolean equals(Object ob)
	{
		B bb = (B)ob;
		
		if (this.i == bb.i)
			return true;
		else
			return false;
	}
}

public class TestB
{
	public static void main(String[] args)
	{
		//new B().toString(); 
		B bb1 = new B(2);
		B bb2 = new B(3);
		System.out.println(bb1.equals(bb2));
	}
}