class A extends Thread
{
	public void run()
	{
		g();
		while (true)
		{
			System.out.println("AAAA");
		}			
	}
	
	public void g()
	{
	}
}

public class TestThread_1
{
	public static void main(String[] args)
	{
		A aa = new A();
		aa.start(); //aa.start(); 会自动调用run方法
		//aa.start();
		while (true)
		{
			System.out.println("BBBB");
		}
	}
}
