/*
	2008年11月23日17:51:03
	极度无聊 极度变态的程序
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
	
		System.out.println("嘿嘿");
	}
}
/*
	在JDK 1.6中的运行结果是：
---------------------
55.0
true
嘿嘿
---------------------
*/