/*
	执行完aa.start();后并不表示aa所对象的线程就一定会立即得到了执行，
	aa.start();执行完后只是表示t线程具有了可以立即被CPU执行的资格，
	但由于想抢占CPU执行的线程很多，CPU并不一定会立即去执行t所对应的线程
*/

public class TestThreadStart
{
	public static void main(String[] args)
	{
		A aa = new A();  
		aa.start();  //执行完本语句后并不表示说CPU一定会立即开启一个线程，转去执行１８到２４行的代码
		
		System.out.println("哈哈");
		for (int i=0; i<10; ++i)
		{
			System.out.println("111111");
		}
	}
}

class A  extends Thread  //创建一个继承Thread的类
{
	public void run()  //重写Thread中的run方法
	{
		for (int i=0; i<10; ++i)
		{
			System.out.println("222222");
		}
	}	
}
