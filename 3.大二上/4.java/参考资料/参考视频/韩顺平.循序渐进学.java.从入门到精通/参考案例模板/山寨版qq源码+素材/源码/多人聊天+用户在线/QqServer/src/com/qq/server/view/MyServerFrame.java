/**
 * ���Ƿ������˵Ŀ��ƽ��棬��������������������رշ�����
 * ���Թ���ͼ���û�.
 */
package com.qq.server.view;


import javax.swing.*;

import com.qq.server.model.MyQqServer;

import java.awt.*;
import java.awt.event.*;
public class MyServerFrame extends JFrame implements ActionListener {

	
	JPanel jp1;
	JButton jb1,jb2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyServerFrame mysf=new MyServerFrame();
	}
	
	public MyServerFrame()
	{
		jp1=new JPanel();
		jb1=new JButton("����������");
		jb1.addActionListener(this);
		jb2=new JButton("�رշ�����");
		jp1.add(jb1);
		jp1.add(jb2);
		
		
		this.add(jp1);
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb1)
		{
			new MyQqServer();
		}
	}
	

}
