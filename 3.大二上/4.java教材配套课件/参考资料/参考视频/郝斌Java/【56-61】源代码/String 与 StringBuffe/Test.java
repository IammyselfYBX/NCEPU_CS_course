/*
	2008年11月3日17:04:42
	本程序说明了:  StringBuffer 类的重要性

	String s1 = "zhangsan";
	只使用String类来删除s1对象中的第一个n这个字母的方法
*/

public class Test
{
	public static void main(String[] args)
	{
		String s1 = "zhangsan";
		String s2 = s1.substring(0, 3);
		String s3 = s1.substring(4, s1.length());
		s1 = s2 + s3;

		System.out.println("s1 = " + s1);
	}
}
/*
	在JDK 1.6中的运行结果是：
------------------------------
s1 = zhagsan
------------------------------
*/