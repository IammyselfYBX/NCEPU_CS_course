class A
{
	int add(int i, int j)
	{
		return i+j;
	}
	
	//�����������ֻ�Ǻ����ķ���ֵ��һ����������һ�����⹹���ɺ��������أ����ұ���ʱ�ᱨ��
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
	��JDK 1.6�е����н���ǣ�
-------------------
3
3.660000
-------------------
*/