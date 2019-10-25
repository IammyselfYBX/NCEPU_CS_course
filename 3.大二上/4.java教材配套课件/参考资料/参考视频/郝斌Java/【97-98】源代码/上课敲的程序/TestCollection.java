import java.util.*;

public class TestCollection{
	public static void main(String[] args){
		Collection c = new LinkedList();
		c.add(new Student("zhangsan", 80));
		c.add(66.6);
		System.out.println(c);
	}
}

class Student 
{
	private String name;
	private int age;
	public Student(String name, int age){
		this.name = name;
		this.age = age;
	}
	//如果把toString方法注释掉了，则程序输出结果会有乱码
	public String toString()	{
		return name + " " + age; 
	}
}
