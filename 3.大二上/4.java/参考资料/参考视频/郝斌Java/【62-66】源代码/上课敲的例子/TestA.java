class A
{
	public String ToString()
	{
		return "����";
	}
}

public class TestA
{
	public static void main(String[] args)
	{
		//System.out.println(new A());
		A aa = new A();
		System.out.println(aa);//�ȼ���System.out.println(aa.toString()); 
	}
}	