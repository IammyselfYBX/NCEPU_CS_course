/*
	2009��3��15��11:45:58
	Thread.setName(String name)
		���õ�ǰ�̵߳�����
	Thread.currentThread()
		���ص�ǰ�̵߳�����
	Thread.getName()
		���ص�ǰ�̵߳�����
*/

public class TestThreadAPI
{
	public static void main(String[] args)
	{
		T t = new T();
		t.setName("�±�");  //����д��setName("�±�");
		t.start();
		
		
		for (int i=0; i<30; ++i)
		{
			System.out.printf("�ٺ�\n");
			System.out.printf("%s�̱߳�������\n", Thread.currentThread().getName());
		}
	}
}

class T extends Thread
{
	@Override
	public void run()
	{
		//setName("�±�");
		for (int i=0; i<30; ++i)
		{
			System.out.printf("����\n");
			System.out.printf("%s�̱߳�������\n", Thread.currentThread().getName());
		}
	}
		
}