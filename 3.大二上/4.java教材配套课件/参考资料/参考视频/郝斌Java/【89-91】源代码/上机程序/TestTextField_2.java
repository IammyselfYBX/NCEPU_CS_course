import java.awt.*;
import java.awt.event.*;

public class TestTextField_2
{
	public static void main(String[] argsw)
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
		tf1 = new TextField(10);
		tf2 = new TextField(10);
		tf3 = new TextField(10);
		Label Lb = new Label("+");
		Button bn = new Button("=");
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
	private TF tf = null;
	
	public MyMonitor(TF tf)
	{
		this.tf = tf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		int num1 = Integer.parseInt( tf.tf1.getText() );
		int num2 = Integer.parseInt( tf.tf2.getText() );
		int num3 = num1 + num2;
		tf.tf3.setText(num3+"");
	}
}