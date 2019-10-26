import java.io.*;

public class TestFileReader
{
	public static void main(String[] args) throws Exception
	{
		FileReader fr = new FileReader("D:\\share\\S5\\di-19\\TestFileReader.java");
		int ch;
		
		ch = fr.read();
		while (-1 != ch)
		{
			System.out.printf("%c", ch);
			ch = fr.read();
		}
		fr.close();	
	}
}