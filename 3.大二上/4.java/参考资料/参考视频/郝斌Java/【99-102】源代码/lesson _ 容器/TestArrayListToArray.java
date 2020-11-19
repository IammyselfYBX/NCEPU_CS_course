/*
	ArrayList�����е�toArray()
					 size()
	��ʹ��				
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

		System.out.println("a1.get(2) = " + a1.get(2)); //a1.get(2)���ص�����Ԫ�أ�ע�ⲻ��д��a1[2],��Ϊa1��ArrayList���͵Ķ��� ��������ͨ����
	
		
		Object [] obs = a1.toArray(); //toArray()���ص���Object���͵�����
		for (int i=0; i<obs.length; ++i) // obs.length��a1.size()��һ����Ч������Ҫע�ⲻ�ܻ��д��obs.size() �� a1.length() �ⶼ�Ǵ��!
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
	��j2sdk1.4.2_16�е����н���ǣ�
----------------------------
[x=1,y=1, x=2,y=2, x=3,y=3]
a1.get(2) = x=3,y=3
x=1,y=1
x=2,y=2
x=3,y=3
----------------------------
	�ܽ᣺
		ArrayList�ɱ����鲻��ʹ�� [], ����ʹ��get(int index);
		��ͨ�������ʹ��[], ���һ�����ʹ���ֶ�length,������ʹ��get(int index);


*/
