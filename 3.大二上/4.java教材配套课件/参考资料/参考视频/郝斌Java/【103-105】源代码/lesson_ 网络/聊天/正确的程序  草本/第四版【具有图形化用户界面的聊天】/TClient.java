import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;

public class TClient
{
	public static void main(String[] args)
	{
		new TCPClient().launch();
	}
}

class TCPClient
{
	private TextArea ta = null;
	private TextField tf = null;
	private Button bn = null;
	private DataInputStream dis = null;
	private DataOutputStream dos = null;
	private Socket s = null;
	private Frame f = null;

	public void launch()
	{
		createUI();
		connect();  
		new TCPClientReader().start();  
		new TCPClientWriter().start();  
	}
	
	public void createUI()
	{
		f = new Frame("客户端");
		f.setLocation(300, 200);
		ta = new TextArea();
		tf = new TextField();
		Panel p = new Panel(new BorderLayout());
		bn = new Button("发送");
		
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
		}
		catch (Exception e)
		{
			//System.exit(-1);
		}
	}
	
	public void connect()
	{
		try
		{
			s = new Socket("127.0.0.1", 8888);  //在机房可以修改本IP
			dis = new DataInputStream(s.getInputStream());
			dos = new DataOutputStream(s.getOutputStream());
		}
		catch (Exception e)
		{
//			e.printStackTrace();
//			System.exit(-1);
		}			
	}
	
	
	class TCPClientReader extends Thread
	{
		public void run()
		{
			while (true)
			{
				try
				{
					String str = dis.readUTF();
					ta.append("对方说: " + str + "\n");
					if (str.equals("再见"))
					{
						close();
						System.exit(-1);
					}
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(f,  "提示: 客户端已经断开连接");
					//e.printStackTrace();
					//System.exit(-1);
					return;
				}				
			}
		}
	}
	
	class TCPClientWriter extends Thread
	{
		public void run()
		{
			tf.addActionListener(new TCPClientListener());
			bn.addActionListener(new TCPClientListener());
		}
	}
	
	class TCPClientListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)  //108行
		{
			try
			{
				String str = tf.getText();
				tf.setText("");
				ta.append("自己说: " + str + "\n");
				dos.writeUTF(str);
				if (str.equals("再见"))
				{
					close();
					System.exit(-1);
				}					
			}
			catch (Exception e2)  //如果这里的形参也定义为e，将会和108行的代码中的形参e命名重复， 因此这里建议改为其他名字
			{
				e2.printStackTrace();
				System.exit(-1);
			}
		}
	}
}