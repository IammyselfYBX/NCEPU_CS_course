/*
	2009��2��26��18:16:36
	ͨ����һ�����ж���һ�������������������������ĳ�Ա
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
	public TextField tf1, tf2, tf3;  //���ܰ�public ��Ϊprivate ����ᵼ��47�г���
	
	public void launch()
	{
		tf1 = new TextField(10);
		tf2 = new TextField(10);
		tf3 = new TextField(10);
		Label lb = new Label("+");
		Button bn = new Button("=");
		bn.addActionListener(new MyMonitor(this));  // this ����ʡ��Ҳ���ܸ�Ϊ����ֵ
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
		int num1 = Integer.parseInt(mf.tf1.getText());  //47��
		int num2 = Integer.parseInt(mf.tf2.getText());  //48��
		int num3 = num1 + num2;
		mf.tf3.setText("" + num3);
	}
}