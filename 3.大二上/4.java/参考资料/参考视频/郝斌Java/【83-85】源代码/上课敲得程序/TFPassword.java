import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class TFPassword
{
	public static void main(String[] args)
	{
		Frame f = new Frame();
		TextField tf = new TextField(30);
		tf.addActionListener(new MyMonitor());
		f.add(tf);
		tf.setEchoChar('*');  ////setEchoChar()������TextFile���е�һ�������� void setEchoChar(char c) �����û��Ӽ��������ı���������ĸʱ�����ı�����ʾ�Ĳ����û�������Ǹ��ַ�����ʵ��c������ַ� 
		f.pack();
		f.setVisible(true);
	}	
}

class MyMonitor implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		TextField tf = (TextField)e.getSource();
		String strRec = tf.getText();
		if (strRec.equals("haobin"))
		{
			System.out.println("��֤ͨ��!");
		}
		else
		{
			System.out.println("�����������������!");
		}
		
		tf.setText("");
	}
}