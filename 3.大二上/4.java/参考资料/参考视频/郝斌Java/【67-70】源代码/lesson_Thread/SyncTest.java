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

class SyncStack{  //支持多线程同步操作的堆栈的实现
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
		System.out.println("生产: "+c);
		System.out.printf("容器里有%d个字母\n\n", index);
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
		System.out.println("取出："+data[index]);
		System.out.printf("容器里还有%d个字母!\n\n", index);
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
