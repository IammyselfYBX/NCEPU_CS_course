class Triangle
{
	private int a, b, c;
	
	//�������߳���
	public void setTriangle(int i, int j, int k)
	{
		a = i;
		b = j;
		c = k;
	}
	
	//���ܳ�
	public int zhouchang()
	{
		return (a+b+c);
	}
	
	//�����
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
		System.out.printf("�����ε������: %f\n", t.area());
		System.out.printf("�����ε��ܳ���: %d\n" , t.zhouchang());
		
	}
}