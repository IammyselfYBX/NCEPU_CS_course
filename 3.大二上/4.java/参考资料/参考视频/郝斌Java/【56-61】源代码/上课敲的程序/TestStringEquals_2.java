class A
{
	public int i;
	
	public A(int i)
	{
		this.i = i;
	}
	
//	public boolean equals(Object obj)
//	{
//		A aa = (A)obj;
//		
//		if(this.i == aa.i) //if (��ǰ�����i��obj�����i���)
//			return true;
//		else
//			return false;
//	}
}

public class TestStringEquals_2
{
	public static void main(String[] args)
	{
		A aa1 = new A(2);
		A aa2 = new A(2);
		
		System.out.println( aa1.equals(aa2) ); //true
	}
}