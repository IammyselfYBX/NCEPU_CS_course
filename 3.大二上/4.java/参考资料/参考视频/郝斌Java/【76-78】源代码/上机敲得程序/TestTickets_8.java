/*
	2009��6��22��9:28:08
	����ĳ���:
		�����Ĳ���ͬһ��str����
		��TestTickets_7.java ���н����һ����
	
*/

class A implements Runnable
{
	public int tickets = 100;
	String str = new String("����");
		
	public void run()  
	{
		String str = new String("����");  //16��  ���Զ���һ���ֲ��������þֲ����������ֺ���������ͬ
		
		while (true)
		{
			synchronized (str)  //�����Ĳ���ͬһ��str����  ��ʱ��str�Ǿֲ�����str������16�ж����str
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

public class TestTickets_8
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