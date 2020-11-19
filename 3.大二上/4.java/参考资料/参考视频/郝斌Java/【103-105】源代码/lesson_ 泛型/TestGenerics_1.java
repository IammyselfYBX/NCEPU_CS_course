/*
	Comparable<T> 接口中有如下方法：
		int compareTo(T o)
	
	要想限制 传入Comparable接口的数据类型，可以利用泛型来实现，具体如下:
	class Student implements Comparable<Student>
	{
		......
		......
		
		public int compareTo(Student ob)  //注意Student不能写成了Object
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
	
	
	//形参不能写成Object ob 必须得写为 Student ob 否则编译时会报错，出错信息是：“Student 不是抽象的，并且未覆盖 java.lang.Comparable 中的抽象方法 compareTo(Student)”
//	public int compareTo(Object ob)  //本方法是错误的
//	{
//		Student s = (Student)ob;
//		return this.id = s.id;
//	}

	//本方法是正确的
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