import java.io.*;
import java.net.*;

public class TServer
{
	public static void main(String[] args)
	{
		ServerSocket ss = null;  //�����ss����ó�ʼ�������³�ʼ��ΪnullҲ���ԣ�����ᵼ��39�б��� ��Ϊ��������Ϊ14�в���һ�����ss��ֵ�ɹ���  �����ܿ�Ц����Java��������Ϊtry{......}�д���ִ�в���һ���ɹ�������Ҫ������try֮ǰ����öԱ�������ֵ�����Ǳ�����ȴ��ⲻ������ֵΪnull�Ĵ����Ա�����Ϊ�������ｫss��Ϊnull�������߼���try{....}�д��벢��һ���ܸ�ss����ȷ��ֵ�������ս��ss�Կ�����null�����������Ͻ���39�д�����Ȼ�����Ǵ�ģ�����JAva������ȴ��ⲻ�����ִ����ҹ�������ΪA aa = null;  aa.��Ա��; ���ַ�ʽ����������ʱ�Ǽ�ⲻ�����ִ���ģ�ֻ���ܳ�NullPointerException�쳣 
		Socket s = null;
		DataInputStream dis = null;  
			
		try
		{
			ss = new ServerSocket(8888); // 14�� 
			while (true)    
			{
				s = ss.accept();
				dis = new DataInputStream(s.getInputStream());  
				String str = dis.readUTF();  
				System.out.println("�Է�˵����: " + str);
			}
		}
		catch (SocketException e)
		{
			System.out.println("�������ӳ���������ֹ");
			System.exit(-1);
		}
		catch (IOException e)
		{
			System.out.println("��д���ݳ���������ֹ");
			System.exit(-1);
		}
		finally
		{
			try
			{
				dis.close();  
				s.close();    
				ss.close();  //39��  
			}
			catch (Exception e)
			{
			}
		}
	}
}