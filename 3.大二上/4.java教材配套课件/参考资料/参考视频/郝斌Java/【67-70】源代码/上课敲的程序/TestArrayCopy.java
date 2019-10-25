/*
	2008年6月17日17:24:14
	System.arraycpoy();的用法
*/

class TestArrayCopy 
{
	public static void main(String[] args) 
	{
		int[] a = {1, 2, 3, 4, 5};
		int[] b = {-1,-2,-3,-4,-5};
		
		//-1 1 2 -4 -5
		System.arraycopy(a, 0, b, 1, 2); //是arraycopy 不要写成了 arrayCopy 

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
	在j2sdk1.4.2_16中的运行结果是：
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
	将arr1所指向的数组中下标从pos1开始的总共length个元素覆盖掉arr2所指向的数组中从pos2开始
	的length个元素
	
	注意：	1、arr1是源数组  arr2是目的数组!
			2、arraycopy	()	全是小写，不能是大写!
*/
