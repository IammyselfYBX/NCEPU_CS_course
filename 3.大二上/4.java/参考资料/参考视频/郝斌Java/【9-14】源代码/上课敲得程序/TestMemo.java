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
			// new A(); 在堆中动态分配一块区域，被当做了A对象
			// aa本身的内存是在栈中分配的
			// 堆中内存的地址付给了aa
			// aa指向堆中的内存，aa代表了堆中的内存
			// aa.i 代表: aa这个静态指针变量所指向的动态内存中的A对象的i这个成员
			// aa.j 代表: aa这个静态指针变量所指向的动态内存中的A对象的j这个成员
		aa.i = 10; 
		aa.j = 20;
		System.out.printf("%d, %d\n", aa.i, aa.j);
		
		
		//int i = 10;
	}
}