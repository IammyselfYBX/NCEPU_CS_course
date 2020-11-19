/*
	接口中定义的属性的值在实现类中不能被更改
	接口的属性是public static final 类型
*/


//接口中是不可以定义构造函数的
interface It
{
	int i = 10;  //不能改为 int i;
}

class A implements It
{
	public A(int j)
	{
		//this.i = j;  // 接口It中的属性i 是public static final 类型，不可以在实现类中被改变
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