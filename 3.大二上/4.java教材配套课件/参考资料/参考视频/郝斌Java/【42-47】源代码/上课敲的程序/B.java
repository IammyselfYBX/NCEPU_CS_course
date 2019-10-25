//2009年6月8日9:37:28

package com.ruide;
import zhangsan.lisi.*;

class B extends A
{
	public void f()
	{
		g();  //OK
		b();  //OK  在子类内部可以访问从另一个包继承过来的父类的public和protected成员
	}
}

class M
{
	public static void main(String[] args)
	{
		B bb = new B();
		//bb.f();  //OK
		//bb.g();  //OK
		//bb.b(); //error	
	}
}