class A
{
	int i;
	int j;
}

class TestMemo
{
	public static void main(String[] args)
	{
		A aa = new A(); // (A *)malloc(sizeof(A));
			// new A(); �ڶ��ж�̬����һ�����򣬱�������A����
			// aa������ڴ�����ջ�з����
			// �����ڴ�ĵ�ַ������aa
			// aaָ����е��ڴ棬aa�����˶��е��ڴ�
			// aa.i ����: aa�����ָ̬�������ָ��Ķ�̬�ڴ��е�A�����i�����Ա
			// aa.j ����: aa�����ָ̬�������ָ��Ķ�̬�ڴ��е�A�����j�����Ա
		aa.i = 10; 
		aa.j = 20;
		System.out.printf("%d, %d\n", aa.i, aa.j);
		
		
		//int i = 10;
	}
}