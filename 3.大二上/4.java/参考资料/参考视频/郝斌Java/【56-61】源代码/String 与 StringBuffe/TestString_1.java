/*
	== 与 equals()区别
*/

class TestString_1 
{
	public static void main(String[] args) 
	{
		String str1 = "hello";
		String str2 = "hello";  //str1 和 str2 都指向了匿名对象"hello"

		if (str1 == str2) //判断str1 和 str2本身的内容是否相等
		{
			System.out.println("str1 == str2");
		}
		else
		{
			System.out.println("str1 != str2");
		}

		String str3 = new String("hello");  //str3 和 str4 很明显指向的是不同的对象
		String str4 = new String("hello");
		if (str3 == str4)
		{
			System.out.println("str3 == str4");
		}
		else
		{
			System.out.println("str3 != str4");
		}

		if (str3.equals(str4)) //判断str3 与 str4所引用的对象是否相等  很明显是true
		{
			System.out.println("str3.equals(str4) == true");
		}
		
		System.out.println("Hello World!");
	}
}
/*
	在JDK 1.6中的运行结果是： 
-------------------------------
str1 == str2
str3 != str4
str3.equals(str4) == true
Hello World!
-------------------------------
	总结：
	str1 ==  str2 
		是用来比较str1变量本身所占内存的值和str2变量本身所占内存的值
	是否相等
	

	str1.equals(str2)
		是用来比较str1变量本身所占内存的值所指向的对象和str2变量本身
	所占内存	的值所指向的对象的内容是否相等
	也就是说如果str1和str2占用不同的内存，但是这两个不同内存的值是一样的，
	Stirng.equals()方法也会返回true.但是Object中的equals()方法却是返回
	false,具体可参见“【测试Object类中的Equals方法】TestObjectEquals.java”


	Object中就含有equals()方法，不过String类重写了Object中的equals()方法
	API：
------------------------------------------------------
equals
public boolean equals(Object anObject)将此字符串与指定的对象比较。当且仅当该参数不为 null，并且是与此对象表示相同字符序列的 String 对象时，结果才为 true。 

覆盖：
类 Object 中的 equals
参数：
anObject - 与此 String 进行比较的对象。 
返回：
如果给定对象表示的 String 与此 String 相等，则返回 true；否则返回 false。
另请参见：
compareTo(String), equalsIgnoreCase(String)
------------------------------------------------------

*/
