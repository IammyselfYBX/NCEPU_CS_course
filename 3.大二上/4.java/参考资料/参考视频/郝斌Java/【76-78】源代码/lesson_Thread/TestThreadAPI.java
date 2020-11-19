/*
	2009年3月15日11:45:58
	Thread.setName(String name)
		设置当前线程的名字
	Thread.currentThread()
		返回当前线程的引用
	Thread.getName()
		返回当前线程的名字
*/

public class TestThreadAPI
{
	public static void main(String[] args)
	{
		T t = new T();
		t.setName("郝斌");  //不能写成setName("郝斌");
		t.start();
		
		
		for (int i=0; i<30; ++i)
		{
			System.out.printf("嘿嘿\n");
			System.out.printf("%s线程被调用了\n", Thread.currentThread().getName());
		}
	}
}

class T extends Thread
{
	@Override
	public void run()
	{
		//setName("郝斌");
		for (int i=0; i<30; ++i)
		{
			System.out.printf("哈哈\n");
			System.out.printf("%s线程被调用了\n", Thread.currentThread().getName());
		}
	}
		
}