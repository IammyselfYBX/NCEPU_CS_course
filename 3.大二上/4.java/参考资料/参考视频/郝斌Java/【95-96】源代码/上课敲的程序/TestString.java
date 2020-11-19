import java.io.*;

public class TestString
{
	public static void main(String[] args)
	{
		String str = null;
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
			str = br.readLine();
			System.out.println("str = " + str);
		}
		catch (Exception e)
		{
		}
		
	}
}