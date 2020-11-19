/*
	2009��2��6��19:54:30
	String �������������߳�ͬ������
*/

public class TestSync2
{
	public static void main(String[] args) throws Exception
	{
		A aa = new A();
		Thread t1 = new Thread(aa);
		Thread t2 = new Thread(aa);
		Thread t3 = new Thread(aa);
		Thread t4 = new Thread(aa);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

class A implements Runnable
{
	private int tickets = 100;
		
	public void run()
	{
		String str = new String("123");
		synchronized (str)
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