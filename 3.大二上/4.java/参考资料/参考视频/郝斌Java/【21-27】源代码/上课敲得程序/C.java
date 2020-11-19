/*
	2009年5月31日14:05:02
	本程序证明了: 一个类的属性可以是个类对象
*/

class A
{

}

class C
{
	public int i = 10;
	public A aa = new A();  //aa一定是个对象, aa是否也是C的属性？ 是
}

class M
{
	public static void main(String[] args)
	{
	}	
}