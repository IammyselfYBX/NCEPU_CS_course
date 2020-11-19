/*
	ArrayList对象中的toArray()
					 size()
	的使用				
*/

import java.util.*;

public class TestArrayListToArray 
{
	public static void main(String[] args) 
	{
		ArrayList a1 = new ArrayList();
		a1.add(new Point(1,1));
		a1.add(new Point(2,2));
		a1.add(new Point(3,3));
		System.out.println(a1);

		System.out.println("a1.get(2) = " + a1.get(2)); //a1.get(2)返回第三个元素，注意不能写成a1[2],因为a1是ArrayList类型的对象， 而不是普通数组
	
		
		Object [] obs = a1.toArray(); //toArray()返回的是Object类型的数组
		for (int i=0; i<obs.length; ++i) // obs.length和a1.size()是一样的效果，但要注意不能混合写成obs.size() 或 a1.length() 这都是错的!
		{
			System.out.println(obs[i]);
		}
	}
}

class Point
{
	int x;
	int y;

	Point(int i, int j)
	{
		x = i;
		y = j;
	}

	public String toString()
	{
		return "x=" + x + ",y=" + y;
	}
}
/*
	在j2sdk1.4.2_16中的运行结果是：
----------------------------
[x=1,y=1, x=2,y=2, x=3,y=3]
a1.get(2) = x=3,y=3
x=1,y=1
x=2,y=2
x=3,y=3
----------------------------
	总结：
		ArrayList可变数组不能使用 [], 必须使用get(int index);
		普通数组可以使用[], 并且还可以使用字段length,但不能使用get(int index);


*/
