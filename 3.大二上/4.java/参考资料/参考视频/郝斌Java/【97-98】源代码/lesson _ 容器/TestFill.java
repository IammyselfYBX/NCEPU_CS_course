import java.util.*;

public class TestFill
{
	public static void main(String[] args)
	{
		List lt = new LinkedList();  //7��
		lt.add("111");
		lt.add("222");
		lt.add("333");
		System.out.println(lt);
		Collections.fill(lt, "888");  //��7�е�List���ܸ�Ϊ Collection, �������ʱ�ᱨ����ΪCollections����ר�����List��
		System.out.println(lt);
	}
}
/*
	��JDK 1.6�е����н���ǣ�
---------------------------
[111, 222, 333]
[888, 888, 888]
---------------------------
*/