class A extends Thread
{
	public void run()
	{
		while (true)
		{
			System.out.println("AAAA\n");
		}
	}
}

public class TestThread_1
{
	public static void main(String[] args)
	{
		A aa = new A();
		//aa.run();
		aa.start();
		//aa.start();
		
		while (true)
		{
			System.out.println("BBBB\n");
		}
	}
}