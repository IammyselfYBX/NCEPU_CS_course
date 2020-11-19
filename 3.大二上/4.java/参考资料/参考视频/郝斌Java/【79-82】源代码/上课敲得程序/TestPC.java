/*
	2009��6��24��15:24:35
	����������
*/

class SynStack 
{
	private char[] data = new char[6];
	private int cnt = 0; //��ʾ������ЧԪ�صĸ���
	
	public synchronized void push(char ch)
	{
		while (cnt == data.length)
		{
			try
			{
				this.wait();
			}
			catch (Exception e)
			{
			}
		}
		this.notify(); 
		
		data[cnt] = ch;
		++cnt;
		System.out.printf("�����߳�����������%d����Ʒ���ò�Ʒ��: %c\n", cnt, ch);
	}
	
	public synchronized char pop()
	{
		char ch;
		
		while (cnt == 0)
		{
			try
			{
				this.wait();
			}
			catch (Exception e)
			{
			}
		}
		this.notify();
		ch = data[cnt-1];
		
		System.out.printf("�����߳��������ѵ�%d����Ʒ���ò�Ʒ��: %c\n", cnt, ch);
		
		--cnt;
		return ch;		
	}	
}

class Producer implements Runnable
{
	private SynStack ss = null;
	
	public Producer(SynStack ss)
	{
		this.ss = ss;
	}
	
	public void run() // throws Exception
	{
		//push('a');  //error
		char ch;
		
		for (int i=0; i<20; ++i)
		{
//			try{
//			Thread.sleep(100);
//			}
//			catch (Exception e){			
//			}
				
			ch = (char)('a'+i);
			ss.push(ch);
		}
	}
}

class Consumer implements Runnable
{
	private SynStack ss = null;
	
	public Consumer(SynStack ss)
	{
		this.ss = ss;
	}
	
	public void run()
	{
		for (int i=0; i<20; ++i)
		{
			try{
			Thread.sleep(100);
			}
			catch (Exception e){			
			}
			
			//System.out.printf("%c\n", ss.pop());
			ss.pop();
		}
	}
}


public class TestPC
{
	public static void main(String[] args)
	{
		SynStack ss = new SynStack();
		Producer p = new Producer(ss);
		Consumer c = new Consumer(ss);
		Thread t1 = new Thread(p);
		t1.start();
				
		Thread t2 = new Thread(c);
		t2.start();
	}
}


