//java�еĺ���Ҳ�������� �����߼��������ľ���һ���������ִ�еĲ���
class Triangle
{
	int a;
	int b;
	int c;
	
	int zhouchang() //����Ҫ�����βΣ���Ϊzhouchang����������a b c��һ���л����壬�˴˵�Ȼ�����໥����
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
						//��java��double �� float ����%f���
						//��C��,double��%lf���, float ��%f���	
	
		//zhouchang();
	}
}

