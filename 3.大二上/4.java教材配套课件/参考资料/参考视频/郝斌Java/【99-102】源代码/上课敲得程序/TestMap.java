import java.util.*;

class A
{
}

public class TestMap
{
	public static void main(String[] args)
	{
		Map m = new HashMap();
		m.put("one", "zhangsan");
		m.put(66.6, 70);
		m.put(new A(), "12");
		System.out.println( m.get("12") );
		m.put(66.6, 99);
		//m.set(66.6, 99);
		System.out.println(m);			
	}
}