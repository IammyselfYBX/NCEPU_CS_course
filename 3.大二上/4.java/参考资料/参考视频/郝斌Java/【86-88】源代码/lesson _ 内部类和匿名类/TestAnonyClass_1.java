/*
	������ǽӿ���
	new A()
	{
		ʵ�ֽӿ��з����Ĵ���
	};
	���ܣ�����һ��ʵ����A�ӿڵ�������
*/

interface It
{
	void f();
	//void g();  //  ����������Ч�Ļ���21�е�27�еĴ����оͱ����ʵ��g����
}

public class TestAnonyClass_1
{
	public static void main(String[] args)
	{
		It it = new It()
			{  //21��
				public void f()
				{
					System.out.println("����");
				}
			};  //27��	
		
		//error	
//		It it = new It1()
//			(  //��{ ����(
//				public void f()
//				{
//					System.out.println("����");
//				}
//			);  // ��} ����)				
		
		//error
//		It it = new It()
//			(
//				{	
//					public void f()
//					{
//						System.out.println("����");
//					}
//				}
//			;
		
		it.f();		
	}
}