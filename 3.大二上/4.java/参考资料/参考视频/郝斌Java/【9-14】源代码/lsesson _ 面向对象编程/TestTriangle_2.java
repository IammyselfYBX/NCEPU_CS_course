class Triangle
{
	private int a, b, c;
	
	//设置三边长度
	public void setTriangle(int i, int j, int k)
	{
		a = i;
		b = j;
		c = k;
	}
	
	//求周长
	public int zhouchang()
	{
		return (a+b+c);
	}
	
	//求面积
	public double area()
	{
		double p = 1.0 * (a+b+c)/2;
		return Math.sqrt(p * (p-a) * (p-b) * (p-c));		
	}	
}

public class TestTriangle_2
{
	public static void main(String[] args)
	{
		Triangle t = new Triangle();
		t.setTriangle(3, 4, 5);
		System.out.printf("三角形的面积是: %f\n", t.area());
		System.out.printf("三角形的周尝试: %d\n" , t.zhouchang());
		
	}
}