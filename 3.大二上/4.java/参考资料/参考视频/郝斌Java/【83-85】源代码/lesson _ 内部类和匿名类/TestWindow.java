import java.awt.*;
import java.awt.event.*;

public class TestWindow
{
	public static void main(String[] args)
	{
		//�����10�е�finalȥ������������18�оͻᱨ��,��Ϊ������ֻ�ܷ��ʰ������ķ����е�final���͵ľֲ�����
		final Frame f = new Frame(); //10��  
		f.setSize(200, 200);
		f.addWindowListener(	
				new WindowAdapter()
				{
					public void windowClosing(WindowEvent e)
					{
						f.setVisible(false);//18��
						System.exit(-1);
					}
				}
		);
		f.setVisible(true);
	}	
}