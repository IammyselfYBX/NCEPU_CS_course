/*
	ִ����aa.start();�󲢲���ʾaa��������߳̾�һ���������õ���ִ�У�
	aa.start();ִ�����ֻ�Ǳ�ʾt�߳̾����˿���������CPUִ�е��ʸ�
	����������ռCPUִ�е��̺߳ܶ࣬CPU����һ��������ȥִ��t����Ӧ���߳�
*/

public class TestThreadStart
{
	public static void main(String[] args)
	{
		A aa = new A();  
		aa.start();  //ִ���걾���󲢲���ʾ˵CPUһ������������һ���̣߳�תȥִ�У����������еĴ���
		
		System.out.println("����");
		for (int i=0; i<10; ++i)
		{
			System.out.println("111111");
		}
	}
}

class A  extends Thread  //����һ���̳�Thread����
{
	public void run()  //��дThread�е�run����
	{
		for (int i=0; i<10; ++i)
		{
			System.out.println("222222");
		}
	}	
}
