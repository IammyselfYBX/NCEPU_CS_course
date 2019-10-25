/*
	2009年6月29日10:34:02
	文本框内容相加 方法二：
		通过在B类中定义A类的属性，就可以达到在B类访问A类成员目的
		但是通过这种方式无法访问A类私有成员
		
		本方式既繁琐又有局限性，不推荐
*/

import java.awt.*;
import java.awt.event.*;

public class TestTextField_2
{
	public static TextField tf1, tf2, tf3;
	
	public static void main(String[] args)
	{
		TF tf = new TF();
		tf.launch();			 
	}
}

class TF
{
	public TextField tf1, tf2, tf3;
	
	public void launch()
	{
		tf1 = new TextField(30);
		tf2 = new TextField(30);
		tf3 = new TextField(30);
		Button bn = new Button("=");
		Label Lb = new Label("+");
		Frame f = new Frame("文本框相加示例");
		f.setLayout(new FlowLayout());
		f.add(tf1);
		f.add(Lb);
		f.add(tf2);
		f.add(bn);
		f.add(tf3);
		
		bn.addActionListener(new MyMonitor(this));
		
		f.pack();
		f.setVisible(true);
	}
}

class MyMonitor implements ActionListener
{
	private TF tf;
	
	public MyMonitor(TF tf)
	{
		this.tf = tf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String str1 = tf.tf1.getText();
		String str2 = tf.tf2.getText();
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		int num3 = num1 + num2;
		
		tf.tf3.setText(num3+"");
	}
}