/*
	2009年6月15日9:26:48
	测试String类的valueOf方法的用法
*/

public class TestString_2
{
	public static void main(String[] args) throws Exception
	{
		int i = 123;
		String str = "456";
		
		//str = i; //error
		//i = str; //error
		str = String.valueOf(i);
		System.out.printf("str = %s\n", str);
		
		i = Integer.parseInt(str);
		System.out.printf("i = %d\n", i);
	}
}