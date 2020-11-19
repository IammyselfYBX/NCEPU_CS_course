/*
	2009年6月21日13:56:15
	常见线程方法的介绍
*/

class A extends Thread
{
	public void run()
	{
		//System.out.println("AAAA");
		System.out.printf("%s在执行!\n", Thread.currentThread().getName());
	}
}

public class TestThread_3
{
	public static void main(String[] args)
	{
		A aa1 = new A();
		aa1.setName("张三");
		aa1.start();
		
		A aa2 = new A();
		aa2.start();
		
		A aa3 = new A();
		aa3.setName("李四");
		aa3.start();
		
		//System.out.println("BBBB");
		System.out.printf("%s在执行!\n", Thread.currentThread().getName());
	}
}