/*
	2009年2月20日18:28:31
	String 和 Integer 这些Java自带的类都重写了hashCode方法，如果String 和 Integer new出来的
	对象的内容是一样的，则这些对象的hashCode返回值也是一样的，虽然这些对象占用的是不同的内存
	
	不过用户自定义类型则不同，如本程序的A类，即便是两个内容一模一样的A类对象，它们返回的
	hashCode值也是不一样的，但是两个内容一模一样的Integer类对象或者String类对象返回的
	hashCode值却是一样的，因为系统自带的String 和 Integer 类都已经重写了Object的hashCode方法嘛！

	
	如果程序员希望自己定义的类对象，占用不同内存空间但内容却是一样的对象调用hashCode方法
	返回值是一样的，则程序员就必须自己重写hashCode方法,如本程序的B类
*/

class A
{
	private int id;
	
	public A(int id)
	{
		this.id = id;
	}
}


class B
{
	private int id;
	
	public B(int id)
	{
		this.id = id;
	}
	
	@Override
	public int hashCode()
	{
		return new Integer(id).hashCode();
	}
}

public class TestHashCode_1{
	public static void main(String[] args) {
		System.out.println("new A(1).hashCode() = " + new A(1).hashCode());
		System.out.println("new A(1).hashCode() = " + new A(1).hashCode());
		System.out.println();		
		System.out.println("new Integer(1).hashCode() = " + new Integer(1).hashCode());
		System.out.println("new Integer(1).hashCode() = " + new Integer(1).hashCode());
		System.out.println();		
		System.out.println("new String(\"haha\").hashCode() = " + new String("haha").hashCode());
		System.out.println("new String(\"haha\").hashCode() = " + new String("haha").hashCode());
		System.out.println();		
		System.out.println("\"haha\".hashCode() = " + "haha".hashCode());
		System.out.println("\"haha\".hashCode() = " + "haha".hashCode());
		System.out.println();		
		System.out.println("new B(1).hashCode() = " + new B(1).hashCode());
		System.out.println("new B(1).hashCode() = " + new B(1).hashCode());
		
		Integer it1 = new Integer(1);		
		Integer it2 = new Integer(1);
		System.out.println(it1 == it2);
		System.out.println(it1.equals(it2));
		System.out.println(it1.hashCode() == it2.hashCode());
	}
}
/*
	在JDK 1.6中的运行结果是：
--------------------------
new A(1).hashCode() = 14576877
new A(1).hashCode() = 12677476

new Integer(1).hashCode() = 1
new Integer(1).hashCode() = 1

new String("haha").hashCode() = 3194802
new String("haha").hashCode() = 3194802

"haha".hashCode() = 3194802
"haha".hashCode() = 3194802

new B(1).hashCode() = 1
new B(1).hashCode() = 1
false
true
true
--------------------------
*/