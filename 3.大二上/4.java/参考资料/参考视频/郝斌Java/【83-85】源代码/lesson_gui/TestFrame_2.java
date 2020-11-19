/*
	有关Frame类中方法的使用
*/

import java.awt.Frame;

public class TestFrame_2
{
	public static void main(String[] args)
	{
		Frame f = new Frame("哈哈");
		f.setSize(200, 200);
		f.setVisible(true);  //先在距离显示器（0，0）的位置显示窗口
		
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			System.out.println(e.getMessage());
		}
		
		f.setLocation(200, 200);  //过2秒后窗口移动到距离显示器（200， 200）的位置显示
	
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			System.out.println(e.getMessage());
		}
		
		f.setVisible(false);  //再过一秒钟，窗口消失
	}
}