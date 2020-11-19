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
		tf.setEchoChar('*');  ////setEchoChar()方法是TextFile类中的一个方法， void setEchoChar(char c) ，当用户从键盘上向文本框输入字母时，在文本框显示的不是用户输入的那个字符而是实参c代表的字符 
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
			System.out.println("验证通过!");
		}
		else
		{
			System.out.println("密码错误，请重新输入!");
		}
		
		tf.setText("");
	}
}