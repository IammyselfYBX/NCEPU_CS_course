/**
 * 	2009年3月27日10:36:30
 * 	有关Java虚拟机异常处理机制的问题
 * 	
 *  */

class A
{
	public void f()
	{
		System.out.println("AAAA");
	}
}

public class Test 
{
	public static void main(String[] args)
	{
		A aa1 = null;  //aa1必须的被赋值，否则会导致21行出错，因为编译器认为16行并一定会成功给aa1赋值，
					   //不过令人遗憾的是：编译器在编译时却检测不出空指针异常错误，以本程序为例，因为16行并不一定可以成功给aa1赋值，所以理论上讲21行的aa1仍然可能是null，但是令人遗憾的是编译器编译时却检测不出这种错误，它只会在运行时抛出java.lang.NullPointerException异常	
		try
		{
			aa1 = new A();  //16行
		}
		catch (Exception e)
		{
		}
		//aa1 = new A();
		
		aa1.f();  //21行   编译器在编译时检测不出空指针异常错误，以本程序为例，因为16行并不一定可以成功给aa1赋值，所以理论上讲本行中的aa1仍然可能是null，但是令人遗憾的是编译器编译时却检测不出这种错误，它只会在运行时抛出java.lang.NullPointerException异常	
		
		
//		/*
//		 * 	下面两行代码验证了：   
//			编译器在编译时检测不出空指针异常错误，它只会在运行时抛出
//			java.lang.NullPointerException异常	
//		*/
//		A aa2 = null;
//		aa2.f();  //编译器编译时检测不会出错，只会在运行时抛出	java.lang.NullPointerException异常	
	}
	
}
