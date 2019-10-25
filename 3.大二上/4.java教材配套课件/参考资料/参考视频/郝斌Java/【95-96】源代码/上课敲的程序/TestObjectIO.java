import java.io.*;

public class TestObjectIO
{
	public static void main(String[] args)
	{
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		Student ss = new Student("zhansan", 1000, 88.8f);  //注意88.8f不能改为88.8 
		Student ss2 = null;	
				
		try
		{
			FileOutputStream fos = new FileOutputStream("d:/share/java/ObjectOut.txt");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(ss);
			
			ois = new ObjectInputStream(new FileInputStream("d:/share/java/ObjectOut.txt"));	
			ss2 = (Student)ois.readObject();  //(Student)不能省   ois.readObject();如果ois中的某个成员是transient,则该成员是不会被读取的，因为该成员不会被保存，何来读取之说？！
			
			System.out.println("ss2.sname = " + ss2.sname);
			System.out.println("ss2.sid = " + ss2.sid);
			System.out.println("ss2.sscore = " + ss2.sscore);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("文件没有找到!");
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

class Student implements Serializable  //如果将implements Serializable 注释掉，则程序编译时就会报错
{
	public String sname = null;
	transient public int sid = 0;
	public float sscore = 0; //表示sscore成员不能被序列化，所谓不能被序列化就是指：“该成员调用ObjectOutputStream 的writeOnbject()时不会被保存，调用ObjectInputStream的readObject()方法时不会被读取”
	
	public Student(String name, int id, float score)
	{
		this.sname = name;
		this.sid = id;
		this.sscore =  score;
	}
}