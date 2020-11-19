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
		return id + "  " + name;  //1000����   
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
		S.add(new Student(1000, "����"));
		S.add(new Student(1003, "С��"));
		S.add(new Student(1002, "����"));
		S.add(new Student(1001, "����"));
		S.add(new Student(1001, "����"));
		S.add(new Student(1001, "����"));
		S.add(new Student(1001, "����"));
		S.add(new Student(1001, "����"));
		S.add(new Student(1001, "����"));


		
		System.out.println(S);  //[
	}
}
