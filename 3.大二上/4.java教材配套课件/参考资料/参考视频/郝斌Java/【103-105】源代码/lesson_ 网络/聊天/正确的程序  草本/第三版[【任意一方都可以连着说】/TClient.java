import java.io.*;
import java.net.*;

public class TClient
{
	public static void main(String[] args) throws Exception
	{
		Socket s = new Socket("127.0.0.1", 8888);
		DataInputStream dis = new DataInputStream(s.getInputStream());
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		
		new ClientRead(dis).start();
		new ClientWriter(dos).start();		
	}
}

class ClientRead extends Thread
{
	private DataInputStream dis = null;
	
	public ClientRead(DataInputStream dis)
	{
		this.dis = dis;
	}
	
	public void run()
	{
		while (true)
		{
			try
			{
				String str = dis.readUTF();
				System.out.println("对方说的是: " + str);
				if (str.equalsIgnoreCase("再见"))
					break;
			}
			catch (Exception e)
			{
			}	
		}
	}
}

class ClientWriter extends  Thread
{
	private DataOutputStream dos = null;
	
	public ClientWriter(DataOutputStream dos)
	{
		this.dos = dos;
	}

	public void run()
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true)
		{
			try
			{
				String str = br.readLine();
				dos.writeUTF(str);
				if (str.equalsIgnoreCase("再见"))
					break;
			}
			catch (Exception e)
			{
			}	
		}
	}
	
}