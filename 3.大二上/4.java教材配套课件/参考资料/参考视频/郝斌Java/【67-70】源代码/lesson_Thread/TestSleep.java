public class TestSleep
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
	public void run()   //13行
	{
		for (int i=0; i<10; ++i)
		{
			System.out.println(Thread.currentThread().getName() + "   " + i);
		
			try
			{
				Thread.sleep(1000); //21行  这里的Thread.sleep(1000)会抛出异常,必须的进行捕捉，不能在13行 的后面添加 throws Exception
			}
			catch (Exception e)
			{
			}
			
		}
	}
}