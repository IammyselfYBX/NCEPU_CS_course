public class TestSleep_3
{
	public static void main(String[] args)
	{
		A aa = new A();
		Thread tt = new Thread(aa);
		tt.start();	
	}
}
class A implements Runnable
{
	public void run() //throws Exception
	{ //9ÐÐ	
		for (int i=0; i<2; ++i)
		{
			System.out.println(Thread.currentThread().getName() + "   " + i);
			try
			{
 				Thread.sleep(1000); 
                                                    
			}catch (Exception e)
			{  
			}
			//Thread.sleep(1000);			
		}
	}
}
