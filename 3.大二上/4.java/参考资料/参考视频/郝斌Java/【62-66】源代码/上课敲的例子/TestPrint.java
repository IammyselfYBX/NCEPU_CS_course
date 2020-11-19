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
		System.out.printf("%d的值 + %d的值 是 %d\n", i, j, k);
		//System.out.println(i + "的值 + " + j + "的值 是 " + k);
		
		int m = 47;
		System.out.println(m);
		System.out.printf("%d\n", m);
		
		System.out.printf("十进制数字%d用十六进制表示是: %#X\n", m, m);
		//System.out.println("十进制数字" + m + "用十六进制表示是: 0X" + Integer.toHexString(m).toUpperCase());
		
		
		System.out.printf("%b\n", "abc".equals("zhangsan"));
		System.out.printf("%d\n", "abc".length());
		System.out.printf("%d\n", "abcadssad".indexOf("ads"));
		
	}
}