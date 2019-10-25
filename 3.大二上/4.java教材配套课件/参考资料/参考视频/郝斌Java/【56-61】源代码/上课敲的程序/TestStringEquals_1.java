class A
{
	public int i;
	
	public A(int i)
	{
		this.i = i;
	}
}

public class TestStringEquals_1
{
	public static void main(String[] args)
	{
		A aa1 = new A(2);
		A aa2 = new A(2);
		
		System.out.println( aa1.equals(aa2) );
		
		if (aa1 == aa2)
			System.out.printf("aa1和aa2相等\n");
		else
			System.out.printf("aa1和aa2不相等\n");
			
//		System.out.println(aa1); //A@
//		System.out.println(aa2); //A@ 
	}
}