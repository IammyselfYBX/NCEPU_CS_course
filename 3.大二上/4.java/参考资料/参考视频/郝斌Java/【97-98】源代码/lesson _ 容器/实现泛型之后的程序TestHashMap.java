/*
	2009��4��3��11:37:19
	ʵ�ַ���֮��ĳ���
*/

import java.util.*;

class Student
{
	private int id;
	private String name;
	private int age;
	
	public Student()
	{
	}
	
	public Student(int id, String name, int age)
	{
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public int hashCode()
	{
		return this.name.hashCode()*id*age;
	}	
	
	public boolean equals(Object o)
	{
		Student s = (Student)o;
		return this.name.equals(s.name) && this.id==s.id && this.age==s.age;	
	}	

	public String toString()
	{
		return id + "  " + name + "  " + age;
	}
}

public class TestHashMap2
{
	public static void main(String[] args)
	{
		HashMap<Integer, Student> hm = new HashMap<Integer, Student>();
		
		hm.put(1001, new Student(1001, "zhangsan", 20));
		hm.put(1003, new Student(1003, "lisi", 30));
		hm.put(1004, new Student(1004, "wangwu", 10));
		hm.put(1002, new Student(1002, "baichi", 20));
		
		//�������е�Ԫ��
		System.out.println("hm���������е�Ԫ����:");
		Set<Integer> s = hm.keySet();
		Iterator<Integer> it = s.iterator();
		while (it.hasNext())
		{
			int Key  = (Integer)it.next();   // (Integer) ����ʡ      
			System.out.println(hm.get(Key));
		}
		
		System.out.println("ֱ�Ӳ���ĳһԪ��");
		System.out.println( hm.get(1003) );	
		System.out.println( hm.get(1005) );	  //����Ҳ��� ��ֱ�ӷ���null 			
	}
}