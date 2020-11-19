class A
{
	int i = 10;
	int j = 20;
}

public class TCS
{
	public static void main(String[] args)
	{
		A aa1 = new A(); 
		A aa2 = aa1;
		
		aa1.j = 99;
		System.out.printf("%d\n", aa2.j);
	}
}
