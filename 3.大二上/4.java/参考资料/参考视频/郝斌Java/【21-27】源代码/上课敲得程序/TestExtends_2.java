class Human
{
	public String name = "张三";
	public int age = 22;	
}

class Student extends Human
{
	public double score = 66.6;
}

class Graduate extends Student
{
	public String daoshi = "小三";
}

public class TestExtends_2
{
	public static void main(String[] args)
	{
		Graduate gd = new Graduate();
		System.out.printf("%s %f\n", gd.name, gd.score);
	}
}

