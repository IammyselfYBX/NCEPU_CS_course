class Person
{
	private String name;
	private	int age;
	
	public Person()
	{
	}
	
	public Person(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name)
	{
		this.name = name;
	} 
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public String getInfor()
	{
		return "name: " + name + ",  age: " + age;
	}
}

class Student extends Person
{
	private String school;
	
	public Student()
	{
	}
	
	public Student(String name, int age, String school)
	{
		super(name, age);
		this.school = school;
	}
	
	public void setSchool(String school)
	{
		this.school = school;
	}
	
	public String getInfor()
	{
		String strInfor = "name: " + getName() + ",  age:" + getAge() + 
						   	",  school:" + school;
		return strInfor;		
	}
}

public class TestOverWrite_1
{
	public static void main(String[] args)
	{
		Person p1 = new Person("zhangsan", 30);
		System.out.println(p1.getInfor());
		
		Student s1 = new Student();
		s1.setName("lisi");
		s1.setAge(88);
		s1.setSchool("ruide");
		System.out.println(s1.getInfor());
	}
}