import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class TFActionEvent
{
	public static void main(String[] args)
	{
		Frame f = new Frame();
		TextField tf = new TextField(30);
		tf.addActionListener(new MyMonitor());
		f.add(tf);
		f.pack();
		f.setVisible(true);
	}	
}

class MyMonitor implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		TextField tf = (TextField)e.getSource();
		System.out.println(tf.getText());
		tf.setText("");
	}
}