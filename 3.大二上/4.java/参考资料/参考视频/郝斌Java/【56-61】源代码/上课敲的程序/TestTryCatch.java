/*
	2009��3��14��9:34:11
	��catch�����쳣��catch�����쳣
	�����catch�����쳣��catch�����쳣�������ʱ�ᱨ��
*/

class A extends Exception
{
}

class B extends A
{
}

class C extends B
{
}

class M
{
	public void compare(int i, int j) throws A,B
	{
		if (i > j)
			throw new A();
		else
			throw new B();
	}
}

public class TestTryCatch
{
	public static void main(String[] args)
	{
		M mm = new M();
		try
		{
			mm.compare(-4, 1);
		}
		catch (B bb)
		{
			System.out.println("��߲���С���ұ�");
		}
		catch (A aa)
		{
			System.out.println("��߲��ܴ����ұ�");
		}
	}
}