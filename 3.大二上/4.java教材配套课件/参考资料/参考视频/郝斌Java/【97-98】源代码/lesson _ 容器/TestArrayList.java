/*
	2008年11月9日16:08:24
	本程序测试了: ArrayList类中的
		add()  
		size()  
			和
		System.out.println(Collection对象)的用法
*/

import java.util.*;

class Name
{
	private String firstName, lastName;

	public Name()
	{
	}

	public Name(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String toString()  //26行
	{
		return lastName + "  " + firstName;
	}   //29行
}

public class TestArrayList
{
	public static void main(String[] args)
	{
		Collection c = new ArrayList();
		
		//look  可以装入不同类型的对象, 这里装的都必须是对象，不可以是基本类型的数据，因为基本类型数据是存放在栈中的，一旦退出该基本类型数据的作用域，该基本类型数据所占的内存就消失了,话虽如此，不过这里仍然可以装入基本类型的数据，因为编译器会自动把基本类型数据转化成对象，如50行的代码
		c.add("hello"); //把"hello"这个字符串对象添加到c中，更准确的讲：把"hello"这个字符串对象的引用(引用即地址)添加到c对象中
		c.add("嘿嘿"); //同上
		c.add(new Name("bin", "hao"));
		c.add(new Integer(100));
		
		c.add(200); //c.add(200);等价于 c.add(Integer.valueOf(200)); 即编译器会自动把基本类型200转化为Integer对象200

		System.out.println(c.size()); //c.size() 返回c所装的对象的个数
		System.out.println(c); //本语句等价于System.out.println(c.toString()); 
			//c.toString(); 功能是这样的: 返回一个这样的String对象:  [调用第一个元素的toString方法, 调用第二个元素的toString方法, 调用第三个元素的toString方法。。。。。。。。]
			//如果把24行到27行注释掉了，则输出结果就会出现乱码，具体参见程序末尾处的输出结果

		System.out.println("同志们冲啊!");
	}
}
/*
	在JDK 1.6中的运行结果是：
-------------------------------
5
[hello, 嘿嘿, hao  bin, 100, 200]
同志们冲啊!
-------------------------------
	
	如果把24行到27行全部注释掉，则在JDK 1.6中的运行结果是：
-----------------------------
5
[hello, 嘿嘿, Name@de6ced, 100, 200]
同志们冲啊!
-----------------------------
	
*/