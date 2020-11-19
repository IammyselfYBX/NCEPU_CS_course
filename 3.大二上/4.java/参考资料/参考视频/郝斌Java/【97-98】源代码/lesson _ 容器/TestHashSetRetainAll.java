/*
	2008��11��13��15:34:47
	����:���HashSet���е�retainAll()����ʹ��
	�ܽ᣺ 
		s1.retainAll(s2);
		���s1��s2�Ľ��������ѽ�������s1�У�
		�������Ϊ�գ���s1�����ݾ�Ϊ��
		���s1��ֵ�����ı䣬�򷵻���
		���s1����Ҫ�ı䣬�򷵻ؼ�
		ע�⣺�÷������ܻ�ı�s1��ֵ����һ������ı�s2��ֵ		
*/
import java.util.*;

public class TestHashSet2
{
	public static void main(String[] args)
	{
		Set s1 = new HashSet();
		s1.add("a");
		s1.add("b");
		s1.add("c");

		Set s2 = new HashSet();
		s2.add("d");
		s2.add("a");
		s2.add("b");
		
		System.out.println("s1.retainAll(s2) = " + s1.retainAll(s2)); //s1.retainAll(s2);�ж�s1��s2�Ƿ���ڽ�����������ڽ������s1�����ݸĳɸý��������ݣ���������ڽ���
		System.out.println("s1 = " + s1);	
		System.out.println("s2 = " + s2);
	
		Set s3 = new HashSet();
		s3.add("f");
		Set s4 = new HashSet();
		s4.add("n");
		System.out.println("s3.retainAll(s4) = " + s3.retainAll(s4));  //��Ϊ
		System.out.println("s3 = " + s3);
		System.out.println("s4 = " + s4);
	}
}
/*
	��JDK 1.6�е����н���ǣ�
-------------------------
s1.retainAll(s2) = true
s1 = [b, a]
s2 = [d, b, a]
s3.retainAll(s4) = true
s3 = []
s4 = [n]
-------------------------
*/