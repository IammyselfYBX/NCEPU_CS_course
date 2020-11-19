public class SyncTest
{
    public static void main(String args[]) throws Exception
    {
		SyncStack stack = new SyncStack();
		Runnable p=new Producer(stack);
		Runnable c = new Consumer(stack);
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);
		t1.start();
		
		Thread.sleep(1000);
		
		t2.start();
		
//		Thread t3 = new Thread(p);
//		t3.start();
//		Thread t4 = new Thread(c);
//		t4.start();
    }
}

class SyncStack{  //֧�ֶ��߳�ͬ�������Ķ�ջ��ʵ��
	private int index = 0;
	private char []data = new char[6];	
	
	public synchronized void push(char c)
	{
		while(index == data.length)
		{
			try
			{
				this.wait();
			}catch(InterruptedException e)
			{
				e.printStackTrace();
				System.exit(-1);
			}
		}
		this.notify();
		data[index] = c;
		index++;
		System.out.println("����: "+c);
		System.out.printf("��������%d����ĸ\n\n", index);
	}
	
	public synchronized char pop()
	{
		while(index == 0)
		{
			try
			{
				this.wait();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
				System.exit(-1);
			}
		}
		this.notify();
		index--;
		System.out.println("ȡ����"+data[index]);
		System.out.printf("�����ﻹ��%d����ĸ!\n\n", index);
		return data[index];
	}
}




class  Producer implements Runnable
{
	SyncStack stack;	
	public Producer(SyncStack s)
	{
		stack = s;
	}
	
	public void run()
	{
		for(int i=0; i<20; i++)
		{
			char c =(char)('a'+i);
			stack.push(c);
			try
			{							        
				Thread.sleep((int)(Math.random()*20));
			}catch(InterruptedException e)
			{
			}
		}
	}
}

class Consumer implements Runnable
{
	SyncStack stack;	
	public Consumer(SyncStack s)
	{
		stack = s;
	}
	
	public void run()
	{
		for(int i=0;i<20;i++)
		{
			char c = stack.pop();
			try
			{							           
				Thread.sleep((int)(Math.random()*1000));
			}
			catch(InterruptedException e)
			{
			}
		}
	}
}
