/*
	假设A是抽象类
	new A()
	{
		实现了A类的所有抽象类的方法代码
		添加自己的方法或属性代码【不建议，因为没有实际意义】
	}	
	
	功能： 生成一个匿名类，该匿名类必须得实现了A类的所有抽象方法，
		   当然该匿名类也可以定义自己的属性和方法
*/

abstract class A
{
	abstract public void f();
		
	public void g()
	{
	}
}

public class TestAnonyClass_2
{
	public static void main(String[] args)
	{
		A aa = new A()
			{
				//f方法不可以被注释掉, 因为f是抽象方法，匿名类必须的实现
				public void f()
				{
					System.out.println("FFFF");
				}
				
				//g方法可以被注释掉
				public void g()
				{
					System.out.println("GGGG");
				}
				
				public void k()
				{
				}
			};
		
		aa.f();
		aa.g();
		//aa.k();  
	}
}
/*
	在JDK 1.6中的运行结果是：
-----------------------------
FFFF
GGGG
-----------------------------
*/