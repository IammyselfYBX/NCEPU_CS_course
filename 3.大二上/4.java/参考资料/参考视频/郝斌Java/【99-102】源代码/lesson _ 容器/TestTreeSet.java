/*
	2009年2月21日22:10:30
	总结:
	向TreeSet容器中添加的对象必须得是实现Comparable接口的类对象 ，否则运行程序会报错
	向TreeSet容器中添加的对象可以不重写hashCode方法和equasl方法.
*/

import java.util.*;

public class TestTreeSet
{
	public static void main(String[] args)
	{
		Collection c = new TreeSet();
		
		c.add(new Student(1006, "张三"));
		c.add(new Student(1003, "小娟")); //16行
		c.add(new Student(1002, "李四"));
		c.add(new Student(1008, "王刚")); //16行
		c.add(new Student(1001, "王五")); //16行
		
		Iterator i = c.iterator();
		while (i.hasNext())
		{
			System.out.println(i.next());
		}
		System.out.println("哈哈嘿嘿!");
		
		
	}
}

class Student implements java.lang.Comparable
{
	private final int num;
	private String name;

	public Student(int num, String name)
	{
		this.num = num;
		this.name = name;
	}

	public String toString()
	{
		return "学号: " + this.num + ",  姓名: " + name;
	}
	
	@Override
	public boolean equals(Object o)
	{
		boolean flag = false;
		if (o instanceof Student)
		{
			if (this.num == ((Student)o).num)
				flag = true;
		}
		
		return flag;
	}
	
	@Override
	public int compareTo(Object o)
	{
		//Student s = (Student)o;
		return this.num - ((Student)o).num;
	}
}


/*
	在JDK 1.6中的运行结果是：
-----------------------------
学号: 1001,  姓名: 王五
学号: 1002,  姓名: 李四
学号: 1003,  姓名: 小娟
学号: 1006,  姓名: 张三
学号: 1008,  姓名: 王刚
哈哈嘿嘿!
-----------------------------	
*/
