/*
	2009��1��21��17:09:38
	�Զ����쳣
*/

class DivisorIsMinusException extends Exception
{
	public DivisorIsMinusException(String message)
	{
		super(message); //ʵ���ǵ���Exception �Ĺ��캯�� public Exception(String message)
	}	
}

class HH
{
	public void f(int a, int b) throws DivisorIsMinusException
	{
		if (b < 0)
			throw new DivisorIsMinusException("��������Ϊ����!");
	}
}

class Excep_3
{
	public static void main(String[] args)
	{
		HH h = new HH();
		try
		{
			h.f(3, -2);
		}
		catch (DivisorIsMinusException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("����������ֹ��!");
	}
}
/*
	��JDK 1.6�е����н���ǣ�
--------------------------
��������Ϊ����!
����������ֹ��!
--------------------------
*/