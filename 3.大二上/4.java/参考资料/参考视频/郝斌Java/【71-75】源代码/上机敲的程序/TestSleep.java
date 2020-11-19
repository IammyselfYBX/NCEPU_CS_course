public class TestSleep
{
	public static void main(String[] args)
	{
		A aa = new A();
		Thread tt = new Thread(aa);
		tt.start();	
		
		while (true)
		{
			System.out.println("込込");
		}			
	}
}
class A implements Runnable
{
	public void run()
	{ //9佩	
		for (int i=0; i<2; ++i)
		{
			System.out.println(Thread.currentThread().getName() + "   " + i);
//			System.out.println("込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込");
//			System.out.println("込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込");

			try
			{
 				Thread.sleep(1000); //佩  宸戦議Thread.sleep(1000)氏砺竃呟械,駅倬
                                                     //議序佩俺彌��音嬬壓9 議朔中耶紗 throws Exception
			}catch (Exception e)
			{  
			}
			
			System.out.println("込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込");
			System.out.println("込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込込");


		}
	}
}
