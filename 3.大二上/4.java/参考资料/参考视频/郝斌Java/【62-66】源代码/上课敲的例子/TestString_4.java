/*
	2009年6月15日10:22:58
	统一一个字符串在另一个字符串中出现的次数
*/

public class TestString_4
{
	public static void main(String[] args)
	{
		String str1 = "abcasdabcbc";
		String str2 = "abc";
		int index = -1;
		int cnt = 0;
		
		index = str1.indexOf(str2);
		while (-1 != index)
		{
			++cnt;
			index = str1.indexOf(str2, index+str2.length());
		}
		System.out.printf("%d\n", cnt);		
	}
}