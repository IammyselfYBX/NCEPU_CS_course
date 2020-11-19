class A
{
	public int i = 20;
	private static A aa = new A(); //aa�Ƿ���A���������
	
	private A()
	{
	}
	
	public static A getA()  //static һ���ǲ���ʡ�Ե�
	{
		return aa;
	}
}

public class TestStatic_2
{
	public static void main(String[] args)
	{
		A aa1 = A.getA();
		A aa2 = A.getA();
		
		aa1.i = 99;
		System.out.printf("%d\n", aa2.i);
		
		if (aa1 == aa2)
			System.out.printf("aa1 �� aa2���\n");
		else
			System.out.printf("aa1 �� aa2�����\n");
		
		
//		A aa1 = new A();  // error ���A��Ĺ��췽����private�ģ���new A()�ͻᱨ��!
//		A aa2 = new A();  //ͬ��
		
	}
}