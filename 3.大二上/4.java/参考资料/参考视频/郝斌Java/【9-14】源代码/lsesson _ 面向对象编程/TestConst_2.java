/*
	讲解过程如下：
		第一步 不给i 和 flag赋值
		第二步： 给i和 flag 赋值
		第三步：添加构造函数
*/

class A
{
	private int i = 5;  
	boolean flag = true;
	
	public A(int j, boolean f)
	{
		i = j;
		flag = f;
	}
	
	public void show()
	{	
		System.out.println(i + ",  " + flag);
	}
}

public class TestConst_2
{
	public static void main(String[] args)
	{
		new A(8, false).show();
	}
}
/*
	在JDK 1.6中的运行结果是：
-----------------
8,  false
-----------------
*/