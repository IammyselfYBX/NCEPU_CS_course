import java.util.Set;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.*;

public class TestHash
{
	public static void main(String[] args) {
		Map hm = new Hashtable();  //���HashMap���ԣ�ֻҪû����д����MyKey�е�hashCode �� equasl�����е��κ�һ�����������ᵼ��HashMap�г����ظ�ӳ�䣬������ֶ��"1001   Nancy 49"
								  //���Hashtable���ԣ�ֻҪû����д����MyKey�е�hashCode �� equasl�����е��κ�һ�����������ᵼ��HashMap�г����ظ�ӳ�䣬������ֶ��"1001   Nancy 49"
								 //�������TreeMap���ԣ������ڱ�������, �Ƿ���д����MyKey�е�hashCode �� equasl����,����дһ��������д������������������д�����������������û���κ�Ӱ�죬�Ҹ��˹�������ΪTreeMap�����Ѿ�Ҫ�����еļ��඼Ҫʵ��Comparable�ӿ�,��ʱ�����hashCode������equasl�������ò����ˣ���Ȼ��ֻ���Ҹ��˲²����!
								 
		hm.put(new MyKey(1003),new Person("Tom",15));
		hm.put(new MyKey(1008),new Person("Billy",25));
		hm.put(new MyKey(1005),new Person("Kity",73));   
		hm.put(new MyKey(1001),new Person("Nancy",49));
		hm.put(new MyKey(1001),new Person("Nancy",49));
		hm.put(new MyKey(1001),new Person("Nancy",49));
		hm.put(new MyKey(1001),new Person("Nancy",49));

		System.out.println("----��������Ԫ��----");
		Person p = (Person)hm.get(new MyKey(1008));
		System.out.println(p);
		
		System.out.println("----��������Ԫ��----");
		Set names = hm.keySet();
		Iterator it = names.iterator();
		while(it.hasNext()){
			MyKey key = (MyKey)it.next();
			Person value = (Person)hm.get(key); 
			System.out.println(key.getId() + "\t" + value);
		}
		System.out.println("hm.size() = " + hm.size());
	}
}
/*
	��JDK 1.6�е����н���ǣ�
------------------------------
----��������Ԫ��----
Name: Billy     Age: 25
----��������Ԫ��----
1008    Name: Billy     Age: 25
1005    Name: Kity      Age: 73
1003    Name: Tom       Age: 15
1001    Name: Nancy     Age: 49
hm.size() = 4
------------------------------
*/