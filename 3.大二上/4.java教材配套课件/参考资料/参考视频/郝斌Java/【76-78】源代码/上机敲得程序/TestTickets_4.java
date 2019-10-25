/*
	用创建线程的第一种方式 来买票
	错误的程序:
		导致每张票被卖了两次
*/

class A extends Thread
{
	public int tickets = 100;  //因为这里没有加static，所以导致每张票被卖了两次
	public static String str = new String("哈哈");
		
	public void run()
	{
		while (true)
		{
			synchronized (str)
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
}

public class TestTickets_4
{
	public static void main(String[] args)
	{
		A aa1 = new A();
		aa1.start();	
			
		A aa2 = new A();
		aa2.start();		
	}
}