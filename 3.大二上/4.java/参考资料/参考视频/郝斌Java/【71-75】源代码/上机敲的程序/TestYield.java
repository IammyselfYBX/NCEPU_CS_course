public class TestYield 
{
	public static void main(String[] args) 
	{
	   MyThread mt = new MyThread();
	   Thread t1 = new Thread(mt);
	   Thread t2 = new Thread(mt);
	   
	   t1.setName("线程A");
	   t2.setName("线程B");
	   
	   t1.start();
	   t2.start();
	}
}
class MyThread implements Runnable 
{
	public void run()
	{
	    for(int i=1;i<=100;i++)
	    {
			System.out.println(Thread.currentThread().getName()+": "+i);
	      	if(0 == i%10)
	      	{
	        	Thread.yield();
	      	}
	    }
  	}
}
