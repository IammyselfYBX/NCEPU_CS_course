class DivisorIsZeroException extends Exception
{
	public DivisorIsZeroException(String errorMessage)
	{
		super(errorMessage);
	}
}

class A
{
	int divide(int a, int b) throws DivisorIsZeroException
	{
//		try
//		{
//			if (0 == b)
//				throw new DivisorIsZeroException("��������Ϊ��!");
//		}
//		catch (DivisorIsZeroException e)
//		{
//			e.printStackTrace();
//		}
			
		if (0 == b)
			throw new DivisorIsZeroException("��������Ϊ��!");
		int m = a / b;
		return m;
	}
}

public class TestA
{
	public static void main(String[] args)
	{
		A aa = new A();
		//aa.divide(6, 2);
	}
}