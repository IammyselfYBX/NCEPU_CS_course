/*
	2009年1月21日17:09:38
	自定义异常
*/

class DivisorIsMinusException extends Exception
{
	public DivisorIsMinusException(String message)
	{
		super(message); //实际是调用Exception 的构造函数 public Exception(String message)
	}	
}

class HH
{
	public void f(int a, int b) throws DivisorIsMinusException
	{
		if (b < 0)
			throw new DivisorIsMinusException("除数不能为负数!");
	}
}

class Excep_3
{
	public static void main(String[] args)
	{
		HH h = new HH();
		try
		{
			h.f(3, -2);
		}
		catch (DivisorIsMinusException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("程序正常终止了!");
	}
}
/*
	在JDK 1.6中的运行结果是：
--------------------------
除数不能为负数!
程序正常终止了!
--------------------------
*/