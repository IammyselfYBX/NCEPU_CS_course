/*
	2009��6��15��10:08:40
	ͳ��һ��String�����д�д��ĸ Сд��ĸ ����ĸ ���Գ��ֵĸ���
*/

class TestString_3
{
	public static void main(String[] args)
	{
		String str = "abAM1,!23";
		int cntU = 0; //��д��ĸ�ĸ���
		int cntL = 0; //Сд��ĸ�ĸ���
		int cntOther = 0;
		int i;
		
		
		//�ڶ��ַ���
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

		
//		//������
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
		
		
		//����һ
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


		System.out.printf("��д��ĸ����: %d\n", cntU);
		System.out.printf("Сд��ĸ����: %d\n", cntL);
		System.out.printf("����ĸ����: %d\n", cntOther);	 		
	}
}