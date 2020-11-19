abstract class  A  //如果f方法没有方法体，则必须的在class前加 abstract  如果f方法含有方法体，则class前面可加也可不加abstract ，因为“一个抽象类中是可以不包含任何抽象方法，尽管比较少见”
{
	private int i;
	public abstract void f();  //如果f方法没有方法体，则f方法必须的声明为抽象方法，即必须的在前面加abstract
}

class TestAbsClass_1
{
	public static void main(String[] args)
	{
		System.out.println("今天我很高兴!");
	}
}