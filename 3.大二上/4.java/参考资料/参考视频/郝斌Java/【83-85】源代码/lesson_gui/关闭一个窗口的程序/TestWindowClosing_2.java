import java.awt.*;
import java.awt.event.*;

public class TestWindowClosing_2
{
	public static void main(String[] args)
	{
		Frame f = new Frame();  //13��
		f.setBounds(100, 100, 200, 200);
		f.setBackground(Color.GREEN);
		f.addWindowListener(new MyWindowMonitor());  
		f.setVisible(true);
	}

	static class MyWindowMonitor implements WindowListener   //ȥ����static ����ʱ�ͻᱨ��, ��Ϊ��Ҫ����һ����ľ�̬�����з��ʸ�����ڲ��࣬����ڲ������ı����Ϊstatic��, ����  implements WindowListener ��Ϊ extends WindowAdapter���ܼ��ٴ���ı�д   
	{
		@Override
		public void windowClosing(WindowEvent e)
		{
			Frame f = (Frame)e.getSource();  
			f.setVisible(false);
			System.exit(-1);			
		}
		
		public void windowOpened(WindowEvent e){};  //{}; public ������ʡ
		public void windowClosed(WindowEvent e){};
		public void windowIconified(WindowEvent e){};
		public void windowDeiconified(WindowEvent e){};
		public void windowActivated(WindowEvent e){};
		public void windowDeactivated(WindowEvent e){};
	}
}

