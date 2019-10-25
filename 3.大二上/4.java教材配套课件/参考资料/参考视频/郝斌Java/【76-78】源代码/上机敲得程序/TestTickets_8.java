/*
	2009年6月22日9:28:08
	错误的程序:
		锁定的不是同一个str对象
		与TestTickets_7.java 运行结果是一样的
	
*/

class A implements Runnable
{
	public int tickets = 100;
	String str = new String("哈哈");
		
	public void run()  
	{
		String str = new String("哈哈");  //16行  可以定义一个局部变量，该局部变量的名字和属性名相同
		
		while (true)
		{
			synchronized (str)  //锁定的不是同一个str对象  此时的str是局部变量str，即是16行定义的str
			{
				if (tickets > 0)
				{
					System.out.printf("%s线程正在卖出第%d张票\n",
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

public class TestTickets_8
{
	public static void main(String[] args)
	{
		A aa = new A();
		Thread t1 = new Thread(aa);
		t1.start();	
		
		Thread t2 = new Thread(aa);
		t2.start();	
			
	}
}