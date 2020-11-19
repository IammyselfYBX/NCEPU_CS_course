/*
	2009年6月25日16:37:28
	文本框内容相加方法三:
		把B当做A的内部类，则我们就可以在B类中轻松访问A类的所有成员，当然包括私有成员
		推荐
*/

import java.awt.*;
import java.awt.event.*;

public class TestTF_3
{
	public static void main(String[] args)
	{
		new TF().launch();
	}
}

class TF
{
	public TextField tf1, tf2, tf3;
	
	public void launch()
	{
		Frame f = new Frame();
		tf1 = new TextField(30);
		tf2 = new TextField(30);
		tf3 = new TextField(30);
		Button bn = new Button("=");
		Label lb = new Label("+");
	
		f.setLayout(new FlowLayout());
		f.add(tf1);
		f.add(lb);
		f.add(tf2);
		f.add(bn);
		f.add(tf3);
		
		bn.addActionListener(new MyMonitor());
		
		f.pack();
		f.setVisible(true);
	}
	
	class MyMonitor implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int num1 = Integer.parseInt(tf1.getText());
			int num2 = Integer.parseInt(tf2.getText());
			int num3 = num1 + num2;
			tf3.setText(num3 + "");
		}
	}
}

