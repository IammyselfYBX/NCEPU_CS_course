class A
{
	public int i = 2;
	public boolean flag = true;
	
	public A(int j, boolean f)
	{
		i = j;
		flag = f;		
	}
	
	public void show()
	{
		System.out.printf("%d\n", i);
		System.out.printf("%b\n", flag); //boolean��%b��%B�����
	}
	
}

class TestConst_2
{
	public static void main(String[] args)
	{
		A aa = new A(88, false);
		aa.show();
		
//		int k;  //�ֲ������������ǲ����Զ����г�ʼ���ģ�javaҪ�����еľֲ�������ʹ��֮ǰ������ĳ�ʼ��
//		System.out.printf("%d\n", k);
	}
}