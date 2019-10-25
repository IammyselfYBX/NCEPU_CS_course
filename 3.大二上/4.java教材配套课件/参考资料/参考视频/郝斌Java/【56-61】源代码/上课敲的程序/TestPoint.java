class Dian
{
	public int x, y;
	
	public Dian(int x, int y)
	{
		this.x = x; 
		this.y = y;
	}
	
	public String toString()
	{
		return "[" + x + ", " + y + "]";  //[3, 5]
	}
}

public class TestPoint
{
	public static void main(String[] args)
	{
		Dian d = new Dian(3, 5);
		//System.out.printf("%s", d);	
		System.out.println(d);	
	}
}