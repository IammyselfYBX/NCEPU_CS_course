/*
	2009年5月29日15:11:25
	本程序证明了: A类的多个对象公用一个static属性i
*/

class A
{
	public static int i = 10;
	
	public void show()
	{
		System.out.printf("%d\n", i);
	}
}

class M
{
	public static void main(String[] args)
	{
		A aa1 = new A();
		A aa2 = new A();
		A aa3 = new A();
		
		aa1.i = 20;
		aa2.show();
		System.out.printf("%d\n", aa3.i);
	}
}