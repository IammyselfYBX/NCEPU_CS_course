abstract class A
{
	abstract public void f();
}

class B extends A
{
	public void f()
	{
		System.out.printf("BBBB\n");		
	}
}

public class TestAbsPoly_1
{
	public static void main(String[] args)
	{
		//A aa = new A();  //error  18行
		
		B bb = new B();  //OK
		bb.f(); //OK
		
		A aa;  //23行   OK 可以定义一个抽象类的引用，但是不可以定义一个抽象类的对象，所以18行error， 本行OK
		aa = bb;
		aa.f();
	}
}

