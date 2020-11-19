class A
{
	int i;
	
	public void show()
	{
		System.out.printf("show->   %d\n", i);//i是属性i，此时的i等价于this.i
	}

	public void f()
	{
		int i; //这里的i和属性i没有冲突	
		//System.out.printf("f->   %d\n", i);  //error 因为i是局部变量，JAva要求局部变量在使用之前必须得初始化
	}
	
	public void g(int i)  //i是形参i  形参i也是局部变量
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
