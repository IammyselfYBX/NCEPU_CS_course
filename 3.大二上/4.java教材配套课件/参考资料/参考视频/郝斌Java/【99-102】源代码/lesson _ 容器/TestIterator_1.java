import java.util.*;

public class TestIterator_1
{
	//可以遍历所有Collection接口的实现类
	public static void showCollection(Collection c)
	{
		Iterator it = c.iterator();
		while (it.hasNext())
		{
			System.out.println(it.next());
		}
	}

	public static void main(String[] args)
	{
		ArrayList al = new ArrayList();
		al.add("one");
		al.add(22);
		al.add(new Point(1,1));
		System.out.println("a1 容器的内容是:");
		showCollection(al);
		
		HashSet hs = new HashSet();
		hs.add("one");
		hs.add(22);
		hs.add(new Point(1,1));
		System.out.println("hs容器的内容是:");
		showCollection(hs);
	}
}

class Point
{
	private int i, j;
	
	public Point(int i, int j)
	{
		this.i = i;
		this.j = j;
	}
	
	public String toString()
	{
		return "[" + i + ", " + j + "]";
	}
}