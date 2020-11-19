import java.util.*;

public class TestFill
{
	public static void main(String[] args)
	{
		List lt = new LinkedList();  //7行
		lt.add("111");
		lt.add("222");
		lt.add("333");
		System.out.println(lt);
		Collections.fill(lt, "888");  //第7行的List不能改为 Collection, 否则编译时会报错，因为Collections类是专门针对List的
		System.out.println(lt);
	}
}
/*
	在JDK 1.6中的运行结果是：
---------------------------
[111, 222, 333]
[888, 888, 888]
---------------------------
*/