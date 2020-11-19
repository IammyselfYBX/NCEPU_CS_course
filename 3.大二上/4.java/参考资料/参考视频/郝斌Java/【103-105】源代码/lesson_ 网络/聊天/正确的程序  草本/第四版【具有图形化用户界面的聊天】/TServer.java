import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.*;

public class TServer
{
	public static void main(String[] args)
	{
		new TCPServer().launch();
	}
}

class TCPServer
{
	private TextArea ta = null;
	private TextField tf = null;
	private Button bn = null;
	private DataInputStream dis = null;
	private DataOutputStream dos = null;
	private ServerSocket ss = null;
	private Socket s = null; 
	private Frame f = null;

	public void launch()
	{
		createUI();
		connect();  //����ͻ��˳���û�д򿪵Ļ����������72��ͣ�Ͳ�ǰ��������ͻ��˳���û�д򿪵Ļ�, 31��32�еĴ����ǲ���ִ�е�
		new TCPServerReader().start();  //31��
		new TCPServerWriter().start();  //32��
	}
	
	public void createUI()
	{
		f = new Frame();
		f.setTitle("��������");
		ta = new TextArea();
		tf = new TextField();
		Panel p = new Panel(new BorderLayout());
		bn = new Button("����");
		
		p.add(tf, BorderLayout.CENTER);
		p.add(bn, BorderLayout.EAST);
		
		f.add(ta, BorderLayout.CENTER);
		f.add(p, BorderLayout.SOUTH);
		
		f.setSize(400, 400);
		f.setVisible(true);	
		
		f.addWindowListener(
				new WindowAdapter()
				{
					public void windowClosing(WindowEvent e)
					{
						System.exit(-1);
					}
				}
		);	
	}
	
	public void close()
	{
		try
		{
			dis.close();
			dos.close();
			s.close();
			ss.close();
		}
		catch (Exception e)
		{
			System.exit(-1);
		}
	}
	
	public void connect()
	{
		try
		{
			ss = new ServerSocket(8888);
			s = ss.accept();  //72��
			dis = new DataInputStream(s.getInputStream());
			dos = new DataOutputStream(s.getOutputStream());
		}
		catch (Exception e)
		{
			//e.printStackTrace();
			System.exit(-1); 
		}	
	}
	
	
	class TCPServerReader extends Thread
	{
		public void run()
		{
			while (true)
			{
				try  //91��
				{
					String str = dis.readUTF();  //Ҫ�������㣺��һ������ͻ��˶Ͽ����ӵĻ���dis.readUTF()���׳�java.io.EOFException�쳣��  �ڶ������102��ֻ�����쳣���������쳣�Ļ��������������Ϊ�쳣�ѵõ�������˳�����������ִ�У�������������ֹ���� �����ս���ǳ���������ѭ������ͣ��ִ��91��107�еĴ���					
					ta.append("�Է�˵: " + str + "\n");
					if (str.equals("�ټ�"))
					{
						close();
						System.exit(-1);
					}
				}
				catch (Exception e)  //102��
				{
					JOptionPane.showMessageDialog(f,  "��ʾ: �ͻ����Ѿ��Ͽ�����");
					
					//e.printStackTrace();
					//System.exit(-1);
					return ;
				}  //107��				
			}
		}
	}
	
	class TCPServerWriter extends Thread
	{
		public void run()
		{
			tf.addActionListener(new TCPServerListener());
			bn.addActionListener(new TCPServerListener());				
		}
	}
	
	class TCPServerListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)  //108��
		{
			try
			{
				String str = tf.getText();
				tf.setText("");
				ta.append("�Լ�˵: " + str + "\n");
				dos.writeUTF(str);
				if (str.equals("�ټ�"))
				{
					close();
					System.exit(-1);
				}					
			}
			catch (Exception e2)  //���������β�Ҳ����Ϊe�������108�еĴ����е��β�e�����ظ��� ������ｨ���Ϊ��������
			{
				//e2.printStackTrace();
				System.exit(-1);
			}
		}
	}
}