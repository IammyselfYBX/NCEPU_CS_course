/*
	���п���������඼Ӧ��ʵ��Comparable�ӿ�
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
		ArrayList c = new ArrayList();  //����д�ɣ�Collection c = new ArrayList(); ��ᵼ��49�г�����ΪCollection.sort()���ܵ��βα������List�ӿ����͵ı���,Collection.sort()���ܽ���Collection���͵ı��������﷨�ϱ���ʱ��ͨ������
		c.add(new Person(1000, "zhangsan"));
		c.add(new Person(1002, "wangwu"));
		c.add(new Person(1001, "lisi"));
		c.add(new Person(1008, "xiaojuan"));
		c.add(new Person(1005, "asd"));
		for (int i=0; i<c.size(); ++i)
		{
			System.out.println(c.get(i));
		}
		
		java.util.Collections.sort(c);  //49��
		
		System.out.println("����֮���������:");
		Iterator it = c.iterator();
		while (it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}
/*
	��JDK 1.6�е����н���ǣ�
-----------------------------
id: 1000,  name: zhangsan
id: 1002,  name: wangwu
id: 1001,  name: lisi
id: 1008,  name: xiaojuan
id: 1005,  name: asd
����֮���������:
id: 1000,  name: zhangsan
id: 1001,  name: lisi
id: 1002,  name: wangwu
id: 1005,  name: asd
id: 1008,  name: xiaojuan
-----------------------------
*/