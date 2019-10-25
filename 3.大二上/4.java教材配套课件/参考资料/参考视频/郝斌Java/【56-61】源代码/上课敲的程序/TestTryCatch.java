/*
	2009年3月14日9:34:11
	先catch子类异常再catch父类异常
	如果先catch父类异常再catch子类异常，则编译时会报错
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
			System.out.println("左边不能小于右边");
		}
		catch (A aa)
		{
			System.out.println("左边不能大于右边");
		}
	}
}