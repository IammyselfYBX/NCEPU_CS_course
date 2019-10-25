import java.util.Set;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.*;

public class TestHash
{
	public static void main(String[] args) {
		Map hm = new Hashtable();  //针对HashMap而言：只要没有重写键类MyKey中的hashCode 和 equasl方法中的任何一个方法，都会导致HashMap中出现重复映射，即会出现多个"1001   Nancy 49"
								  //针对Hashtable而言：只要没有重写键类MyKey中的hashCode 和 equasl方法中的任何一个方法，都会导致HashMap中出现重复映射，即会出现多个"1001   Nancy 49"
								 //但是针对TreeMap而言，至少在本程序中, 是否重写键类MyKey中的hashCode 和 equasl方法,是重写一个还是重写两个还是两个都不重写，整个程序的输出结果没有任何影响，我个人估计是因为TreeMap容器已经要求所有的键类都要实现Comparable接口,这时候可能hashCode方法和equasl方法都用不到了，当然这只是我个人猜测而已!
								 
		hm.put(new MyKey(1003),new Person("Tom",15));
		hm.put(new MyKey(1008),new Person("Billy",25));
		hm.put(new MyKey(1005),new Person("Kity",73));   
		hm.put(new MyKey(1001),new Person("Nancy",49));
		hm.put(new MyKey(1001),new Person("Nancy",49));
		hm.put(new MyKey(1001),new Person("Nancy",49));
		hm.put(new MyKey(1001),new Person("Nancy",49));

		System.out.println("----检索单个元素----");
		Person p = (Person)hm.get(new MyKey(1008));
		System.out.println(p);
		
		System.out.println("----遍历所有元素----");
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
	在JDK 1.6中的运行结果是：
------------------------------
----检索单个元素----
Name: Billy     Age: 25
----遍历所有元素----
1008    Name: Billy     Age: 25
1005    Name: Kity      Age: 73
1003    Name: Tom       Age: 15
1001    Name: Nancy     Age: 49
hm.size() = 4
------------------------------
*/