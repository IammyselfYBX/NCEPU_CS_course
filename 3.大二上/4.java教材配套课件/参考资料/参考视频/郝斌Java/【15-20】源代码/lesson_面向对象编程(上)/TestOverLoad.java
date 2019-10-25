class A
{
	int add(int i, int j)
	{
		return i+j;
	}
	
	//如果两个函数只是函数的返回值不一样，其他都一样，这构不成函数的重载，并且编译时会报错！
//	double add(int i, int j)
//	{
//		return 6.0;
//	}
	
	int add(int i, int j, int k)
	{
		return i + j + k;
	}
	
	double add(int i, double x, int j)
	{
		return i + x + j;
	}
}

public class TestOverLoad
{
	public static void main(String[] args)
	{
		A aa = new A();
		System.out.printf("%d\n", aa.add(1,2));
		System.out.printf("%f\n", aa.add(1, 0.66, 2));
	}
}
/*
	在JDK 1.6中的运行结果是：
-------------------
3
3.660000
-------------------
*/