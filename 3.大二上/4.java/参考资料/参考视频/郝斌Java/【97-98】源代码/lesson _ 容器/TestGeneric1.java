/*
	2008��11��23��17:51:03
	�������� ���ȱ�̬�ĳ���
*/

class IntegerFoo
{
	private Integer foo;

	public void setFoo(Integer foo)
	{
		this.foo = foo;
	}

	public Integer getFoo()
	{
		return foo;
	}
}

class StringFoo
{
	private String foo;

	public void setFoo(String foo)
	{
		this.foo = foo;
	}

	public String getFoo()
	{
		return foo;
	}
}

public class TestGeneric1
{
	public static void main(String[] args)
	{
		IntegerFoo foo1 = new IntegerFoo();
		foo1.setFoo(new Integer(55));
		Integer it = foo1.getFoo();
		System.out.println(it.floatValue());

		StringFoo foo2 = new StringFoo();
		foo2.setFoo(new String("zhangsan"));
		String st = foo2.getFoo();
		System.out.println(st.equals("zhangsan"));
	
		System.out.println("�ٺ�");
	}
}
/*
	��JDK 1.6�е����н���ǣ�
---------------------
55.0
true
�ٺ�
---------------------
*/