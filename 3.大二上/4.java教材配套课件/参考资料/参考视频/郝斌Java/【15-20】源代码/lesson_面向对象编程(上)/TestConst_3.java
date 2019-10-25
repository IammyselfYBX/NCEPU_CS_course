/*
	2008年6月17日11:15:25
	一个类中的数据成员
		1、 如果在定义的时候不初始化，则它的值是系统自动分配好的默认值！ 如int型为零 boolean型是false
			如本程序的A类对象就是这样

		2、 如果在定义的同时赋初值， 则是可以的，也就是说该值是生效的.注意在C++中则不可以，在C++中一个类的数据成员不能在定义的同时初始化，它只能在构造函数中初始化
			如本程序的A类对象就是这样
			
		3、 如果在定义的同时赋初值，当然生效，但如果在构造函数中又改变了定义时赋的初值，
			则该数据成员最终的值就是构造函数中修改之后的那个值,因为：
				系统会先执行定义时赋的初值，然后再执行构造函数中赋的初值
			如本程序的B类对象就是这样
*/

class A
{
	int i;
	int j = 10;
	boolean flag;

	void show()
	{
		System.out.println("i = " + i);
		System.out.println("j = " + j);		
		System.out.println("flag = " + flag);
	}
}

class B
{
	int i;
	int j = 10;
	boolean flag;

	public B()
	{	
		System.out.println("以前的值是 " + i + "  " + j + " " + flag);

		i = 88;
		j = 88;
		flag = true;
	}

	void show()
	{
		System.out.println("i = " + i);
		System.out.println("j = " + j);		
		System.out.println("flag = " + flag);
	}
}

class TestConst_3
{
	public static void main(String[] args)
	{
		A aa1 = new A();
		aa1.show();

		B bb1 = new B();
		bb1.show();
	}
}
/*
	在j2sdk1.4.2_16中的运行结果是：
--------------
i = 0
j = 10
flag = false
以前的值是 0  10 false
i = 88
j = 88
flag = true
--------------
*/