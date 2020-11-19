import java.awt.*;
import java.awt.event.*;

public class TestWindow
{
	public static void main(String[] args)
	{
		final Frame f = new Frame();
		f.setSize(300, 300);
		
		f.addWindowListener(  //11��
				new WindowAdapter()
				{
					@Override
					public void windowClosing(WindowEvent e)
					{
						f.setVisible(false);
						System.exit(-1);
					}
				}
		);  //19��
		
		//f.addWindowListener(new MyMonitor());  //���д���ӹ����Ͻ��ȼ���11�е�19�еĴ���
		
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