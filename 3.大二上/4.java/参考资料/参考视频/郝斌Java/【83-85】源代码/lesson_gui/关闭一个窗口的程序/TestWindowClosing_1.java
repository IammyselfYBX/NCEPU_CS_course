/*
	2009��2��26��20:01:52
	����һ��Windows���ڣ�����رհ�ťʱ���Թر���
	
	�����ⲿ����������ʵ�� ����һ
*/

import java.awt.*;
import java.awt.event.*;

public class TestWindowClosing_1
{
	public static void main(String[] args)
	{
		Frame f = new Frame();
		f.setBounds(100, 100, 200, 200);
		f.setBackground(Color.GREEN);
		f.addWindowListener(new MyWindowMonitor());
		f.setVisible(true);
	}
}

class MyWindowMonitor extends WindowAdapter
{
	@Override
	public void windowClosing(WindowEvent e)
	{
		Frame f = (Frame)e.getSource();
		f.setVisible(false);  //����ֱ��д e.setVisible(false); ��ΪWindowEvent �Ǹ��¼��࣬�¼����п϶��ǲ�����setVisible()�����ģ� ������Բμ���E:\���\Java\java�ĵ�\GUI\ActionEvent �� WindowEvent ����.java\ActionEvent �� WindowEvent ����.java��
		System.exit(-1);
	}
}