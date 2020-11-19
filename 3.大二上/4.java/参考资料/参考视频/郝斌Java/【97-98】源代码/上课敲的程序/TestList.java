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
	
	@Override
	public int compareTo(Object o)
	{
		Student st = (Student)o;
		
		if (this.id == st.id)
			return 0;
		else if (this.id > st.id)
			return 1;
		else
			return -1;		
	}
}

public class TestList
{
	public static void main(String[] args)
	{
		List L = new ArrayList();
		L.add(new Student(1000, "张三"));
		L.add(new Student(1003, "小娟"));
		L.add(new Student(1002, "王五"));
		L.add(new Student(1001, "李四"));

		
		Collections.sort(L);
		
		System.out.println(L);  //[
	}
}
