/*
		��ťButton��������getActionCommand()������
		ActionEvent������Ҳ��getActionCommand()������
		���߶����Ի�ð�ť�����Ķ����¼�����������
*/

import java.awt.*;
import java.awt.event.*;
class MyMonitor implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println( e.getActionCommand() + ":  ͨ����Buttonִ�в����ĵ��¼������ȡ��" );
	}
}

public class TestButton_2{
	public static void main(String[] args){
		Frame f = new Frame();
		Button bn = new Button("���Ұ�");
		bn.addActionListener(new MyMonitor());
		System.out.println(bn.getActionCommand() + ":  ͨ��Button�����ȡ��");
		f.add(bn);
		f.pack();
		f.setVisible(true);
	}
}