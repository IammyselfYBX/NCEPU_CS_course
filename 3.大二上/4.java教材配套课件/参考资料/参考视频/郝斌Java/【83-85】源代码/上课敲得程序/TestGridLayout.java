/*	
	2008年10月18日16:27:16
	GridLayout的构造函数
		public GriLayout(int, int); 
	的用法
*/
import java.awt.*;

public class TestGridLayout 
{
	public static void main(String args[]) 
	{
        Frame f = new Frame("GridLayout Example");
        
		Button b1 = new Button("b1");
        Button b2 = new Button("b2");
        Button b3 = new Button("b3");
        Button b4 = new Button("b4");
        Button b5 = new Button("b5");
        Button b6 = new Button("b6");
        f.setLayout (new GridLayout(2,10)); //第一个参数是多少，则输出的就是多少行，列数是编译器根据行数自动计算出来的
        f.add(b1);        
        f.add(b2);
        f.add(b3);        
        f.add(b4);
        f.add(b5);        
        f.add(b6);
        
        f.pack();  //如果把该语句注释掉，则输出结果就变成一个只有标题栏的小窗口，摘自API：“pack() - 类 java.awt.Window 中的方法， 调整此窗口的大小，以适合其子组件的首选大小和布局” ，郝斌：也就是把子组件包括起来，会根据它所容纳的子组件的大小自动调整自身的大小 ，把子组件包括起来        
        f.setVisible(true);
	}
}
