/*
	错误的程序
*/

class A implements Runnable
{
	public static int tickets = 100;
		
	public void run()
	{
		while (true)
		{
			if (tickets > 0)
			{
				System.out.printf("%s线程正在卖出第%d张票\n",
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

public class TestTickets
{
	public static void main(String[] args)
	{
		A aa1 = new A();
		Thread t1 = new Thread(aa1);
		t1.start();	
		
		A aa2 = new A();
		Thread t2 = new Thread(aa2);
		t2.start();		
	}
}