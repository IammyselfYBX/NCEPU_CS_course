/*
	== �� equals()����
*/

class TestString_1 
{
	public static void main(String[] args) 
	{
		String str1 = "hello";
		String str2 = "hello";  //str1 �� str2 ��ָ������������"hello"

		if (str1 == str2) //�ж�str1 �� str2����������Ƿ����
		{
			System.out.println("str1 == str2");
		}
		else
		{
			System.out.println("str1 != str2");
		}

		String str3 = new String("hello");  //str3 �� str4 ������ָ����ǲ�ͬ�Ķ���
		String str4 = new String("hello");
		if (str3 == str4)
		{
			System.out.println("str3 == str4");
		}
		else
		{
			System.out.println("str3 != str4");
		}

		if (str3.equals(str4)) //�ж�str3 �� str4�����õĶ����Ƿ����  ��������true
		{
			System.out.println("str3.equals(str4) == true");
		}
		
		System.out.println("Hello World!");
	}
}
/*
	��JDK 1.6�е����н���ǣ� 
-------------------------------
str1 == str2
str3 != str4
str3.equals(str4) == true
Hello World!
-------------------------------
	�ܽ᣺
	str1 ==  str2 
		�������Ƚ�str1����������ռ�ڴ��ֵ��str2����������ռ�ڴ��ֵ
	�Ƿ����
	

	str1.equals(str2)
		�������Ƚ�str1����������ռ�ڴ��ֵ��ָ��Ķ����str2��������
	��ռ�ڴ�	��ֵ��ָ��Ķ���������Ƿ����
	Ҳ����˵���str1��str2ռ�ò�ͬ���ڴ棬������������ͬ�ڴ��ֵ��һ���ģ�
	Stirng.equals()����Ҳ�᷵��true.����Object�е�equals()����ȴ�Ƿ���
	false,����ɲμ���������Object���е�Equals������TestObjectEquals.java��


	Object�оͺ���equals()����������String����д��Object�е�equals()����
	API��
------------------------------------------------------
equals
public boolean equals(Object anObject)�����ַ�����ָ���Ķ���Ƚϡ����ҽ����ò�����Ϊ null����������˶����ʾ��ͬ�ַ����е� String ����ʱ�������Ϊ true�� 

���ǣ�
�� Object �е� equals
������
anObject - ��� String ���бȽϵĶ��� 
���أ�
������������ʾ�� String ��� String ��ȣ��򷵻� true�����򷵻� false��
����μ���
compareTo(String), equalsIgnoreCase(String)
------------------------------------------------------

*/
