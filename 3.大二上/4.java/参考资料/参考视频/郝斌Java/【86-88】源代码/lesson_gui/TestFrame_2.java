/*
	�й�Frame���з�����ʹ��
*/

import java.awt.Frame;

public class TestFrame_2
{
	public static void main(String[] args)
	{
		Frame f = new Frame("����");
		f.setSize(200, 200);
		f.setVisible(true);  //���ھ�����ʾ����0��0����λ����ʾ����
		
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			System.out.println(e.getMessage());
		}
		
		f.setLocation(200, 200);  //��2��󴰿��ƶ���������ʾ����200�� 200����λ����ʾ
	
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			System.out.println(e.getMessage());
		}
		
		f.setVisible(false);  //�ٹ�һ���ӣ�������ʧ
	}
}