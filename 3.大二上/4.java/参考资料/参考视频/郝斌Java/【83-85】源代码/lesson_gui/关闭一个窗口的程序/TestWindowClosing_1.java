/*
	2009年2月26日20:01:52
	创建一个Windows窗口，点击关闭按钮时可以关闭它
	
	利用外部监听器类来实现 方法一
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
		f.setVisible(false);  //不能直接写 e.setVisible(false); 因为WindowEvent 是个事件类，事件类中肯定是不会有setVisible()方法的， 另外可以参见“E:\编程\Java\java心得\GUI\ActionEvent 和 WindowEvent 区别.java\ActionEvent 和 WindowEvent 区别.java”
		System.exit(-1);
	}
}