class A
{
	int divide(int a, int b)  
	{
		int m;
		//System.out.printf("22222\n");
		m = a / b;
		//System.out.printf("11111\n");
		return m;
	}
}

public class TestExcep_1
{
	public static void main(String[] args)
	{
		A aa = new A();
		
		//aa.divide(6, 0);
		
		try
		{
			aa.divide(6,2);
		}
		catch (ArithmeticException e)  //e用来接收23行抛出的异常对象
		{
			e.printStackTrace(); //可以简单理解为 输出该异常的具体信息
			System.out.printf("除零错误， 你的程序出错啦！ 除数不能为零， 嘿嘿!\n");
		}		
		
		System.out.printf("今天我很高心，因为我和世界的关系和和谐!\n");
	}
}