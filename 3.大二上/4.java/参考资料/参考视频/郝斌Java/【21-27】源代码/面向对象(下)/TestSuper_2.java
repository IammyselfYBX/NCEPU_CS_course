class A
{
	public int i;

	A(int i)
	{
		this.i = i;
	}
}

class B extends A
{
	public B()
	{
		super(2); //����������ע�͵� ��������Ϊ �������๹�캯���������дsuper(...);  ��Ĭ�ϵĻ����super();��
	}
}

class TestSuper_2
{
	public static void main(String[] args) 
	{
		A aa = new A(5);
		B bb = new B();

		System.out.println("Hello World!");
	}
}