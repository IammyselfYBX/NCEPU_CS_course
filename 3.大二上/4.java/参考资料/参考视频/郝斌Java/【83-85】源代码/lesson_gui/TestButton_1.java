/*
	Button��
		1�� getLabel() ���ص�һ������������ʾ�����ܹ��ɿ����İ�ť�ϵ���Ϣ,
		    �����ص��Ǳ�ǩ�ַ�������Ϣ�������ť�ı���ַ���Ϊ�գ���getLabel()����null

		2�� getActionCommand()���ص���ActionCommand���Ե�ֵ�����ActionCommand����ֵΪnull��
			�򷵻ذ�ť��ǩ�ַ�������Ϣ

	��ע��	����bn �Ǹ�Button����
			����bn��ťʱ��bn������Զ�����ActionEvent���� ����ActionEvent�����͸���������
				void actionPerformed(ActionEvent e) 
			�������β�e
			ע�⣺bn���Զ������Լ���ǩ�ַ�������ϢҲ��װ��ActionEvent������,�����������Ա�޸���bn������"actionCommand"��ֵ����bn�Ͳ��ٰ����Լ���ǩ�ַ�������Ϣ��װ��ActionEvent�����У����ǰ�����"actionCommand"��ֵ��װ��ActionEvent������
*/

import java.awt.*;

public class TestButton_1
{
	public static void main(String[] args)
	{
		Frame f = new Frame();
		Button bn = new Button("����");
		
		String str = bn.getLabel();
		System.out.println(str);
		
		str = bn.getActionCommand();
		System.out.println(str);
		
		bn.setActionCommand("����");
		str = bn.getActionCommand();
		System.out.println(str);
		
		str = bn.getLabel();
		System.out.println(str);
	}
}