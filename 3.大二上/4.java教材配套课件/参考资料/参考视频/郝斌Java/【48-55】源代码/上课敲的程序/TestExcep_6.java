class A
{
	int divide(int a, int b)
	{
		int m = 0;
		
		m = a / b;;
		return m;
	}
}

public class TestExcep_6
{
	public static void main(String[] args)
	{
		try
		{
			new A().divide(6, 0);
		}
		catch (Exception e)
		{
			System.out.printf("ºÙºÙ\n");
			e.printStackTrace();
		}
		finally
		{
			System.out.printf("ºÃ¾Ã°¡¹þ\n");
		}
		
				
	}
}
