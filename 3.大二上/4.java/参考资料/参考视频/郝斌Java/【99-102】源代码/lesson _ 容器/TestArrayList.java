/*
	2008��11��9��16:08:24
	�����������: ArrayList���е�
		add()  
		size()  
			��
		System.out.println(Collection����)���÷�
*/

import java.util.*;

class Name
{
	private String firstName, lastName;

	public Name()
	{
	}

	public Name(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String toString()  //26��
	{
		return lastName + "  " + firstName;
	}   //29��
}

public class TestArrayList
{
	public static void main(String[] args)
	{
		Collection c = new ArrayList();
		
		//look  ����װ�벻ͬ���͵Ķ���, ����װ�Ķ������Ƕ��󣬲������ǻ������͵����ݣ���Ϊ�������������Ǵ����ջ�еģ�һ���˳��û����������ݵ������򣬸û�������������ռ���ڴ����ʧ��,������ˣ�����������Ȼ����װ��������͵����ݣ���Ϊ���������Զ��ѻ�����������ת���ɶ�����50�еĴ���
		c.add("hello"); //��"hello"����ַ���������ӵ�c�У���׼ȷ�Ľ�����"hello"����ַ������������(���ü���ַ)��ӵ�c������
		c.add("�ٺ�"); //ͬ��
		c.add(new Name("bin", "hao"));
		c.add(new Integer(100));
		
		c.add(200); //c.add(200);�ȼ��� c.add(Integer.valueOf(200)); �����������Զ��ѻ�������200ת��ΪInteger����200

		System.out.println(c.size()); //c.size() ����c��װ�Ķ���ĸ���
		System.out.println(c); //�����ȼ���System.out.println(c.toString()); 
			//c.toString(); ������������: ����һ��������String����:  [���õ�һ��Ԫ�ص�toString����, ���õڶ���Ԫ�ص�toString����, ���õ�����Ԫ�ص�toString��������������������]
			//�����24�е�27��ע�͵��ˣ����������ͻ�������룬����μ�����ĩβ����������

		System.out.println("ͬ־�ǳ尡!");
	}
}
/*
	��JDK 1.6�е����н���ǣ�
-------------------------------
5
[hello, �ٺ�, hao  bin, 100, 200]
ͬ־�ǳ尡!
-------------------------------
	
	�����24�е�27��ȫ��ע�͵�������JDK 1.6�е����н���ǣ�
-----------------------------
5
[hello, �ٺ�, Name@de6ced, 100, 200]
ͬ־�ǳ尡!
-----------------------------
	
*/