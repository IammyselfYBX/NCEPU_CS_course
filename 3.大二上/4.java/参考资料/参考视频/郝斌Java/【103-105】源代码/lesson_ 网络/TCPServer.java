import java.net.*;
import java.io.*;

public class TCPServer
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(6666);//8��  6666�Ƕ˿ںţ���ʾ�÷����������ڼ���666�˿��Ƿ��пͻ��˳��������
					//new����ServerSocket����ss�������Զ������ͻ�����û����6666�˿ڷ�������Ҫ�����6666�˿��Ƿ��пͻ��˵����������ĵ���ss�����accept����
					//���������ֻ��8����һ�еĴ���Ļ�������������ʱ�����κ�����������������ֹ								
		
		while (true)
		{
			Socket s = ss.accept();  //accept()���ܣ��ȴ��ͻ��˵����ӣ�û�����ӣ����������������ͣ�Ͳ�ǰ��������յ��ͻ��˵�һ�����ӣ����Զ��������ӷ�װΪһ��Socket���󣬳��򽫲������������Ǽ�������ִ��  
						//�����sʵ�������ӵ��ͻ��˵�s���������˵�s.getInputStream() �Ϳͻ��˵�s.getOutputStream()ʵ����ͬһ���ܵ�
						//accept()������ʽ������������ղ����ͻ��˵����ӣ������ֹͣ��ǰ
			System.out.println("һ�������Ѿ�����!!!");
			DataInputStream dis = new DataInputStream(s.getInputStream()); //ͨ��Socket������Ի��InputStream��OutputStream�����ܵ�
			System.out.println(dis.readUTF());  //readUTF()����Ҳ������ʽ������������ղ����ͻ������ݣ������ֹͣ��ǰ
			dis.close();  //DataInputStream �� InputStream ���ж�û��flush����  DataOutputStream �� OutputStream ���ж���flush����
			s.close();
		}	
	}
}