/*
	2009��1��21��21:55:05
	���า���˻��෽��ʱ��
	���෽���׳��쳣�ķ�Χ���ܴ��ڻ��෽���׳����쳣��Χ
	���෽�����Բ��׳��쳣��Ҳ����ֻ�׳����෽���Ĳ����쳣
	���������׳����෽��������쳣
*/


//�Զ����쳣A
class A extends Exception
{
}

//�Զ����쳣B
class B extends Exception
{
}

//�Զ����쳣C
class C extends Exception
{
}

class M
{
	void f() throws A, B
	{
	}
}

class N extends M
{
	void f() throws A,B //����throws A��B,Ҳ����throws A,B  Ҳ���Բ�throws����������throws C  ��"���า���˻��෽��ʱ�����෽���׳��쳣�ķ�Χ���ܴ��ڻ��෽���׳����쳣��Χ"
	{
	}
}

class Test
{
	public void k(M mm)
	{
		try
		{
			mm.f();
		}
		catch (A aa)
		{
		}
		catch (B bb)
		{
		}		
	}
}

class TestExtendExce
{
	public static void main(String[] args)
	{
		M m = new M();
		N n = new N();
		
		//System.out.println("1111");
	}
}
/*
	��JDK 1.6�е����н���ǣ�
--------------------------
1111
--------------------------
*/