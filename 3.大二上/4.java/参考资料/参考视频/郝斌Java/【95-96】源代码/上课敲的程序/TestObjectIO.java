import java.io.*;

public class TestObjectIO
{
	public static void main(String[] args)
	{
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		Student ss = new Student("zhansan", 1000, 88.8f);  //ע��88.8f���ܸ�Ϊ88.8 
		Student ss2 = null;	
				
		try
		{
			FileOutputStream fos = new FileOutputStream("d:/share/java/ObjectOut.txt");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(ss);
			
			ois = new ObjectInputStream(new FileInputStream("d:/share/java/ObjectOut.txt"));	
			ss2 = (Student)ois.readObject();  //(Student)����ʡ   ois.readObject();���ois�е�ĳ����Ա��transient,��ó�Ա�ǲ��ᱻ��ȡ�ģ���Ϊ�ó�Ա���ᱻ���棬������ȡ֮˵����
			
			System.out.println("ss2.sname = " + ss2.sname);
			System.out.println("ss2.sid = " + ss2.sid);
			System.out.println("ss2.sscore = " + ss2.sscore);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("�ļ�û���ҵ�!");
			System.exit(-1);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.exit(-1);
		}
		finally
		{
			try
			{
				oos.close();
				ois.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
				System.exit(-1);
			}
		}		
	}
}

class Student implements Serializable  //�����implements Serializable ע�͵�����������ʱ�ͻᱨ��
{
	public String sname = null;
	transient public int sid = 0;
	public float sscore = 0; //��ʾsscore��Ա���ܱ����л�����ν���ܱ����л�����ָ�����ó�Ա����ObjectOutputStream ��writeOnbject()ʱ���ᱻ���棬����ObjectInputStream��readObject()����ʱ���ᱻ��ȡ��
	
	public Student(String name, int id, float score)
	{
		this.sname = name;
		this.sid = id;
		this.sscore =  score;
	}
}