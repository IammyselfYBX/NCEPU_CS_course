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

public class TestHashMap_2
{
	public static void main(String[] args){
		HashMap hm = new HashMap();
		hm.put(1001, new Student(1001, "zhangsan", 20));  //自动封装
		hm.put(1003, new Student(1003, "lisi", 30)); //自动封装
		hm.put(new Integer(1004), new Student(1004, "wangwu", 10));
		hm.put(1002, new Student(1002, "baichi", 20)); //自动封装
		
		//遍历所有的元素
		System.out.println("hm容器中所有的元素是:");
		Set s = hm.keySet();  //获取到当前容器键的集合，实际就是Integer对象的集合
		Iterator it = s.iterator();
		while (it.hasNext()){
			//int Key = (Integer)it.next();   // (Integer) 不能省， 利用了自动拆分技术      
			Integer Key = (Integer)it.next();
			System.out.println(hm.get(Key));
		}
		
		System.out.println("直接查找某一元素");
		System.out.println( hm.get(1003) );	
		System.out.println( hm.get(1005) );	  //如果找不到 则直接返回null，而不是抛出异常 			
	}
}
