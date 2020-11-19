public class ProducerConsumer
{
	public static void main(String[] args)
	{
		SyncStack ss = new SyncStack();
		Producer p = new Producer(ss);
		Consumer c = new Consumer(ss);
		
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);
		
		t1.start();
		t2.start();
	}	
}

class SyncStack
{
	int cnt = 0;
	char[] data = new char[6];
	
	public synchronized void push(char ch)
	{
		while (cnt == data.length)
		{
			try
			{
				this.wait();	//wait��Object ���еķ���������Thread�еķ�����Thread��waitҲ�Ǽ̳���Object,      
							   //this.wait();�����õ�ǰ����wait�������õ�ǰ����this������߳�wait��ͬʱ�ͷŶ�this��������
							  //ע�⣺����ö���û�б������������wait�����ͻᱨ����ֻ����ͬ����������ͬ��������вſ��Ե���wait������notifyͬ��
			}
			catch (Exception e)
			{
			}
		}
		this.notify();  //���ע�͵��˱���䣬���ܻᵼ�������߳���������(��������̱߳���ִ�к����Ļ����������߳���Զ����wait������Զ��������)����Ϊ�����߳����������� ���������߳���˲�ͣ������Ʒ�ﵽ6����Ҳ���������������ʾ�Ŀ϶��ǡ����������ڹ���6���ַ�!��
						//this.notify();����һ����������wait  this�����һ���̣߳�����ж���߳�����wait this����ͨ���ǽ�������wait this������߳�,�������ǽ�����һ����������ϵͳ���������ƣ�����Ա�޷����� 		
						// nority �� notifyAll ����Object ���еķ���	
		
		
		data[cnt] = ch;
		cnt++;
		
		System.out.printf("������: %c\n", ch);
		System.out.printf("���������ڹ���%d���ַ�!\n\n", cnt);		
	}
	
	public synchronized char pop()
	{
		char ch;
		
		while (0 == cnt)
		{
			try
			{
				this.wait();
			}
			catch (Exception e)
			{
			}
		}
		this.notify();  //���ע�͵��˱���䣬���ܻᵼ�������߳���������(��������̱߳���ִ�к����Ļ����������߳���Զ����wait������Զ��������)����Ϊ�����߳����������������߳���˲�ͣȡ����Ʒ������������Ҳû�в�Ʒʱ�����߳�Ҳ���������������ʾ�Ŀ϶��ǡ����������ڹ���0���ַ�!��
		
		ch = data[cnt-1];
		--cnt;
		
		System.out.printf("ȡ��:  %c\n", ch);
		System.out.printf("���������ڹ���%d���ַ�!\n\n", cnt);
		
		return ch;
	}
}

class Producer implements Runnable
{
	SyncStack ss = null;
	
	public Producer(SyncStack ss)
	{
		this.ss = ss;
	}
	
	public void run()
	{
		char ch;
		
		//�ܹ�����20����Ʒ
		for (int i=0; i<20; ++i)
		{
			ch = (char)('a'+i);
			ss.push(ch);
//			try
//			{
//				Thread.sleep(500);
//			}
//			catch (Exception e)
//			{
//			}			
		}
	}
}

class Consumer implements Runnable
{
	SyncStack ss = null;
	
	public Consumer(SyncStack ss)
	{
		this.ss = ss;
	}
	
	//�ܹ�����20����Ʒ
	public void run()
	{
		for (int i=0; i<20; ++i)
		{
			ss.pop();
			try
			{
				Thread.sleep(500);
			}
			catch (Exception e)
			{
			}
		}
	}
}