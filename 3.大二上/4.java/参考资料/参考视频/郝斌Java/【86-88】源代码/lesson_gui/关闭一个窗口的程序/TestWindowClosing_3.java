/*
	2009��2��26��20:01:52
	����һ��Windows���ڣ�����رհ�ťʱ���Թر���
	
	���÷����ڲ�����������ʵ��  ������
*/

import java.awt.*;
import java.awt.event.*;

public class TestWindowClosing_3
{
	public static void main(String[] args)
	{
		Frame f = new Frame();  //13��
		f.setBounds(100, 100, 200, 200);
		f.setBackground(Color.GREEN);
		f.addWindowListener(new WindowAdapter()
				{
					public void windowClosing(WindowEvent e)
					{
						Frame f = (Frame)e.getSource();  //22��
								//��һ��  22�еĴ��벻�ܸ�Ϊ e.setVisible(false); ����ʱ�ᱨ��   ��ΪWindowEvent �Ǹ��¼��࣬�¼����п϶��ǲ�����setVisible()������
								
						f.setVisible(false);
						System.exit(-1);
					}	
				}
		);  //16��
		f.setVisible(true);
	}

}

