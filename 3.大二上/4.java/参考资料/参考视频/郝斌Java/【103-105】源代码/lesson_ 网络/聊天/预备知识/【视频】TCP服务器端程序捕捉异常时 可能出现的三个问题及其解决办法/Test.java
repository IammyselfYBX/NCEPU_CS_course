/*
	try{.....}中定义的局部变量只能在try {......}中使用，不能在其他地方使用
*/

public class Test
{
	public static void main(String[] args)
	{
		try
		{
			int i = 10;
			System.out.println("i = " + i);
		}
		catch (Exception e)
		{
			//System.out.println("i = " + i);  //error   因为在try{.....}中定义的局部变量只能在try{....}中使用，   try{.....}中定义的局部变量不能在catch(..) {.....} 和 finally{.....}中使用
		}
		finally
		{ 
			//System.out.println("i = " + i);    //error 原因同上
		}
		
		//System.out.println("i = " + i);    //总结: try{.....}中定义的局部变量只能在try {......}中使用，不能在其他地方使用
	}
}