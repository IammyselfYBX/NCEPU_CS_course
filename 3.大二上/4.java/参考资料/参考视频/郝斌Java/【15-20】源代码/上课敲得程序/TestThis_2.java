class A
{
	public int i = 99;
	
	public A(int i)
	{
		this.i = i; //this 代表当前时刻正在创建的对象
		System.out.printf("%d\n", i);
	}
	
	public void show()
	{
		System.out.printf("%d\n", this.i);  //this 代表正在调用show方法的对象
	}
}

public class TestThis_2
{
	public static void main(String[] args)
	{
		A aa = new A(2);
		aa.show();
		//System.out.printf("%d\n", aa.i);	
	}	
}
