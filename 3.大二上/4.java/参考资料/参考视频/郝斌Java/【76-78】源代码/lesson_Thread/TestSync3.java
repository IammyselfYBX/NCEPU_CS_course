/*
	��ȷ��������д�����Ʊ����
*/

public class TestSync3
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
	
	public void run()    
	{
 		synchronized (this)
 		{
			while (true)  
			{
				if (tickets > 0)
				{
					System.out.printf("%s�߳�����������%d��Ʊ!\n", 
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