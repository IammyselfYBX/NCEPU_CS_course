/*
	�ô����̵߳ĵ�һ�ַ�ʽ ����Ʊ
	����������OK
*/

class A extends Thread
{
	public static int tickets = 100;  //static����ʡ
	public static String str = new String("����");  //static����ʡ
		
	public void run()
	{
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