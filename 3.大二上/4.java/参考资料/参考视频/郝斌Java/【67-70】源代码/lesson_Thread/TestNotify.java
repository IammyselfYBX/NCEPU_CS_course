/*
	2009年2月7日20:58:11
	this.notify();
	功能:
		不是叫醒正在执行this.notify();的当前线程
		而是叫醒一个现在正在wait  this对象的其他线程，如果有多个线程正在wait this对象，
		通常是叫醒最先wait this对象的线程,但具体是叫醒哪一个，
		这是由系统调度器控制，程序员无法控制 		
	
	但是要注意：
		假设现在有T1 T2 T3 T4 四个线程
		
		在T4线程中调用了
			aa.notify()
		即便此时T1 T2 T3 没有一个线程因为wait aa对象而陷入阻塞状态， 
		T4线程中执行aa.notify方法时也不会有任何错误
		本程序就证明了这一点	
	
*/

public class TestNotify
{
	public static void main(String[] args)
	{
		A aa = new A();
		Thread tt = new Thread(aa);
		tt.start();
		System.out.println("哈哈!");
	
	
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
	public synchronized void run()  //如果去掉了synchronized 则会报错，只有在同步代码块或同步方法中才可以使用notify方法
	{
		int cnt = 0;
		
		while (cnt < 20)
		{
			cnt++;
			System.out.println("AAAA" + cnt);
			try
			{
				this.notify(); //如果此时有很多线程因为 wait this对象而陷入阻塞状态，则叫醒其中的一个,至于具体是叫醒哪一个，则有系统调度器确定，程序员无法控制
						  //本程序证明了，即便此时没有任何线程因为  wait this对象而陷入阻塞状态，也可以调用notify方法	
			}
			catch (IllegalMonitorStateException e)
			{
				System.out.println("在非同步方法 非同不代码块中调用了notify方法");
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
					System.out.printf("%s线程在卖出第%d张票!\n", 
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