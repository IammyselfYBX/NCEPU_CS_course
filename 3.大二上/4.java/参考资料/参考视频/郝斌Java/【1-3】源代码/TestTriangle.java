//java中的函数也叫做方法 方法逻辑意义代表的就是一个事物可以执行的操作
class Triangle
{
	int a;
	int b;
	int c;
	
	int zhouchang() //不需要定义形参，因为zhouchang函数和属性a b c是一个有机整体，彼此当然可以相互访问
	{
		return a + b + c;
	}
	
	double area() 
	{
		double p = 1.0*(a+b+c) / 2;
		return Math.sqrt(p * (p-a) * (p-b) * (p-c));
	}
};

class TestTriangle
{
	public static void main(String[] args)
	{
//		int i;
//		
//		int * p = (int *)malloc(sizeof(int));
//		A * q = (A *)malloc(sizeof(A));
//		
//		
//		Triangle * r = (Triangle * )malloc(sizeof(Triangle));
		Triangle s = new Triangle();
		
		s.a = 3;
		s.b = 4;
		s.c = 5;
		
		System.out.printf("%d    %f\n", s.zhouchang(), s.area());
						//在java中double 和 float 都用%f输出
						//在C中,double用%lf输出, float 用%f输出	
	
		//zhouchang();
	}
}

