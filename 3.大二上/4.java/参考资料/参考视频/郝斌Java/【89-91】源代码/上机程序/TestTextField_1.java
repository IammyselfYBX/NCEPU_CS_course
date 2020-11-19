import java.awt.*;
import java.awt.event.*;

public class TestTextField_1
{
	public static TextField tf1, tf2, tf3;
	
	public static void main(String[] argsw)
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
		
		MyMonitor mm = new MyMonitor();
		bn.addActionListener(mm);
		
		f.addWindowListener(mm);
		
		f.pack();
		f.setVisible(true);
	}	
}

class MyMonitor extends WindowAdapter implements ActionListener  //extends必须写在implements的前面 ，这是语法规定 
{
	@Override
	public void actionPerformed(ActionEvent e)
	{
		int num1 = Integer.parseInt( TestTextField_1.tf1.getText() );
		int num2 = Integer.parseInt( TestTextField_1.tf2.getText() );
		int num3 = num1 + num2;
		TestTextField_1.tf3.setText(num3+"");
	}
	
	@Override
	public void windowClosing(WindowEvent e)
	{
		System.exit(-1);
	}
}