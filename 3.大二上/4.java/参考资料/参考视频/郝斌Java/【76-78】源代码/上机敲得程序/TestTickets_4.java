/*
	�ô����̵߳ĵ�һ�ַ�ʽ ����Ʊ
	����ĳ���:
		����ÿ��Ʊ����������
*/

class A extends Thread
{
	public int tickets = 100;  //��Ϊ����û�м�static�����Ե���ÿ��Ʊ����������
	public static String str = new String("����");
		
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