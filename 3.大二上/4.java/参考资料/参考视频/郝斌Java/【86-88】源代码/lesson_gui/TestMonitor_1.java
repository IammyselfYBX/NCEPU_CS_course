/*
	假设bn 是个Button对象
	单击bn按钮时，bn对象会自动产生ActionEvent对象， 并把ActionEvent对象发送给监听器中
		void actionPerformed(ActionEvent e) 
 	方法的形参e
	
	注意：bn会自动把它自己标签字符串的信息也封装到ActionEvent对象中
	但是如果程序员修改了bn中属性"actionCommand"的值，则bn就不再把它自己标签字符串的信息
	封装到ActionEvent对象中，而是把属性"actionCommand"的值封装到ActionEvent对象中	
*/

import java.awt.*;
import java.awt.event.*;

public class TestMonitor_1
{
	public static void main(String[] args)
	{
		Frame f = new Frame();
		f.setLayout(new BorderLayout());
		
		Button bn1 = new Button("Start!");
		bn1.addActionListener( new MyMonitor() ) ;
		
		Button bn2 = new Button("End!");
		bn2.setActionCommand("Game  Over!");
		bn2.addActionListener(new MyMonitor());
		
		f.add(bn1, BorderLayout.NORTH);
		f.add(bn2, BorderLayout.SOUTH);
		
		f.pack();
		f.setVisible(true);		
	}
}

class MyMonitor implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		System.out.println(e.getActionCommand());  //e.getActionCommand() 返回的是e事件所对应的事件源按钮的actionCommand 的值，但如果事件源按钮的actionCommand 的值为null，则返回事件源按钮的标签字符串的值,事件源按钮的标签字符串的值可以通过下面两行代码的道
		
		//获取事件源按钮的标签字符串的值
		Button bn = (Button)e.getSource();
		System.out.println(bn.getLabel());  //不能直接写e.getLabel(); 因为ActionEvent类中是没有getLabel()方法的
	}
}