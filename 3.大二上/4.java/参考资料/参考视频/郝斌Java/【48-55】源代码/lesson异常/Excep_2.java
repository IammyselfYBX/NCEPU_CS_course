/*
	Exception������һ��private��Message���ԣ�ͨ�����캯�� 
			public Exception(String message)
	������ɶԸ����Եĳ�ʼ��

*/

class E extends Exception
{
	public E()
	{
		super("����");  //��ʵ���ǵ��ø���Exception�Ĺ��캯���� public Exception(String message)
		//this.Message = "����";  //error
	}
}

class M
{
	public static void f() throws E  //Ҳ���Ը�Ϊ  throws Exception
	{
		throw new E();
	}
	
	public static void main(String[] args)
	{
		try
		{
			f();
		}
		catch (Exception e)
		{
			String strExcep = e.getMessage();
			System.out.println("strExcep = " + strExcep);
		}
		
		System.out.println("����������ֹ��!");
	}
}
/*
	��JDK 1.6�е����н���ǣ�
--------------------------------
strExcep = �������ھ�ֹ!
����������ֹ��!
--------------------------------
	�ܽ�:
		getMessage() ���ص����쳣�ľ�����Ϣ���Ǹ�String����
		public Exception(String message) ��message�ַ�������ʾ�쳣�ľ�����Ϣ

*/

