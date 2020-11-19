/*
	一个Thread对象只能代表一个线程并且只能代表一个线程，
	一个Thread对象不能调用两次start()f方法，
	否则会抛出java.lang.IllegalThreadStateException异常
*/

public class TestThreadStart2
{
	public static void main(String[] args)
	{
		A aa = new A();  
		aa.start(); 
			
		try
		{
			aa.start();  //一定要明白这是主线程中的语句，这是主线程中可能会抛出的异常，此时很可能aa所对应的线程已经在执行。。。。。。。
		}
		catch (java.lang.IllegalThreadStateException e)
		{
			System.out.println("一个线程不能启动多次");
			System.out.println("一个线程不能启动多次");
			System.out.println("一个线程不能启动多次");
			System.exit(-1);
		}
		
		while (true)
		{
			System.out.println("BBBBBBBB");
		}
	}
}

class A  extends Thread  //创建一个继承Thread的类
{
	public void run()  //重写Thread中的run方法
	{
		while (true)
		{
			System.out.println("AAAAAA");
		}
	}	
}
/*
	在JDK 1.6中的某一次运行的具体结果是：
----------------------------------
一个线程不能启动多次
一个线程不能启动多次
AAAAAA
AAAAAA
AAAAAA
AAAAAA
AAAAAA
AAAAAA
AAAAAA
AAAAAA
一个线程不能启动多次
AAAAAA
AAAAAA
AAAAAA
AAAAAA
AAAAAA
----------------------------------
*/
