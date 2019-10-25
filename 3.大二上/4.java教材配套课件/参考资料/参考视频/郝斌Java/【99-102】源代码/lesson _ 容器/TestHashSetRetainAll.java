/*
	2008年11月13日15:34:47
	功能:检测HashSet类中的retainAll()方法使用
	总结： 
		s1.retainAll(s2);
		求出s1和s2的交集，并把交集存入s1中，
		如果交集为空，则s1的内容就为空
		如果s1的值发生改变，则返回真
		如果s1不需要改变，则返回假
		注意：该方法可能会改变s1的值，但一定不会改变s2的值		
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
		
		System.out.println("s1.retainAll(s2) = " + s1.retainAll(s2)); //s1.retainAll(s2);判断s1和s2是否存在交集，如果存在交集则把s1的内容改成该交集的内容，如果不存在交集
		System.out.println("s1 = " + s1);	
		System.out.println("s2 = " + s2);
	
		Set s3 = new HashSet();
		s3.add("f");
		Set s4 = new HashSet();
		s4.add("n");
		System.out.println("s3.retainAll(s4) = " + s3.retainAll(s4));  //因为
		System.out.println("s3 = " + s3);
		System.out.println("s4 = " + s4);
	}
}
/*
	在JDK 1.6中的运行结果是：
-------------------------
s1.retainAll(s2) = true
s1 = [b, a]
s2 = [d, b, a]
s3.retainAll(s4) = true
s3 = []
s4 = [n]
-------------------------
*/