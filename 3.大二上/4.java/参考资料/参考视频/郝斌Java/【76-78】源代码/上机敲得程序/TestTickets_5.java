/*
	2009��6��22��9:28:08
	����ĳ���:
		ֻ��һ����Ʊ������Ʊ	
*/

class A implements Runnable
{
	public int tickets = 100;
	String str = new String("����");
		
	public synchronized void run()  //void ǰ�治�ܼ�synchronized ����ᵼ��ֻ��һ����Ʊ������Ʊ
	{
		while (true)
		{
//			synchronized (str)
//			{
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
			//}
		}
	}
}

public class TestTickets_5
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