public class TestShutThread
{
	public static void main(String[] args)
	{
		A aa = new A();
		Thread tt = new Thread(aa);
		tt.start();
		
		try
		{
			Thread.sleep(5000);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}		
		
		aa.shutDown();
	}	
}

class A implements Runnable
{
	private boolean flag = true;
	
	public void run()
	{
		while (flag)
		{
			System.out.println("AAAA");
			  
		}
	}
	
	public void shutDown()
	{
		this.flag = false;
	}
}