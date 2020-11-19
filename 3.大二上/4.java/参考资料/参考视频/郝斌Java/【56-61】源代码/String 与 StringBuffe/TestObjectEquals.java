class A
{
	public int i = 10;
}

public class TestObjectEquals
{
	public static void main(String[] args)
	{
		A aa1 = new A();
		A aa2 = new A();

		if (aa1.equals(aa2))
		{
			System.out.println("aa1 == aa2");
		}
		else
		{
			System.out.println("aa1 != aa2");  //aa1��aa2����������鲻ͬ���ڴ棬���������ڴ��ֵ����һ���ģ�������ˣ����Ƿ���false����ӱ�����������ȿ����жϳ�
		}
 	
		aa1 = aa2;
		if (aa1.equals(aa2))
		{
			System.out.println("aa1 == aa2");
		}
		else
		{
			System.out.println("aa1 != aa2");
		}
	}
}
/*
	��JDK 1.6�е����н���ǣ�
------------------------------
aa1 != aa2
aa1 == aa2
------------------------------
	�ܽ�:
	Object�е�public boolean equals(Object obj);
	��Object�е�equals������ֱ���ж�this��obj�����ֵ�Ƿ���ȣ��������жϵ���
equals�Ķ�����β�obj�����õĶ����Ƿ���ͬһ������νͬһ�������ָ���ڴ���ͬ
һ��洢��Ԫ
	Object�е�equals�������ܣ����this��objָ�����ͬһ���ڴ�����򷵻�true��
���this��objָ��Ĳ���ͬһ���ڴ棬�򷵻�false,ע�⣺������������ȫ��ȵ�����
��ͬ���ڴ����Ҳ�᷵��false��������������������ӣ�aa1��aa2ռ�ò�ͬ���ڴ棬
����aa1��aa2��ռ��ͬ�ڴ�����ݶ���һ���ģ���������false

	�����ԣ���������ǲ�̫����ģ���������������A�����aa1  ��  aa2�����Ƿֱ�
ռ�ò�ͬ���ڴ棬�������ǵ����ݶ���һ���ģ� �ܶ�����£�����ҲӦ����Ϊaa1��aa2
����ȵģ� ������ͬһ���๹�������ռ�ò�ͬ�ڴ�Ķ������������������Ȼռ��
��ͬ���ڴ浫���ڴ��е���ֵ��һ���ģ�������ҲӦ����Ϊ��������������ȵģ�
	��ͬ���Ͳ�ͬ�ڴ��������������ڴ��е�ֵ��ȣ�����һ��Ӧ��Ҳ��Ϊ����������
��ȣ�������Object�е�equals()�޷�������������Σ�Object�е�equals()����ֻ��
������������ͬһ���ڴ�ʱ���ŷ���true��
	���������Լ��������ʱ�����Ҫʹ��equals��������ͨ������Ҫ��д�������
Object�е�equals������
	
	public boolean equals(Object obj)
	{
		return this == obj;
	}

*/