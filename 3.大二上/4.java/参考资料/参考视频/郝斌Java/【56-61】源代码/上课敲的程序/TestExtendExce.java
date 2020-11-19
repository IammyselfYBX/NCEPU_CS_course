/*
	2009年1月21日21:55:05
	子类覆盖了基类方法时，
	子类方法抛出异常的范围不能大于基类方法抛出的异常范围
	子类方法可以不抛出异常，也可以只抛出基类方法的部分异常
	但不可以抛出基类方法以外的异常
*/


//自定义异常A
class A extends Exception
{
}

//自定义异常B
class B extends Exception
{
}

//自定义异常C
class C extends Exception
{
}

class M
{
	void f() throws A, B
	{
	}
}

class N extends M
{
	void f() throws A,B //可以throws A或B,也可以throws A,B  也可以不throws，但不可以throws C  即"子类覆盖了基类方法时，子类方法抛出异常的范围不能大于基类方法抛出的异常范围"
	{
	}
}

class Test
{
	public void k(M mm)
	{
		try
		{
			mm.f();
		}
		catch (A aa)
		{
		}
		catch (B bb)
		{
		}		
	}
}

class TestExtendExce
{
	public static void main(String[] args)
	{
		M m = new M();
		N n = new N();
		
		//System.out.println("1111");
	}
}
/*
	在JDK 1.6中的运行结果是：
--------------------------
1111
--------------------------
*/