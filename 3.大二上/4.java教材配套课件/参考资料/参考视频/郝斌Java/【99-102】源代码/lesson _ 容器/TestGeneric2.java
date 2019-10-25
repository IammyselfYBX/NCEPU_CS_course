class ObjectFoo
{
	private Object foo;

	public ObjectFoo()
	{
	}

	public ObjectFoo(Object foo)
	{
		this.foo = foo;
	}

	public void setFoo(Object foo)
	{
		this.foo = foo;
	}

	public Object getFoo()
	{
		return foo;
	}
}

public class TestGeneric2
{
	public static void main(String[] args)
	{
		ObjectFoo foo1 = new ObjectFoo();
		foo1.setFoo(new Integer(32));
		Integer it = (Integer)foo1.getFoo();
		System.out.println(it.floatValue());

		ObjectFoo foo2 = new ObjectFoo();
		foo2.setFoo(new String("zhangsan"));
		String st = (String)foo2.getFoo();
		System.out.println(st.equals("lisi"));
		
		System.out.println("我恨冷啊!"); 
	}
}
/*
	在JDK 1.6中的运行结果是：
-----------------
32.0
false
我恨冷啊!
-----------------
*/