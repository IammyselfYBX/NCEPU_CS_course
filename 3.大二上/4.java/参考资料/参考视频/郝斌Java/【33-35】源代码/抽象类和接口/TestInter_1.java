/*
	�ӿ��ж�������Ե�ֵ��ʵ�����в��ܱ�����
	�ӿڵ�������public static final ����
*/


//�ӿ����ǲ����Զ��幹�캯����
interface It
{
	int i = 10;  //���ܸ�Ϊ int i;
}

class A implements It
{
	public A(int j)
	{
		//this.i = j;  // �ӿ�It�е�����i ��public static final ���ͣ���������ʵ�����б��ı�
	}
}

class TestInter_1
{
	public static void main(String[] args)
	{
		A aa = new A(10);
		System.out.println("aa.i = " + aa.i);
		System.out.println("aa.i = " + A.i);
	}
}