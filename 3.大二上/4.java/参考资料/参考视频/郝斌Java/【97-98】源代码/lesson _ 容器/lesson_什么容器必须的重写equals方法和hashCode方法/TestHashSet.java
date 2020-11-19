/*
	2008年11月17日14:57:12
	Student类必须同时实现equals方法 和 hashCode方法 才可以保证在装入HashSet类时不会出现“重复”装入的情况
	重新实现了equals方法 和 hashCode 方法 的正确的程序
*/

import java.util.*;

public class TestHashSet
{
	public static void main(String[] args)
	{
		Collection c = new HashSet();
		c.add(new Student(1001, "张三"));
		c.add(new Student(1002, "李四"));
		c.add(new Student(1003, "王五")); //10行
		c.add(new Student(1003, "王五"));
		c.add(new Student(1003, "王五"));
		c.add(new Student(1003, "王五"));
		c.add(new Student(1003, "王五")); //14行

		Iterator i = c.iterator();
		while (i.hasNext())
		{
			System.out.println(i.next());
		}
	}
}

class Student
{
	private int num;
	private String name;

	public Student()
	{
	}

	public Student(int num, String name)
	{
		this.num = num;
		this.name = name;
	}

	public String toString()
	{
		return "学号: " + this.num + ",  姓名: " + name;
	}
	
	public boolean equals(Object o)
	{
		Student s = (Student)o;
		
		return this.num==s.num && this.name.equals(s.name);
	}

	public int hashCode()
	{
		//return num; //如果你设定的学生信息中学号是唯一的，则可以直接用num来作为哈希码
		return num * this.name.hashCode();
	}
}
/*
	在JDK 1.6中的运行结果是：
-----------------------------
学号: 1002,  姓名: 李四
学号: 1003,  姓名: 王五
学号: 1001,  姓名: 张三
-----------------------------
	总结:
		必须同时实现equals()方法 和 hashCode() 方法,只要有任意一个方法没有实现
	装入时就会出现重复元素
*/
