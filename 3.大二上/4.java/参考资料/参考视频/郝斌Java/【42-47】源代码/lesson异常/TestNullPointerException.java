class Person{
	public int age;
}
public class TestNullPointerException{
	public static void main(String[] args) {
		Person p = null;
		System.out.println(p.age);
	}
}
