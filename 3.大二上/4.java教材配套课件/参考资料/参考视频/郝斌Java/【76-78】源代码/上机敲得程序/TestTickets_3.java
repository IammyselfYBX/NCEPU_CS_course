/*
	用创建线程的第一种方式 来买票
	本程序运行OK
*/

class A extends Thread
{
	public static int tickets = 100;  //static不能省
	public static String str = new String("哈哈");  //static不能省
		
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

public class TestTickets_3
{
	public static void main(String[] args)
	{
		A aa1 = new A();
		aa1.start();	
			
		A aa2 = new A();
		aa2.start();		
	}
}