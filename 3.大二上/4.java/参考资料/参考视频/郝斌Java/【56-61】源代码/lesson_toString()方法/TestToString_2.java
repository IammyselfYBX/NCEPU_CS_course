class Point
{
	private int i, j;
	
	public Point(int i, int j)
	{
		this.i = i;
		this.j = j;
	}
	
	//�����12��15�еĴ���ע�͵�������������������
	public String toString()  //12
	{
		return "[" + i + ", " + j + "]";
	} //15
}

public class TestToString_2
{
	public static void main(String[] args)
	{
		Point p1 = new Point(1, 1);
		Point p2 = new Point(2, 2);
		System.out.println(p1);
		System.out.println(p2);
	}
}