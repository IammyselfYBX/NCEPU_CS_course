import java.io.*;
public class TestBuffered{
	public static void main(String[] args) throws Exception{
		String str = "zhangsan";
		System.out.println("str = " + str);
		
		BufferedReader br = 
			new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();  //����ֽ�����س��Ļ���str��ֵ�ͻ��ɿ��ַ���
		
		System.out.println("------------");
		System.out.println(str + "123"); 
		System.out.println(str.equals(""));  //true
		System.out.println(str == null);  //false		
	}
}
