class A
{
}

interface It1
{
}

interface It2 {
}

//接口可以多重继承，即一个接口可以有多个父接口，但是一个类只能有一个父类，Java类不允许多继承，接口却允许多继承
interface It3  extends It1, It2
{
}

interface It4
{
	int i = 20;
}

//一个类可以在继承一个父类的同时实现一个或多个接口，但extends关键字必须的在implements 之前
class T  extends A implements It4,It3
{
}


class TestInter_2
{
	public static void main(String[] args)
	{
		System.out.println("嘿嘿!");
	}
}