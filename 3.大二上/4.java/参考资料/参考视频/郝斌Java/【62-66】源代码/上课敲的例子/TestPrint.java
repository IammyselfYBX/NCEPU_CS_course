import java.lang.String;

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
		return "[" + x + ", " + y + "]";
	}
}


public class TestPrint
{
	public static void main(String[] args)
	{
		Dian d = new Dian(3, 2);
		//System.out.printf("%s\n", d);
		System.out.println(d);
	
		int i, j, k;
		i = 1;
		j = 2;
		k = 3;
		System.out.printf("%d��ֵ + %d��ֵ �� %d\n", i, j, k);
		//System.out.println(i + "��ֵ + " + j + "��ֵ �� " + k);
		
		int m = 47;
		System.out.println(m);
		System.out.printf("%d\n", m);
		
		System.out.printf("ʮ��������%d��ʮ�����Ʊ�ʾ��: %#X\n", m, m);
		//System.out.println("ʮ��������" + m + "��ʮ�����Ʊ�ʾ��: 0X" + Integer.toHexString(m).toUpperCase());
		
		
		System.out.printf("%b\n", "abc".equals("zhangsan"));
		System.out.printf("%d\n", "abc".length());
		System.out.printf("%d\n", "abcadssad".indexOf("ads"));
		
	}
}