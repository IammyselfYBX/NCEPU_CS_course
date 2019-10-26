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
		connect();  //如果客户端程序没有打开的话，则程序将在72行停滞不前，即如果客户端程序没有打开的话, 31和32行的代码是不会执行的
		new TCPServerReader().start();  //31行
		new TCPServerWriter().start();  //32行
	}
	
	public void createUI()
	{
		f = new Frame();
		f.setTitle("服务器端");
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
			s = ss.accept();  //72行
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
				try  //91行
				{
					String str = dis.readUTF();  //要明白两点：第一：如果客户端断开连接的话，dis.readUTF()会抛出java.io.EOFException异常；  第二：如果102行只捕获异常而不处理异常的话，则编译器会认为异常已得到处理，因此程序会继续向下执行，而不是立即终止程序， 其最终结果是程序陷入死循环，不停的执行91到107行的代码					
					ta.append("对方说: " + str + "\n");
					if (str.equals("再见"))
					{
						close();
						System.exit(-1);
					}
				}
				catch (Exception e)  //102行
				{
					JOptionPane.showMessageDialog(f,  "提示: 客户端已经断开连接");
					
					//e.printStackTrace();
					//System.exit(-1);
					return ;
				}  //107行				
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
				//e2.printStackTrace();
				System.exit(-1);
			}
		}
	}
}