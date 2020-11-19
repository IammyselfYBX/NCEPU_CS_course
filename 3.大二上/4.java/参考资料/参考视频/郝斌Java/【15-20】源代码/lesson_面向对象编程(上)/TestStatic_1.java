class Student{
	public static int cnt = 0;
	private String sname;
	private int sage;
	public Student(){
		cnt++;		
	}
	public Student(String name, int age) {
		this.sname = name;	this.sage =  age;		cnt++;
	}
}

public class TestStatic_1{
	public static void main(String[] args) {
		System.out.println("Student.cnt = " + Student.cnt );
		Student st1 = new Student("zhangsan", 20);
		Student st2 = new Student("lisi", 30);
		System.out.printf("Student类总共构造了%d个对象!\n", Student.cnt);
	}
}
