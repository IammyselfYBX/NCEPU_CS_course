import java.awt.*;

public class Test
{
	public static void main(String[] args)
	{
		Frame f = new Frame();
		
		Button bn = new Button("OK");
		f.add(bn);
		
		//f.setSize(200, 200);
		f.pack();  //package
		f.setVisible(true);
	}
}