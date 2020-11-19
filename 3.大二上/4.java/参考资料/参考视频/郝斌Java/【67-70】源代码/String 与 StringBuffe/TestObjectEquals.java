class A
{
	public int i = 10;
}

public class TestObjectEquals
{
	public static void main(String[] args)
	{
		A aa1 = new A();
		A aa2 = new A();

		if (aa1.equals(aa2))
		{
			System.out.println("aa1 == aa2");
		}
		else
		{
			System.out.println("aa1 != aa2");  //aa1和aa2分配的是两块不同的内存，但这两块内存的值都是一样的，尽管如此，还是返回false，这从本语句会输出，既可以判断出
		}
 	
		aa1 = aa2;
		if (aa1.equals(aa2))
		{
			System.out.println("aa1 == aa2");
		}
		else
		{
			System.out.println("aa1 != aa2");
		}
	}
}
/*
	在JDK 1.6中的运行结果是：
------------------------------
aa1 != aa2
aa1 == aa2
------------------------------
	总结:
	Object中的public boolean equals(Object obj);
	即Object中的equals方法是直接判断this和obj本身的值是否相等，即用来判断调用
equals的对象和形参obj所引用的对象是否是同一对象，所谓同一对象就是指是内存中同
一块存储单元
	Object中的equals方法功能：如果this和obj指向的是同一块内存对象，则返回true，
如果this和obj指向的不是同一块内存，则返回false,注意：即便是内容完全相等的两块
不同的内存对象，也会返回false，本程序就是这样的例子，aa1和aa2占用不同的内存，
尽管aa1和aa2所占不同内存的内容都是一样的，照样返回false

	很明显，这样设计是不太合理的，假设现在有两个A类对象aa1  和  aa2，它们分别
占用不同的内存，但是它们的内容都是一样的， 很多情况下，我们也应该认为aa1和aa2
是相等的， 即：用同一个类构造的两个占用不同内存的对象，如果这两个对象虽然占用
不同的内存但是内存中的内值是一样的，则我们也应该认为这两个对象是相等的：
	即同类型不同内存的两个对象，如果内存中的值相等，我们一般应该也认为这两个对象
相等，很明显Object中的equals()无法完成这样的重任，Object中的equals()方法只有
在两个对象是同一块内存时，才返回true。
	所以我们自己定义对象时，如果要使用equals方法，则通常都需要重写超父类的
Object中的equals方法，
	
	public boolean equals(Object obj)
	{
		return this == obj;
	}

*/