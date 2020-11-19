class A implements Runnable
{
	public void run()
	{
		while (true)
		{
			System.out.println("AAAA");
		}
	}	
}

public class TestThread_2
{
	public static void main(String[] args)
	{
		A aa = new A();
		//aa.start();
		
		Thread t = new Thread(aa);
		t.start();
		while (true)
		{
			System.out.println("BBBB");
		}
	}
	
}