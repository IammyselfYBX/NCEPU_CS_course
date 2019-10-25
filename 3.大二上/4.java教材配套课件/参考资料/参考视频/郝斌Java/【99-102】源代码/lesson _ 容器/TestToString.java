public class TestToString
{
	public static void main(String[] args)
	{
		Point p1 = new Point(1, 1);
		System.out.println(p1);
	}
}

class Point
{
	private int i, j;
	
	public Point()
	{
	}

	public Point(int i, int j)
	{
		this.i = i;
		this.j = j;
	}

	public String toString()  //24行
	{
		return i + ", " + j;
	}  //27行
}
/*
	在JDK 1.6中的运行结果是：
------------------------------
1 , 1
------------------------------
	如果把24行到27行全部注释到，则输出结果就是乱码
	所以“建议所有的类都应该重写toString方法”
*/

