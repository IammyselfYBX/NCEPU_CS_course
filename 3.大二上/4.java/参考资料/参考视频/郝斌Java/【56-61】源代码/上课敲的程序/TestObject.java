class A 
{
	public String toString()
	{
		return "����";
	}
}

public class TestObject
{
	public static void main(String[] args)
	{
		A aa = new A();
		System.out.printf("%s\n", aa.toString());
	}
}