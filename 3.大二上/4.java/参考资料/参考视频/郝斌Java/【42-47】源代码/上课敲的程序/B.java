//2009��6��8��9:37:28

package com.ruide;
import zhangsan.lisi.*;

class B extends A
{
	public void f()
	{
		g();  //OK
		b();  //OK  �������ڲ����Է��ʴ���һ�����̳й����ĸ����public��protected��Ա
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