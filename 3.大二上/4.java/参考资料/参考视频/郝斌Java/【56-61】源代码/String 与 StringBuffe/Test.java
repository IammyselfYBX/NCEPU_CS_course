/*
	2008��11��3��17:04:42
	������˵����:  StringBuffer �����Ҫ��

	String s1 = "zhangsan";
	ֻʹ��String����ɾ��s1�����еĵ�һ��n�����ĸ�ķ���
*/

public class Test
{
	public static void main(String[] args)
	{
		String s1 = "zhangsan";
		String s2 = s1.substring(0, 3);
		String s3 = s1.substring(4, s1.length());
		s1 = s2 + s3;

		System.out.println("s1 = " + s1);
	}
}
/*
	��JDK 1.6�е����н���ǣ�
------------------------------
s1 = zhagsan
------------------------------
*/