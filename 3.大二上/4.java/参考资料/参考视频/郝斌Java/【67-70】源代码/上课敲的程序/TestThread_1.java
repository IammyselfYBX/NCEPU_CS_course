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
		aa.start(); //aa.start(); ���Զ�����run����
		//aa.start();
		while (true)
		{
			System.out.println("BBBB");
		}
	}
}
