class TestOver
{
	static int add(int a, int b)
	{
		return a + b;
	}
//	
//	static double add(int a, int b)
//	{
//		return a + b;
//	}
	
	static double add(double x, double y)
	{
		return x + y;
	}
		
	static int add(int a, int b, int c)
	{
		return a + b + c;
	}
	
	static int add(int a, int b, int c, int d)
	{
		return a + b + c + d;
	}
	
	
	public static void main(String[] args)
	{
		System.out.printf("%f\n", add(1.3,2.6));
		System.out.printf("%d\n", add(1,2,3, 4));
		
		System.out.printf("¹ş¹ş");
	}
}