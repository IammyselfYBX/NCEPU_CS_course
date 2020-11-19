/*
	2009年6月25日16:14:23
	文本框内容相加方法一：
		主函数代码过多
		程序逻辑混乱
		不推荐
*/

import java.awt.*;
import java.awt.event.*;

public class TestTF_1
{
	public static TextField tf1, tf2, tf3;
	
	public static void main(String[] args)
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
}

class MyMonitor implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		int num1 = Integer.parseInt(TestTF_1.tf1.getText());
		int num2 = Integer.parseInt(TestTF_1.tf2.getText());
		int num3 = num1 + num2;
		TestTF_1.tf3.setText(num3+"");
	}
}