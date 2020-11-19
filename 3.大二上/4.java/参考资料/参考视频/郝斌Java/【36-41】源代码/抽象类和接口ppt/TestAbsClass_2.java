/*
	不能new 出抽象类对象，但可以用抽象类的引用指向抽象类的子类对象，即抽象类也可以实现多态
*/

abstract class A
{
	abstract public void f();
}

class B extends A
{
	public void f()
	{
		System.out.println("BBB");
	}
}

public class TestAbsClass_2
{
	public static void main(String[] args)
	{
		//A aa = new A();  //error   不能new 出抽象类对象 
		A aa = new B();  //OK
		aa.f();  //多态
	}
}