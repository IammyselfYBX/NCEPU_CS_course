import java.awt.*;
import java.awt.event.*;

public class TestWindow
{
	public static void main(String[] args)
	{
		//如果把10行的final去掉，本程序在18行就会报错,因为匿名类只能访问包裹它的方法中的final类型的局部变量
		final Frame f = new Frame(); //10行  
		f.setSize(200, 200);
		f.addWindowListener(	
				new WindowAdapter()
				{
					public void windowClosing(WindowEvent e)
					{
						f.setVisible(false);//18行
						System.exit(-1);
					}
				}
		);
		f.setVisible(true);
	}	
}