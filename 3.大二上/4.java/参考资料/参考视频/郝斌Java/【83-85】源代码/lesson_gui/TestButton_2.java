/*
		按钮Button对象中有getActionCommand()方法，
		ActionEvent对象中也有getActionCommand()方法，
		两者都可以获得按钮激发的动作事件的命令名称
*/

import java.awt.*;
import java.awt.event.*;
class MyMonitor implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println( e.getActionCommand() + ":  通过对Button执行操作的的事件对象获取的" );
	}
}

public class TestButton_2{
	public static void main(String[] args){
		Frame f = new Frame();
		Button bn = new Button("点我啊");
		bn.addActionListener(new MyMonitor());
		System.out.println(bn.getActionCommand() + ":  通过Button对象获取的");
		f.add(bn);
		f.pack();
		f.setVisible(true);
	}
}