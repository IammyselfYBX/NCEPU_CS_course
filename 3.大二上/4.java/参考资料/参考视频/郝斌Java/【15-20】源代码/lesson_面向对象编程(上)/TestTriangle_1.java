public class TestTriangle_1
{
	public static int zhouchang(int i, int j, int k)
	{
		return (i + j + k);
	}
	
	public static double area(int i, int j, int k)
	{
		double p = 1.0 * (i+j+k) / 2;
		return Math.sqrt(p * (p-i) * (p-j) * (p-k));
	}
	
	public static int f(int i, int j, int k)
	{
		return i * j * k * 3 * 2 - 1;
	}
	
	public static void main(String[] args)
	{
		int m, n, r;
		m = 3;
		n = 4;
		r = 5;
		
		System.out.printf("三角形的面积是: %f\n", area(m, n, r));
		System.out.printf("三角形的周尝试: %d\n" , zhouchang(m, n, r));
		
		f(m, n, r);
	}
}