import java.io.*;

public class TestPrintWriter
	public static void main (String[] args) {
		
		try 
		{
			InputStreamReader  is = new InputStreamReader(System.in);
			BufferedReader in=new BufferedReader(is);
			PrintWriter out  = new PrintWriter(new FileWriter("d:/haobin.java"));  //new PrintWriter(new FileWriter("d:/haobin.java", true)); ��true������ʾ����׷�ӵ��ļ���ĩβ��û��true��������ʾֱ�Ӹ��ǵ�ԭ�ļ�������
			String s = in.readLine();
			
			// �Ӽ������ж�������������ļ�
			while (!s.equals("")) 
			{
				out.println(s);  //��s������ַ���д��out�����������ļ���,��׷�ӻ��з��������out.println(s);��Ϊout.print(s); �򲻻�׷�ӻ��з�
				s = in.readLine();
			}
			in.close();   // �ر�BufferedReader������.		     
			out.flush();  //20��
			//out.close();  // �ر������ļ���PrintWriter�����.  �ڰ�20��ע�͵�������£����Ҳ�ѱ���ע�͵��������з���"d:/haobin.java"�ļ���������ȻΪ��,������û��д���ļ���
		}
		catch (IOException e) 
		{
			e.printStackTrace();  
		}
	 }
}
