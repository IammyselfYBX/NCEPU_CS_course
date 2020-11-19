/*
	2009��6��25��16:33:20
	�ı���������ӷ�������
		ͨ����B���ж���A������ԣ��Ϳ��Դﵽ��B�����A���Ա��Ŀ��
		����ͨ�����ַ�ʽ�޷�����A��˽�г�Ա
		
		����ʽ�ȷ������о����ԣ����Ƽ�
*/

import java.awt.*;
import java.awt.event.*;

public class TestTF_2
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
		
		bn.addActionListener(new MyMonitor(this));
		
		f.pack();
		f.setVisible(true);
	}
}

class MyMonitor implements ActionListener
{
	public TF tf = null;

	public MyMonitor()
	{
	}
	
	public MyMonitor(TF tf)
	{
		this.tf = tf;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		int num1 = Integer.parseInt(tf.tf1.getText());
		int num2 = Integer.parseInt(tf.tf2.getText());
		int num3 = num1 + num2;
		tf.tf3.setText(num3 + "");
	}
}