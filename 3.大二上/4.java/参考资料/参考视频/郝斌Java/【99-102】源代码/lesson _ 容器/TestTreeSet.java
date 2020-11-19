/*
	2009��2��21��22:10:30
	�ܽ�:
	��TreeSet��������ӵĶ���������ʵ��Comparable�ӿڵ������ ���������г���ᱨ��
	��TreeSet��������ӵĶ�����Բ���дhashCode������equasl����.
*/

import java.util.*;

public class TestTreeSet
{
	public static void main(String[] args)
	{
		Collection c = new TreeSet();
		
		c.add(new Student(1006, "����"));
		c.add(new Student(1003, "С��")); //16��
		c.add(new Student(1002, "����"));
		c.add(new Student(1008, "����")); //16��
		c.add(new Student(1001, "����")); //16��
		
		Iterator i = c.iterator();
		while (i.hasNext())
		{
			System.out.println(i.next());
		}
		System.out.println("�����ٺ�!");
		
		
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
		return "ѧ��: " + this.num + ",  ����: " + name;
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
	��JDK 1.6�е����н���ǣ�
-----------------------------
ѧ��: 1001,  ����: ����
ѧ��: 1002,  ����: ����
ѧ��: 1003,  ����: С��
ѧ��: 1006,  ����: ����
ѧ��: 1008,  ����: ����
�����ٺ�!
-----------------------------	
*/
