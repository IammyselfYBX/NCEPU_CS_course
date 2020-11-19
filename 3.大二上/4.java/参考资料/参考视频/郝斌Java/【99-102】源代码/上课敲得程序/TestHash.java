class B
{
	private int i;
	
	public B(int i)
	{
		this.i = i;
	}
	
	public boolean equals(Object ob)
	{
		B bb = (B)ob;
		return this.i == bb.i;
	}
	
	public int hashCode() //Integer(1)
	{
		return new Integer(i).hashCode(); 
	}
}

class Student
{
	private int id;
	private String name;
	
	public Student(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	public int hashCode()
	{
		//return new String(name+id).hashCode();
		return id * name.hashCode();
	}
}

public class TestHash
{
	public static void main(String[] args)
	{
//		B bb1 = new B(1);
//		B bb2 = new B(10);
//		System.out.println(bb1.equals(bb2));  //true
//		System.out.println(bb1.hashCode() == bb2.hashCode()); // false
	
		Student st1 = new Student(1, "1111");
		Student st2 = new Student(1, "1111");
		System.out.println(st1.hashCode() == st2.hashCode()); //
		
	}
}