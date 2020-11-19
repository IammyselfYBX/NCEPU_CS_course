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

	public String toString()  //24��
	{
		return i + ", " + j;
	}  //27��
}
/*
	��JDK 1.6�е����н���ǣ�
------------------------------
1 , 1
------------------------------
	�����24�е�27��ȫ��ע�͵�������������������
	���ԡ��������е��඼Ӧ����дtoString������
*/

