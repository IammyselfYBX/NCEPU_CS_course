import java.awt.*;
import java.awt.event.*;

public class TestTextField_1
{
	public static void main(String[] args)
	{
		new MyFrame().launch();
	}
}

class MyFrame extends Frame
{
	public void launch()
	{
		TextField tf1 = new TextField(10);
		TextField tf2 = new TextField(10);
		TextField tf3 = new TextField(10);
		Label lb = new Label("+");
		Button bn = new Button("=");
		bn.addActionListener(new MyMonitor(tf1, tf2, tf3));
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
	private TextField tf1, tf2, tf3;
	
	public MyMonitor(TextField tf1, TextField tf2, TextField tf3)
	{
		this.tf1 = tf1;
		this.tf2 = tf2;
		this.tf3 = tf3;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		int num1 = Integer.parseInt(tf1.getText());
		int num2 = Integer.parseInt(tf2.getText());
		int num3 = num1 + num2;
		tf3.setText("" + num3);
	}
}