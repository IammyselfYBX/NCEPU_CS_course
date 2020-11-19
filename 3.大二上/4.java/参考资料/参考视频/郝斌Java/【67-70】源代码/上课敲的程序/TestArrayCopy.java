/*
	2008��6��17��17:24:14
	System.arraycpoy();���÷�
*/

class TestArrayCopy 
{
	public static void main(String[] args) 
	{
		int[] a = {1, 2, 3, 4, 5};
		int[] b = {-1,-2,-3,-4,-5};
		
		//-1 1 2 -4 -5
		System.arraycopy(a, 0, b, 1, 2); //��arraycopy ��Ҫд���� arrayCopy 

		System.out.println("a = ");
		for (int i=0; i<a.length; ++i)
		{
			System.out.println(a[i]);
		}

		
		System.out.println("b = ");
		for (int i=0; i<b.length; ++i)
		{
			System.out.println(b[i]);
		}

		System.out.println("Hello World!");
	}
}
/*
	��j2sdk1.4.2_16�е����н���ǣ�
--------------------
a =
1
2
3
4
5
b =
-1
1
2
-4
-5
Hello World!
--------------------
	public static void arraycopy(	Object arr1,
									int pos1,
									Object arr2,
									int pos2,
									int length
								)
	��arr1��ָ����������±��pos1��ʼ���ܹ�length��Ԫ�ظ��ǵ�arr2��ָ��������д�pos2��ʼ
	��length��Ԫ��
	
	ע�⣺	1��arr1��Դ����  arr2��Ŀ������!
			2��arraycopy	()	ȫ��Сд�������Ǵ�д!
*/
