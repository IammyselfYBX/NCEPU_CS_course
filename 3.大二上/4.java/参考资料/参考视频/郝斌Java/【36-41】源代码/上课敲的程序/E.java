class A
{
	int i;
	
	public void show()
	{
		System.out.printf("show->   %d\n", i);//i������i����ʱ��i�ȼ���this.i
	}

	public void f()
	{
		int i; //�����i������iû�г�ͻ	
		//System.out.printf("f->   %d\n", i);  //error ��Ϊi�Ǿֲ�������JAvaҪ��ֲ�������ʹ��֮ǰ����ó�ʼ��
	}
	
	public void g(int i)  //i���β�i  �β�iҲ�Ǿֲ�����
	{
		this.i = i;	//
		System.out.printf("f->   %d\n", i);
	}
}

public class E
{
	public static void main(String[] args)
	{
		A aa = new A();
		//aa.g(99);
		aa.show();
	}
}
