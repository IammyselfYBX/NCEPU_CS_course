/*
	2009��6��21��13:41:39
	�����̵߳ĵڶ��ַ�ʽ
*/

class A implements Runnable
{
	public void run()
	{
		while (true)
		{
			System.out.println("AAAA\n");
		}
	}
}

class B
{
}

public class TestThread_2
{
	public static void main(String[] args)
	{
		A aa = new A();
		//aa.start();  //error
		Thread t = new Thread(aa);  //public Thread(Runnbale r)
		//B bb = new B();
		//Thread t2 = new Thread(bb); //error

		t.start();
		
		while (true)
		{
			System.out.println("BBBB\n");
		}
	}
}