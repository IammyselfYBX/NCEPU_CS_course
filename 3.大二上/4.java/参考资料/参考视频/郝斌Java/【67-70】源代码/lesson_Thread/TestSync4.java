public class TestSync4
{
	public static void main(String[] args)
	{
		ThreadRun tr = new ThreadRun();
		new Thread(tr).start();
		new Thread(tr).start();
		new Thread(tr).start();
		new Thread(tr).start();
		new Thread(tr).start();
		new Thread(tr).start();		
	}
}

class ThreadRun implements Runnable
{
	private int tickets = 100;
	
	public synchronized void run()   
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