/*
	Exception类中有一个private的Message属性，通过构造函数 
			public Exception(String message)
	可以完成对该属性的初始化

*/

class E extends Exception
{
	public E()
	{
		super("哈哈");  //这实际是调用父类Exception的构造函数： public Exception(String message)
		//this.Message = "哈哈";  //error
	}
}

class M
{
	public static void f() throws E  //也可以改为  throws Exception
	{
		throw new E();
	}
	
	public static void main(String[] args)
	{
		try
		{
			f();
		}
		catch (Exception e)
		{
			String strExcep = e.getMessage();
			System.out.println("strExcep = " + strExcep);
		}
		
		System.out.println("程序正常终止了!");
	}
}
/*
	在JDK 1.6中的运行结果是：
--------------------------------
strExcep = 生命在于静止!
程序正常终止了!
--------------------------------
	总结:
		getMessage() 返回的是异常的具体信息，是个String类型
		public Exception(String message) 用message字符串来表示异常的具体信息

*/

