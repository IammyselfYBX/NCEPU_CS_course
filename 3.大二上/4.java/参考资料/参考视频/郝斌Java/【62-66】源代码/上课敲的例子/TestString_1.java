/*
	2009年6月15日8:55:11
	测试String类的
		equals方法的使用
		==的用法
		常量字符串的用法
*/

public class TestString_1
{
	public static void main(String[] args)
	{
		String str1 = new String("china");
		String str2 = new String("china");
		System.out.println(str1.equals(str2)); //true   str1.equals(str2) 用来判断str1指向的对象的内容和str2指向的对象的内容是否相等
		
		if (str1 == str2) //是判断str1和str2自身的内容是否相等？  还是用来判断str1指向的对象的内容和str2指向的对象的内容是否相等？ 答案： 代表前者
			System.out.println("str1 == str2");  
		else
			System.out.println("str1 != str2");	
			
		String str3 = "china";
		String str4 = "china";
		if (str3 == str4)
			System.out.println("str3 == str4");
		else
			System.out.println("str3 != str4");		
			
	}
}