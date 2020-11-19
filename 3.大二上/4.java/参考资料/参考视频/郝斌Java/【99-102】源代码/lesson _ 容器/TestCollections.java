/*
	2008��11��20��12:08:28
	����Collections���ʹ��
*/

import java.util.*;

public class TestCollections
{
	public static void main(String[] args)
	{
		List lt = new LinkedList(); 
		for (int i=0; i<7; ++i)
		{
			lt.add("a" + i);
		}
		System.out.println(lt);
		Collections.shuffle(lt);  //��סLinkedList����û��shuffle�����ģ������Ҫͨ��Collections�����ط�����ʵ��
		System.out.println(lt);
		Collections.sort(lt); //Ĭ����������Ҫ����ܼ򵥣��ȵ���Collections.sort(); �ٵ���Collections.reverse()
		System.out.println(lt);
		Collections.reverse(lt); //����
		System.out.println("����֮��: " + lt);
		System.out.println(Collections.binarySearch(lt, "a5")); //��ΪltĬ�ϲ�����������ģ����Ե���Collections.binarySearch()�����ǲ���ɹ���
		Collections.sort(lt);
		System.out.println("��������֮��: " + lt);		
		System.out.println(Collections.binarySearch(lt, "a5"));  //��ס��ʹ��binarySearch()������ǰ���Ǹ���������������
	}
}
/*
	��JDK 1.6�е����н���ǣ�
----------------------------
[a0, a1, a2, a3, a4, a5, a6]
[a5, a3, a6, a4, a2, a0, a1]
[a0, a1, a2, a3, a4, a5, a6]
����֮��: [a6, a5, a4, a3, a2, a1, a0]
-8
��������֮��: [a0, a1, a2, a3, a4, a5, a6]
5
----------------------------
*/
