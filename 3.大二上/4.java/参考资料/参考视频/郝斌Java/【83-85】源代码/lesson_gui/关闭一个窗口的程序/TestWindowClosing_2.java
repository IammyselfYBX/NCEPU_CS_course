import java.awt.*;
import java.awt.event.*;

public class TestWindowClosing_2
{
	public static void main(String[] args)
	{
		Frame f = new Frame();  //13行
		f.setBounds(100, 100, 200, 200);
		f.setBackground(Color.GREEN);
		f.addWindowListener(new MyWindowMonitor());  
		f.setVisible(true);
	}

	static class MyWindowMonitor implements WindowListener   //去掉了static 编译时就会报错, 因为“要想在一个类的静态方法中访问该类的内部类，则该内部类必须的被标记为static”, 另外  implements WindowListener 改为 extends WindowAdapter更能减少代码的编写   
	{
		@Override
		public void windowClosing(WindowEvent e)
		{
			Frame f = (Frame)e.getSource();  
			f.setVisible(false);
			System.exit(-1);			
		}
		
		public void windowOpened(WindowEvent e){};  //{}; public 都不能省
		public void windowClosed(WindowEvent e){};
		public void windowIconified(WindowEvent e){};
		public void windowDeiconified(WindowEvent e){};
		public void windowActivated(WindowEvent e){};
		public void windowDeactivated(WindowEvent e){};
	}
}

