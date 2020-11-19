class A extends Thread
{
	public void run()
	{
		System.out.println("AAAA");		
	}
	
	public void g()
	{
	}
}

public class TestThread_2
{
	public static void main(String[] args)
	{
		A aa = new A();
		aa.start(); //aa.start(); 会自动调用run方法
		aa.start();
		System.out.println("BBBB");
	}
}
