/*
	2009年2月6日19:54:30
	String 对象所带来的线程同步问题
*/

public class TestSync1
{
	public static void main(String[] args) throws Exception
	{
		A aa = new A();
		Thread t1 = new Thread(aa);
		Thread t2 = new Thread(aa);
		
		t1.start();
		Thread.sleep(10);
		t2.start();
	}
}

class A implements Runnable
{
	private int tickets = 100;
	String str = new String("123");
	
	public void run()
	{
		synchronized (str)
		{
			while (true)
			{
				if (tickets > 0)
				{
					System.out.printf("%s线程正在卖出第%d张票!\n", 
								Thread.currentThread().getName(), tickets);
					--tickets;
				}
				else
				{
					break;
				}			
			}
		}
	}
}