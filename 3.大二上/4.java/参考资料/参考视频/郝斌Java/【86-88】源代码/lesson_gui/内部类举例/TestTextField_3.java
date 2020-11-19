/*
	2009年2月26日18:27:59
	利用内部类来实现
*/

import java.awt.*;
import java.awt.event.*;

public class TestTextField_3
{
	public static void main(String[] args)
	{
		new MyFrame().launch();
	}
}

class MyFrame extends Frame 
{
	TextField tf1, tf2, tf3;
	
	public void launch()
	{
		tf1 = new TextField(10);
		tf2 = new TextField(10);
		tf3 = new TextField(10);
		Label lb = new Label("+");
		Button bn = new Button("=");
		bn.addActionListener(new MyMonitor());
		this.setLayout(new FlowLayout());
		this.add(tf1);
		this.add(lb);
		this.add(tf2);
		this.add(bn);
		this.add(tf3);
		this.pack();
		this.setVisible(true); 
	}
	
	class MyMonitor implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			int num1 = Integer.parseInt(tf1.getText());
			int num2 = Integer.parseInt(tf2.getText());
			int num3 = num1 + num2;
			tf3.setText("" + num3);
		}
	}

}

