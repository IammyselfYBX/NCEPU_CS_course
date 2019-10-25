import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Frame;
import java.awt.Button;

class MyMonitor implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("按钮被按下!");
	}
}

public class TestActionEvent
{
	public static void main(String[] args)
	{
		Frame f = new Frame("Test");
		Button b = new Button("Press Me!");
		MyMonitor mm = new MyMonitor();
		b.addActionListener(mm);
		f.add(b);
		f.pack();
		f.setVisible(true);
;	}
}