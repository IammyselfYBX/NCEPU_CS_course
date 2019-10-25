class A
{
	public void f()  //如果在public前面加final，则编译时就会报错
	{
		System.out.println("AAAA");
	}
}

class B extends A
{
	public void f()
	{
		System.out.println("BBBB");
	}	
}

public class TestFinal_2
{
	public static void main(String[] args)
	{
	}
}