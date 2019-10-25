class A
{
	public int i = 20;
	private static A aa = new A(); //aa是否是A对象的属性
	
	private A()
	{
	}
	
	public static A getA()  //static 一定是不能省略的
	{
		return aa;
	}
}

public class TestStatic_2
{
	public static void main(String[] args)
	{
		A aa1 = A.getA();
		A aa2 = A.getA();
		
		aa1.i = 99;
		System.out.printf("%d\n", aa2.i);
		
		if (aa1 == aa2)
			System.out.printf("aa1 和 aa2相等\n");
		else
			System.out.printf("aa1 和 aa2不相等\n");
		
		
//		A aa1 = new A();  // error 如果A类的构造方法是private的，则new A()就会报错!
//		A aa2 = new A();  //同上
		
	}
}