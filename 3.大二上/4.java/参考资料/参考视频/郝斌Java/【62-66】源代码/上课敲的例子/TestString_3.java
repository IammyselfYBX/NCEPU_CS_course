/*
	2009年6月15日10:08:40
	统计一个String对象中大写字母 小写字母 非字母 各自出现的个数
*/

class TestString_3
{
	public static void main(String[] args)
	{
		String str = "abAM1,!23";
		int cntU = 0; //大写字母的个数
		int cntL = 0; //小写字母的个数
		int cntOther = 0;
		int i;
		
		
		//第二种方法
		String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String s2 = "abcdefghijklmnopqrstuvwxyz";
		for (i=0; i<str.length(); ++i)
		{
			char ch = str.charAt(i);

			if (-1 != (s1.indexOf(ch)))
			{
				cntU++;
			}
			else if (-1 != s2.indexOf(ch))
			{
				cntL++;
			}
			else
			{
				cntOther++;
			}
		}

		
//		//方法二
//		for (i=0; i<str.length(); ++i)
//		{
//			char ch = str.charAt(i);
//			if (Character.isUpperCase(ch))
//				cntU++;
//			else if (Character.isLowerCase(ch))
//				cntL++;
//			else
//				cntOther++;
//		}
		
		
		//方法一
//		for (i=0; i<str.length(); ++i)
//		{
//			char ch = str.charAt(i);
//			if (ch>='a' && ch<='z'){
//				cntL++;
//			}
//			else if (ch>='A' && ch<='Z'){
//				cntU++;
//			}
//			else {
//				cntOther++;
//			}
//		}


		System.out.printf("大写字母个数: %d\n", cntU);
		System.out.printf("小写字母个数: %d\n", cntL);
		System.out.printf("非字母个数: %d\n", cntOther);	 		
	}
}