import java.awt.*;
public class TestBorderLayout 
{
	public static void main(String args[]) 
	{
		Frame f;
		f = new Frame();
		Button bn = new Button("BN");
		Button bs = new Button("BS");
		Button bw = new Button("BW");
		Button be = new Button("BE");
		Button bc = new Button("BC");
		
////		f.add(bn, "North");  //"red"  Color.RED   "north"  BorderLayout.NORTH
////		f.add(bs, "South");
////		f.add(bw, "West");
////		f.add(be, "East");
////		f.add(bc, "Center");
		
		
		// 也可使用下述语句
//		f.add(bn, BorderLayout.NORTH);
//		f.add(bs, BorderLayout.SOUTH);
//		f.add(bw, BorderLayout.WEST);
//		f.add(be, BorderLayout.EAST);
//		f.add(bc, BorderLayout.CENTER);
		
		f.add(bn, BorderLayout.NORTH);
		f.add(bw, BorderLayout.SOUTH);
		
		f.setSize(200,200);
		f.setVisible(true);
	}
}
