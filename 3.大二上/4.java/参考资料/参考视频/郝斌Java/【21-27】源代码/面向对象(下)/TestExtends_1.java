class Human
{
	//��Ц
	public void laugh()
	{
		System.out.println("Ц!");
	}
	
	//�˿�
	public void cry()
	{
		System.out.println("��!");
	}
}

class Student extends Human
{
	//����ҵ
	public void doHomework()
	{
		System.out.println("����ҵ!");
	}
}

public class TestExtends_2
{
	public static void main(String[] args)
	{
		Student s = new Student();
		s.laugh();
		s.cry();
		s.doHomework();
	}
}
/*
	��JDK 1.6�е����н���ǣ�
------------------
Ц!
��!
����ҵ!
------------------
*/
