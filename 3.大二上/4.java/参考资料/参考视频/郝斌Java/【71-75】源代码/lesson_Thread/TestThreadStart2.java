/*
	һ��Thread����ֻ�ܴ���һ���̲߳���ֻ�ܴ���һ���̣߳�
	һ��Thread�����ܵ�������start()f������
	������׳�java.lang.IllegalThreadStateException�쳣
*/

public class TestThreadStart2
{
	public static void main(String[] args)
	{
		A aa = new A();  
		aa.start(); 
			
		try
		{
			aa.start();  //һ��Ҫ�����������߳��е���䣬�������߳��п��ܻ��׳����쳣����ʱ�ܿ���aa����Ӧ���߳��Ѿ���ִ�С�������������
		}
		catch (java.lang.IllegalThreadStateException e)
		{
			System.out.println("һ���̲߳����������");
			System.out.println("һ���̲߳����������");
			System.out.println("һ���̲߳����������");
			System.exit(-1);
		}
		
		while (true)
		{
			System.out.println("BBBBBBBB");
		}
	}
}

class A  extends Thread  //����һ���̳�Thread����
{
	public void run()  //��дThread�е�run����
	{
		while (true)
		{
			System.out.println("AAAAAA");
		}
	}	
}
/*
	��JDK 1.6�е�ĳһ�����еľ������ǣ�
----------------------------------
һ���̲߳����������
һ���̲߳����������
AAAAAA
AAAAAA
AAAAAA
AAAAAA
AAAAAA
AAAAAA
AAAAAA
AAAAAA
һ���̲߳����������
AAAAAA
AAAAAA
AAAAAA
AAAAAA
AAAAAA
----------------------------------
*/
