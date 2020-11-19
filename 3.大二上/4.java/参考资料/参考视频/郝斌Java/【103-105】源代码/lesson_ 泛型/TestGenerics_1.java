/*
	Comparable<T> �ӿ��������·�����
		int compareTo(T o)
	
	Ҫ������ ����Comparable�ӿڵ��������ͣ��������÷�����ʵ�֣���������:
	class Student implements Comparable<Student>
	{
		......
		......
		
		public int compareTo(Student ob)  //ע��Student����д����Object
		{
		}		
*/


import java.util.*;

class Student implements Comparable<Student>
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
	
	@Override
	public String toString()
	{
		return id + " " + name + " " + age;
	}
	
	
	//�ββ���д��Object ob �����дΪ Student ob �������ʱ�ᱨ��������Ϣ�ǣ���Student ���ǳ���ģ�����δ���� java.lang.Comparable �еĳ��󷽷� compareTo(Student)��
//	public int compareTo(Object ob)  //�������Ǵ����
//	{
//		Student s = (Student)ob;
//		return this.id = s.id;
//	}

	//����������ȷ��
	public int compareTo(Student s)
	{
		return this.id - s.id;
	}
}

public class TestGenerics_1
{
	public static void main(String[] args)
	{
		List<Student> li = new ArrayList<Student>();
		li.add(new Student(1000, "zhangsan", 55));
		li.add(new Student(1005, "lisi", 15));
		li.add(new Student(1003, "wangwu", 32));
		li.add(new Student(1001, "xiaojuan", 65));
			
		System.out.println(li);
		
		Collections.sort(li);
		
		System.out.println(li);	
	}
}