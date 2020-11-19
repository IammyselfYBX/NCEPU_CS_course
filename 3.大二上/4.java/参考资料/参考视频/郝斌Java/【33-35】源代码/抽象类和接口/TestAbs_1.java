abstract class A
{
	public abstract void f();
}

class B extends A
{
	public void f()
	{
		System.out.println("哈哈");
	}
}

public class TestAbs_1
{
	public static void main(String[] args)
	{
		//A aa1 = new A();  //error
		A aa2 = null;  //可以定义一个抽象类的引用
		aa2 = new B(); //将子类对象的地址赋给抽象类的引用
		aa2.f(); //用抽象类的引用访问子类的方法  这就是多态
	}
}