/*
	2009年2月26日18:16:36
	通过在一个类中定义一个其他类的引用来访问其他类的成员
*/

import java.awt.*;
import java.awt.event.*;

public class TestTextField_2
{
	public static void main(String[] args)
	{
		new MyFrame().launch();
	}
}

class MyFrame extends Frame
{
	public TextField tf1, tf2, tf3;  //不能把public 改为private 否则会导致47行出错
	
	public void launch()
	{
		tf1 = new TextField(10);
		tf2 = new TextField(10);
		tf3 = new TextField(10);
		Label lb = new Label("+");
		Button bn = new Button("=");
		bn.addActionListener(new MyMonitor(this));  // this 不能省略也不能改为其他值
		this.setLayout(new FlowLayout());
		this.add(tf1);
		this.add(lb);
		this.add(tf2);
		this.add(bn);
		this.add(tf3);
		this.pack();
		this.setVisible(true); 
	}
}

class MyMonitor implements ActionListener
{
	private MyFrame mf = null;
	
	public MyMonitor(MyFrame mf)
	{
		this.mf = mf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		int num1 = Integer.parseInt(mf.tf1.getText());  //47行
		int num2 = Integer.parseInt(mf.tf2.getText());  //48行
		int num3 = num1 + num2;
		mf.tf3.setText("" + num3);
	}
}