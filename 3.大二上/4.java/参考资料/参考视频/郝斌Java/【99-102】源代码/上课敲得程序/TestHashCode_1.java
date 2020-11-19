/*
	2009��2��20��18:28:31
	String �� Integer ��ЩJava�Դ����඼��д��hashCode���������String �� Integer new������
	�����������һ���ģ�����Щ�����hashCode����ֵҲ��һ���ģ���Ȼ��Щ����ռ�õ��ǲ�ͬ���ڴ�
	
	�����û��Զ���������ͬ���籾�����A�࣬��������������һģһ����A��������Ƿ��ص�
	hashCodeֵҲ�ǲ�һ���ģ�������������һģһ����Integer��������String����󷵻ص�
	hashCodeֵȴ��һ���ģ���Ϊϵͳ�Դ���String �� Integer �඼�Ѿ���д��Object��hashCode�����

	
	�������Աϣ���Լ�����������ռ�ò�ͬ�ڴ�ռ䵫����ȴ��һ���Ķ������hashCode����
	����ֵ��һ���ģ������Ա�ͱ����Լ���дhashCode����,�籾�����B��
*/

class A
{
	private int id;
	
	public A(int id)
	{
		this.id = id;
	}
}


class B
{
	private int id;
	
	public B(int id)
	{
		this.id = id;
	}
	
	@Override
	public int hashCode()
	{
		return new Integer(id).hashCode();
	}
}

public class TestHashCode_1{
	public static void main(String[] args) {
		System.out.println("new A(1).hashCode() = " + new A(1).hashCode());
		System.out.println("new A(1).hashCode() = " + new A(1).hashCode());
		System.out.println();		
		System.out.println("new Integer(1).hashCode() = " + new Integer(1).hashCode());
		System.out.println("new Integer(1).hashCode() = " + new Integer(1).hashCode());
		System.out.println();		
		System.out.println("new String(\"haha\").hashCode() = " + new String("haha").hashCode());
		System.out.println("new String(\"haha\").hashCode() = " + new String("haha").hashCode());
		System.out.println();		
		System.out.println("\"haha\".hashCode() = " + "haha".hashCode());
		System.out.println("\"haha\".hashCode() = " + "haha".hashCode());
		System.out.println();		
		System.out.println("new B(1).hashCode() = " + new B(1).hashCode());
		System.out.println("new B(1).hashCode() = " + new B(1).hashCode());
		
		Integer it1 = new Integer(1);		
		Integer it2 = new Integer(1);
		System.out.println(it1 == it2);
		System.out.println(it1.equals(it2));
		System.out.println(it1.hashCode() == it2.hashCode());
	}
}
/*
	��JDK 1.6�е����н���ǣ�
--------------------------
new A(1).hashCode() = 14576877
new A(1).hashCode() = 12677476

new Integer(1).hashCode() = 1
new Integer(1).hashCode() = 1

new String("haha").hashCode() = 3194802
new String("haha").hashCode() = 3194802

"haha".hashCode() = 3194802
"haha".hashCode() = 3194802

new B(1).hashCode() = 1
new B(1).hashCode() = 1
false
true
true
--------------------------
*/