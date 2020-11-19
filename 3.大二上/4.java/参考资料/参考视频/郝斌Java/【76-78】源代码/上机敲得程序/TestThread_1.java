class A extends Thread
{
	public void run()
	{
		while (true)
		{
			System.out.println("AAAA");
		}
	}	
}

public class TestThread_1
{
	public static void main(String[] args)
	{
		A aa = new A();
		aa.start();
		
		//Thread t = new Thread(aa);
		while (true)
		{
			System.out.println("BBBB");
		}
	}
	
}