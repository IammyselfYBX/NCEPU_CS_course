class A
{
	private int i;
	private static int cnt = 0;
	
	public A()
	{
		++cnt;
	}
	
	public A(int i)
	{
		this.i = i;
		++cnt;
	}
	
	public static int getCnt()
	{
		//return 返回的是A对象的个数;
		return cnt;
	}
}

public class TestStatic_1
{
	public static void main(String[] args)
	{
		System.out.printf("当前时刻A对象的个数是: %d\n", A.getCnt());
		A aa1 = new A();
		System.out.printf("当前时刻A对象的个数是: %d\n", A.getCnt());
		A aa2 = new A();
		System.out.printf("当前时刻A对象的个数是: %d\n", A.getCnt());
		
	}
}