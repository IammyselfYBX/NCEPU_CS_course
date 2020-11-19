class Human
{
	//人笑
	public void laugh()
	{
		System.out.println("笑!");
	}
	
	//人哭
	public void cry()
	{
		System.out.println("哭!");
	}
}

class Student extends Human
{
	//做作业
	public void doHomework()
	{
		System.out.println("做作业!");
	}
}

public class TestExtends_2
{
	public static void main(String[] args)
	{
		Student s = new Student();
		s.laugh();
		s.cry();
		s.doHomework();
	}
}
/*
	在JDK 1.6中的运行结果是：
------------------
笑!
哭!
做作业!
------------------
*/
