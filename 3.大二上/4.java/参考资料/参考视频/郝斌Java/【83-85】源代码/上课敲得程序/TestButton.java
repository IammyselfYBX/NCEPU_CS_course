import java.awt.*;
import java.awt.event.*;

public class TestButton
{
	public static void main(String[] args)
	{
		Frame f = new Frame();
		Button bn = new Button("OK");
		f.add(bn);
		A aa = new A();
		
		bn.addActionListener(aa);  //
		
		f.pack();
		f.addWindowListener(new B());		
		
		f.setVisible(true);
	}
}

class B extends WindowAdapter //implements WindowListener 
{
	public void windowClosing(WindowEvent e)
	{
		System.exit(-1);
	}	
}

class A implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("今天我很爽!");
		//System.exit(-1);
	}
}