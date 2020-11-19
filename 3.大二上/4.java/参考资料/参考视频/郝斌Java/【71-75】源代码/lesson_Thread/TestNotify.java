/*
	2009��2��7��20:58:11
	this.notify();
	����:
		���ǽ�������ִ��this.notify();�ĵ�ǰ�߳�
		���ǽ���һ����������wait  this����������̣߳�����ж���߳�����wait this����
		ͨ���ǽ�������wait this������߳�,�������ǽ�����һ����
		������ϵͳ���������ƣ�����Ա�޷����� 		
	
	����Ҫע�⣺
		����������T1 T2 T3 T4 �ĸ��߳�
		
		��T4�߳��е�����
			aa.notify()
		�����ʱT1 T2 T3 û��һ���߳���Ϊwait aa�������������״̬�� 
		T4�߳���ִ��aa.notify����ʱҲ�������κδ���
		�������֤������һ��	
	
*/

public class TestNotify
{
	public static void main(String[] args)
	{
		A aa = new A();
		Thread tt = new Thread(aa);
		tt.start();
		System.out.println("����!");
	
	
		ThreadRun tr = new ThreadRun();
		new Thread(tr).start();
		new Thread(tr).start();
		new Thread(tr).start();
		new Thread(tr).start();
		new Thread(tr).start();
		new Thread(tr).start();		
	}
}

class A implements Runnable
{
	public synchronized void run()  //���ȥ����synchronized ��ᱨ��ֻ����ͬ��������ͬ�������вſ���ʹ��notify����
	{
		int cnt = 0;
		
		while (cnt < 20)
		{
			cnt++;
			System.out.println("AAAA" + cnt);
			try
			{
				this.notify(); //�����ʱ�кܶ��߳���Ϊ wait this�������������״̬����������е�һ��,���ھ����ǽ�����һ��������ϵͳ������ȷ��������Ա�޷�����
						  //������֤���ˣ������ʱû���κ��߳���Ϊ  wait this�������������״̬��Ҳ���Ե���notify����	
			}
			catch (IllegalMonitorStateException e)
			{
				System.out.println("�ڷ�ͬ������ ��ͬ��������е�����notify����");
				System.exit(-1);
			}
		}	
	}
} 

class ThreadRun implements Runnable
{
	private int tickets = 100;
	
	public void run()
	{
		while (true)
		{
			synchronized (this)
			{
				if (tickets > 0)
				{
					System.out.printf("%s�߳���������%d��Ʊ!\n", 
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