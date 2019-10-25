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
				this.wait();	//wait是Object 类中的方法，不是Thread中的方法，Thread中wait也是继承自Object,      
							   //this.wait();不是让当前对象wait，而是让当前锁定this对象的线程wait，同时释放对this的锁定。
							  //注意：如果该对象没有被锁定，则调用wait方法就会报错！即只有在同步方法或者同步代码块中才可以调用wait方法，notify同理
			}
			catch (Exception e)
			{
			}
		}
		this.notify();  //如果注释掉了本语句，可能会导致消费线程陷入阻塞(如果消费线程本身执行很慢的话，则消费线程永远不会wait，即永远不会阻塞)，因为消费线程陷入阻塞， 所以生产线程因此不停生产产品达到6个后也陷入阻塞，最后显示的肯定是“容器中现在共有6个字符!”
						//this.notify();叫醒一个现在正在wait  this对象的一个线程，如果有多个线程正在wait this对象，通常是叫醒最先wait this对象的线程,但具体是叫醒哪一个，这是由系统调度器控制，程序员无法控制 		
						// nority 和 notifyAll 都是Object 类中的方法	
		
		
		data[cnt] = ch;
		cnt++;
		
		System.out.printf("生产了: %c\n", ch);
		System.out.printf("容器中现在共有%d个字符!\n\n", cnt);		
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
		this.notify();  //如果注释掉了本语句，可能会导致生产线程陷入阻塞(如果生产线程本身执行很慢的话，则生产线程永远不会wait，即永远不会阻塞)，因为生产线程陷入阻塞，消费线程因此不停取出产品，当容器中再也没有产品时消费线程也陷入阻塞，最后显示的肯定是“容器中现在共有0个字符!”
		
		ch = data[cnt-1];
		--cnt;
		
		System.out.printf("取出:  %c\n", ch);
		System.out.printf("容器中现在共有%d个字符!\n\n", cnt);
		
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
		
		//总共生产20个产品
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
	
	//总共消费20个产品
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