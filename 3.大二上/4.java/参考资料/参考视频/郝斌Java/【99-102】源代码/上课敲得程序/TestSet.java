import java.util.*;

class Student implements Comparable
{ 
	private int id;
	private String name;
	
	public Student(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString()
	{
		return id + "  " + name;  //1000张三   
		//System.out.println();
	}	
	
	public boolean equals(Object ob)
	{
		Student st = (Student)ob;
		return st.id==this.id && st.name==this.name;
	}
	
//	public int hashCode()
//	{
//		return id * this.name.hashCode();
//	}
	
//	public int compareTo(Object ob)
//	{
//		Student st = (Student)ob;
//		return this.id-st.id;
//	}
}

public class TestSet
{
	public static void main(String[] args)
	{
		Set S = new TreeSet();  //TreeSet
		S.add(new Student(1000, "张三"));
		S.add(new Student(1003, "小娟"));
		S.add(new Student(1002, "王五"));
		S.add(new Student(1001, "李四"));
		S.add(new Student(1001, "李四"));
		S.add(new Student(1001, "李四"));
		S.add(new Student(1001, "李四"));
		S.add(new Student(1001, "李四"));
		S.add(new Student(1001, "李四"));


		
		System.out.println(S);  //[
	}
}
