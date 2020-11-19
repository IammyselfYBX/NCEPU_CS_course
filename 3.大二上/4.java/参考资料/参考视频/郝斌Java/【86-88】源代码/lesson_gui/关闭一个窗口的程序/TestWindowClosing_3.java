/*
	2009年2月26日20:01:52
	创建一个Windows窗口，点击关闭按钮时可以关闭它
	
	利用方法内部的匿名类来实现  方法三
*/

import java.awt.*;
import java.awt.event.*;

public class TestWindowClosing_3
{
	public static void main(String[] args)
	{
		Frame f = new Frame();  //13行
		f.setBounds(100, 100, 200, 200);
		f.setBackground(Color.GREEN);
		f.addWindowListener(new WindowAdapter()
				{
					public void windowClosing(WindowEvent e)
					{
						Frame f = (Frame)e.getSource();  //22行
								//第一：  22行的代码不能改为 e.setVisible(false); 编译时会报错   因为WindowEvent 是个事件类，事件类中肯定是不会有setVisible()方法的
								
						f.setVisible(false);
						System.exit(-1);
					}	
				}
		);  //16行
		f.setVisible(true);
	}

}

