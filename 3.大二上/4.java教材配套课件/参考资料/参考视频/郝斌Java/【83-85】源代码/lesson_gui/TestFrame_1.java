/*
	有关Frame类中方法的使用_1
*/
import java.awt.*;
public class TestFrame_1 
{
	public static void main( String args[]) {
		Frame f = new Frame("My First Test");  //这句话只是在内存中产生了一个对象，你要想让窗口在显示器上显示出来，则必须得调用f.setVisible(true);
		//f.setLocation(800, 300);  //第一个参数表示新产生的窗口距离屏幕(这个屏幕不是指当前屏幕，而是指整个Windows系统的屏幕)最左边有几个像素  第二个参数表示新产生的窗口距离屏幕最上边有几个像素
		f.setSize(300, 600); //第一个参数表示窗口宽度   第二个参数表示窗口的高度
		f.setBackground( Color.PINK); //设置背景色
		//f.setResizable(false); //设置是否可以调整窗口大小，false表示不可以调整大小，true表示可以调整大小
		f.setVisible( true); //设置窗口是否可见 true表示可见，false表示不可见
	}
}