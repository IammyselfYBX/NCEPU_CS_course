/*
	所有可以排序的类都应该实现Comparable接口
*/

import java.util.*;
import java.util.Collections;

class Person  implements Comparable
{
	private int id;
	private String name;
	
	public Person()
	{
	}
	
	public Person(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	public String toString()
	{
		return "id: " + id + ",  name: " + name ;
	}
	
	@Override
	public int compareTo(Object o)
	{
		Person p = (Person)o;
		return this.id - p.id;
	}
}


public class TestComparable
{
	public static void main(String[] args)
	{
		ArrayList c = new ArrayList();  //不能写成：Collection c = new ArrayList(); 这会导致49行出错，因为Collection.sort()接受的形参必须的是List接口类型的变量,Collection.sort()不能接受Collection类型的变量，这语法上编译时是通不过的
		c.add(new Person(1000, "zhangsan"));
		c.add(new Person(1002, "wangwu"));
		c.add(new Person(1001, "lisi"));
		c.add(new Person(1008, "xiaojuan"));
		c.add(new Person(1005, "asd"));
		for (int i=0; i<c.size(); ++i)
		{
			System.out.println(c.get(i));
		}
		
		java.util.Collections.sort(c);  //49行
		
		System.out.println("排序之后的内容是:");
		Iterator it = c.iterator();
		while (it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}
/*
	在JDK 1.6中的运行结果是：
-----------------------------
id: 1000,  name: zhangsan
id: 1002,  name: wangwu
id: 1001,  name: lisi
id: 1008,  name: xiaojuan
id: 1005,  name: asd
排序之后的内容是:
id: 1000,  name: zhangsan
id: 1001,  name: lisi
id: 1002,  name: wangwu
id: 1005,  name: asd
id: 1008,  name: xiaojuan
-----------------------------
*/