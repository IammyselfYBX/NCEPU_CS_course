/*
	2009��6��21��13:56:15
	�����̷߳����Ľ���
*/

class A extends Thread
{
	public void run()
	{
		//System.out.println("AAAA");
		System.out.printf("%s��ִ��!\n", Thread.currentThread().getName());
	}
}

public class TestThread_3
{
	public static void main(String[] args)
	{
		A aa1 = new A();
		aa1.setName("����");
		aa1.start();
		
		A aa2 = new A();
		aa2.start();
		
		A aa3 = new A();
		aa3.setName("����");
		aa3.start();
		
		//System.out.println("BBBB");
		System.out.printf("%s��ִ��!\n", Thread.currentThread().getName());
	}
}