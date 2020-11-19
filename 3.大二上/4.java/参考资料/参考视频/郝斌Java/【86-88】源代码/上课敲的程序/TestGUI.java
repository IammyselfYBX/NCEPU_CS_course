import java.awt.*;

public class TestGUI
{
	public static void main(String[] args)
	{
		Frame f = new Frame();
		f.setSize(400, 400);
		f.setLayout(new GridLayout(2,1));
		
		Panel p1 = new Panel();
		p1.setLayout(new BorderLayout());
		Panel p1_1 = new Panel();
		p1_1.setLayout(new GridLayout(2, 1));
		Button bn1 = new Button("BUTTON1");
		Button bn2 = new Button("BUTTON2");
		Button bn3 = new Button("BUTTON3");
		Button bn4 = new Button("BUTTON4");
		p1.add(bn1, BorderLayout.WEST);
		p1_1.add(bn3);
		p1_1.add(bn4);
		p1.add(p1_1, BorderLayout.CENTER);
		p1.add(bn2, BorderLayout.EAST);
		
		
		Panel p2 = new Panel();
		p2.setLayout(new BorderLayout());
		Panel p2_2 = new Panel();
		p2_2.setLayout(new GridLayout(2,2));
		Button bn5 = new Button("BUTTON5");
		Button bn6 = new Button("BUTTON6");
		Button bn7 = new Button("BUTTON7");
		Button bn8 = new Button("BUTTON8");
		Button bn9 = new Button("BUTTON9");
		Button bn10 = new Button("BUTTON10");
		p2.add(bn5, BorderLayout.WEST);
		p2.add(bn6, BorderLayout.EAST);
		p2_2.add(bn7);
		p2_2.add(bn8);
		p2_2.add(bn9);
		p2_2.add(bn10);
		p2.add(p2_2);
		
		
		f.add(p1);
		f.add(p2);
		f.pack();
		f.setVisible(true);
		
	}
}