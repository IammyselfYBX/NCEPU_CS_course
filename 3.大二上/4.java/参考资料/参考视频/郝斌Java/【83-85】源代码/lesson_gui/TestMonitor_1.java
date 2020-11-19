/*
	����bn �Ǹ�Button����
	����bn��ťʱ��bn������Զ�����ActionEvent���� ����ActionEvent�����͸���������
		void actionPerformed(ActionEvent e) 
 	�������β�e
	
	ע�⣺bn���Զ������Լ���ǩ�ַ�������ϢҲ��װ��ActionEvent������
	�����������Ա�޸���bn������"actionCommand"��ֵ����bn�Ͳ��ٰ����Լ���ǩ�ַ�������Ϣ
	��װ��ActionEvent�����У����ǰ�����"actionCommand"��ֵ��װ��ActionEvent������	
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
		System.out.println(e.getActionCommand());  //e.getActionCommand() ���ص���e�¼�����Ӧ���¼�Դ��ť��actionCommand ��ֵ��������¼�Դ��ť��actionCommand ��ֵΪnull���򷵻��¼�Դ��ť�ı�ǩ�ַ�����ֵ,�¼�Դ��ť�ı�ǩ�ַ�����ֵ����ͨ���������д���ĵ�
		
		//��ȡ�¼�Դ��ť�ı�ǩ�ַ�����ֵ
		Button bn = (Button)e.getSource();
		System.out.println(bn.getLabel());  //����ֱ��дe.getLabel(); ��ΪActionEvent������û��getLabel()������
	}
}