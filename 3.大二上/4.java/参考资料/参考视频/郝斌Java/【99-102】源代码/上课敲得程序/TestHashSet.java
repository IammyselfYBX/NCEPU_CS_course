/*
	2008��11��17��14:57:12
	Student�����ͬʱʵ��equals���� �� hashCode���� �ſ��Ա�֤��װ��HashSet��ʱ������֡��ظ���װ������
	����ʵ����equals���� �� hashCode ���� ����ȷ�ĳ���
*/

import java.util.*;

public class TestHashSet
{
	public static void main(String[] args)
	{
		Collection c = new HashSet();
		c.add(new Student(1001, "����"));
		c.add(new Student(1002, "����"));
		c.add(new Student(1003, "����")); //10��
		c.add(new Student(1003, "����"));
		c.add(new Student(1003, "����"));
		c.add(new Student(1003, "����"));
		c.add(new Student(1003, "����")); //14��

		Iterator i = c.iterator();
		while (i.hasNext())
		{
			System.out.println(i.next());
		}
	}
}

class Student
{
	private int num;
	private String name;

	public Student()
	{
	}

	public Student(int num, String name)
	{
		this.num = num;
		this.name = name;
	}

	public String toString()
	{
		return "ѧ��: " + this.num + ",  ����: " + name;
	}
	
	public boolean equals(Object o)
	{
		Student s = (Student)o;
		
		return this.num==s.num && this.name.equals(s.name);
	}

	public int hashCode()
	{
		//return num; //������趨��ѧ����Ϣ��ѧ����Ψһ�ģ������ֱ����num����Ϊ��ϣ��
		return num * this.name.hashCode();
	}
}
/*
	��JDK 1.6�е����н���ǣ�
-----------------------------
ѧ��: 1002,  ����: ����
ѧ��: 1003,  ����: ����
ѧ��: 1001,  ����: ����
-----------------------------
	�ܽ�:
		����ͬʱʵ��equals()���� �� hashCode() ����,ֻҪ������һ������û��ʵ��
	װ��ʱ�ͻ�����ظ�Ԫ��
*/
