/*
	Button类
		1、 getLabel() 返回的一定是我们在显示器上能够可看到的按钮上的信息,
		    即返回的是标签字符串的信息，如果按钮的标间字符串为空，则getLabel()返回null

		2、 getActionCommand()返回的是ActionCommand属性的值，如果ActionCommand属性值为null，
			则返回按钮标签字符串的信息

	附注：	假设bn 是个Button对象
			单击bn按钮时，bn对象会自动产生ActionEvent对象， 并把ActionEvent对象发送给监听器中
				void actionPerformed(ActionEvent e) 
			方法的形参e
			注意：bn会自动把它自己标签字符串的信息也封装到ActionEvent对象中,但是如果程序员修改了bn中属性"actionCommand"的值，则bn就不再把它自己标签字符串的信息封装到ActionEvent对象中，而是把属性"actionCommand"的值封装到ActionEvent对象中
*/

import java.awt.*;

public class TestButton_1
{
	public static void main(String[] args)
	{
		Frame f = new Frame();
		Button bn = new Button("哈哈");
		
		String str = bn.getLabel();
		System.out.println(str);
		
		str = bn.getActionCommand();
		System.out.println(str);
		
		bn.setActionCommand("嘻嘻");
		str = bn.getActionCommand();
		System.out.println(str);
		
		str = bn.getLabel();
		System.out.println(str);
	}
}