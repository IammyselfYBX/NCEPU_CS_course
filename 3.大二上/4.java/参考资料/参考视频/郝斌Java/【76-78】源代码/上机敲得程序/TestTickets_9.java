/*
	2009��6��22��10:19:26
	��ȷ�ĳ���
*/

class A implements Runnable
{
	public int tickets = 100;
	String str = new String("����");
		
	public void run()  
	{
		String str = "����";  
		
		while (true)
		{
			synchronized (str)  
			{
				if (tickets > 0)
				{
					System.out.printf("%s�߳�����������%d��Ʊ\n",
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