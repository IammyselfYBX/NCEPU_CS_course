class A
{
	int divide(int a, int b)  
	{
		int m;
		//System.out.printf("22222\n");
		m = a / b;
		//System.out.printf("11111\n");
		return m;
	}
}

public class TestExcep_1
{
	public static void main(String[] args)
	{
		A aa = new A();
		
		//aa.divide(6, 0);
		
		try
		{
			aa.divide(6,2);
		}
		catch (ArithmeticException e)  //e��������23���׳����쳣����
		{
			e.printStackTrace(); //���Լ����Ϊ ������쳣�ľ�����Ϣ
			System.out.printf("������� ��ĳ���������� ��������Ϊ�㣬 �ٺ�!\n");
		}		
		
		System.out.printf("�����Һܸ��ģ���Ϊ�Һ�����Ĺ�ϵ�ͺ�г!\n");
	}
}