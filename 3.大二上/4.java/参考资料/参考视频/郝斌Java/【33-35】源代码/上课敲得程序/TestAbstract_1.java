//有抽象方法的类一定是抽象类
abstract class A
{
	abstract public void f();  //没有方法体的方法叫做抽象方法，  抽象方法要求末尾必须得加分号，前面必须得加abstract
}


//抽象类不一定有抽象方法
abstract class B
{
	public void g()
	{
	}
}

public class TestAbstract_1
{
	public static void main(String[] args)
	{
	}
}
