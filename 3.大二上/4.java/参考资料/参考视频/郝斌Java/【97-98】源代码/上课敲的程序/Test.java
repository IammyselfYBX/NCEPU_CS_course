import java.util.*;

class A
{
	public String toString()
	{
		return "����";
	}
}

public class Test
{
	public static void main(String[] args)
	{
		ArrayList al = new ArrayList();
		al.add(12345);
		al.add("����");  //"����".length()  "����".conpareTo("����");
		al.add(66.66); //double  Double
		al.add(new A());
		//System.out.println(al[2]);  //������������
		
		System.out.println(al.get(2)); 
	
		Object[] obArr = al.toArray();
		System.out.println(obArr[2]); 
	
		//System.out.println(al); 
	}
}
