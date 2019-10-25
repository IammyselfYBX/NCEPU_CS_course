public class TestExcep_2
{
	public static void main(String[] args)
	{
		int m = 99;
		
		try
		{
			m = 2;
			System.out.printf("m = %d\n", m);
		}
		catch (Exception e)
		{
			
		}
		
		System.out.printf("m = %d\n", m);
	}
}