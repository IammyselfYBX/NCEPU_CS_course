/*
	2009年6月22日10:19:26
	正确的程序
*/

class A implements Runnable
{
	public int tickets = 100;
	String str = new String("哈哈");
		
	public void run()  
	{
		String str = "哈哈";  
		
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

public class TestTickets_9
{
	public static void main(String[] args)
	{
		A aa = new A();
		Thread t1 = new Thread(aa);
		t1.start();	
		
		Thread t2 = new Thread(aa);
		t2.start();	
			
	}
}