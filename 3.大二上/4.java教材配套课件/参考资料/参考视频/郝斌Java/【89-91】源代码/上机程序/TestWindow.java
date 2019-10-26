import java.awt.*;
import java.awt.event.*;

public class TestWindow
{
	public static void main(String[] args)
	{
		final Frame f = new Frame();
		f.setSize(300, 300);
		
		f.addWindowListener(  //11行
				new WindowAdapter()
				{
					@Override
					public void windowClosing(WindowEvent e)
					{
						f.setVisible(false);
						System.exit(-1);
					}
				}
		);  //19行
		
		//f.addWindowListener(new MyMonitor());  //本行代码从功能上讲等价于11行到19行的代码
		
		f.setVisible(true);
	}
}

class MyMonitor extends WindowAdapter
{
	@Override
	public void windowClosing(WindowEvent e)
	{
		System.exit(-1);
	}
}