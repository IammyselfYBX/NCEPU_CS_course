public class ThreadDef1
{
	public static void main(String[] args)
	{
		A aa = new A();
		aa.run();
		
		while (true)
		{
			System.out.println("BBBBBBBB");
		}
	}
}

class A  extends Thread
{
	public void run()
	{
		while (true)
		{
			System.out.println("AAAAAA");
		}
	}
	
}