class Triangle
{
	int a, b, c;
	
	int zhouchang()
	{
		return a + b + c;
	}
	
	double area()
	{
		double p = 1.0*(a+b+c) / 2;
		return Math.sqrt(p * (p-a) * (p-b) * (p-c));
	}
}

class TestTriangle
{
	public static void main(String[] args)
	{
		Triangle t = new Triangle();

		t.a = 3;
		t.b = 4;
		t.c = 5;
		
		System.out.printf("%d %f\n", t.zhouchang(), t.area());
	}
}