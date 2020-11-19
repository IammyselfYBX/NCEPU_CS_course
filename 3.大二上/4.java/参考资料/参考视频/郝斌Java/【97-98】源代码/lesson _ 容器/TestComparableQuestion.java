/*
	Ϊ��Ҫʹ��Comparable�ӿ�ʾ��
*/

import java.util.*;
import java.util.Collections;

//�����implements Comparable ע�͵��ˣ� ��������ʱû�д��󣬵������ǻᱨ��!
class Person  implements Comparable
{
	private int id;
	private String name;
	
	public Person(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	public String toString(){
		return "id: " + id + ",  name: " + name ;
	}
	
	//@Override
	public int compareTo(Object o){
		Person p = (Person)o;
		return this.id - p.id;
	}
}
public class TestComparableQuestion{
	public static void main(String[] args){
		ArrayList c = new ArrayList();  
		c.add(new Person(1000, "zhangsan"));
		c.add(new Person(1002, "wangwu"));	
		java.util.Collections.sort(c); 
	}
}
