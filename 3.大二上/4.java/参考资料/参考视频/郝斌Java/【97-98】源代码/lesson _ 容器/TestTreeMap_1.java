/*
	2008��11��20��23:19:20
	�й�TestMap���ʵ��
*/

import java.util.*;

public class TestTreeMap_1
{
	public static void main(String[] args)
	{
		Map m1 = new HashMap();
		Map m2 = new HashMap();
		m1.put("one", 1);
		m1.put("two", 2);
		m1.put("three", 3);
		System.out.println("1-> " + m1);
		System.out.println("2-> " + m1.size());
		m1.put(66.6, 'm');  //Map�м���ֵ������������ģ���Ҳ��Mapǿ�����Ҫ����
		m1.put(123L, 34);
		System.out.println("3-> " + m1.size());
		System.out.println("4-> " + m1);

		System.out.println(m1.containsKey("three")); //ontainsKey ��Ҫд����containKey
		System.out.println(m2.containsValue(34));
		System.out.println(m2.containsValue(123L));
	}
}

/*
	��JDK 1.6�е����н���ǣ�
---------------------
1-> {two=2, one=1, three=3}
2-> 3
3-> 5
4-> {two=2, one=1, three=3, 123=34, 66.6=m}
true
false
false
---------------------
*/