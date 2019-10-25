/*
	2009年6月29日10:12:40
	文本框内容相加 方法一：
		主函数代码过多
		程序逻辑混乱
		不推荐
*/
*/

import java.awt.*;
import java.awt.event.*;

public class TestTextField_1
{
	public static TextField tf1, tf2, tf3;
	
	public static void main(String[] args)
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
		
		bn.addActionListener(new MyMonitor());
		
		f.pack();
		f.setVisible(true);		 
	}
}

class MyMonitor implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String str1 = TestTextField_1.tf1.getText();
		String str2 = TestTextField_1.tf2.getText();
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		int num3 = num1 + num2;
		
		Integer it = new Integer(num3);
		String str3 = it.toString();
		
		TestTextField_1.tf3.setText(str3);
	} 
}