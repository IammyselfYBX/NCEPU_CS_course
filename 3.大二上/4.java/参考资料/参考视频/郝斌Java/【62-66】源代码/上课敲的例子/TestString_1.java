/*
	2009��6��15��8:55:11
	����String���
		equals������ʹ��
		==���÷�
		�����ַ������÷�
*/

public class TestString_1
{
	public static void main(String[] args)
	{
		String str1 = new String("china");
		String str2 = new String("china");
		System.out.println(str1.equals(str2)); //true   str1.equals(str2) �����ж�str1ָ��Ķ�������ݺ�str2ָ��Ķ���������Ƿ����
		
		if (str1 == str2) //���ж�str1��str2����������Ƿ���ȣ�  ���������ж�str1ָ��Ķ�������ݺ�str2ָ��Ķ���������Ƿ���ȣ� �𰸣� ����ǰ��
			System.out.println("str1 == str2");  
		else
			System.out.println("str1 != str2");	
			
		String str3 = "china";
		String str4 = "china";
		if (str3 == str4)
			System.out.println("str3 == str4");
		else
			System.out.println("str3 != str4");		
			
	}
}