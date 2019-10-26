import java.io.*;
import java.net.*;

public class TServer
{
	public static void main(String[] args)
	{
		ServerSocket ss = null;  //这里的ss必须得初始化，哪怕初始化为null也可以，否则会导致39行报错， 因为编译器认为14行并不一定会给ss赋值成功，  不过很可笑的是Java编译器认为try{......}中代码执行并不一定成功，所以要求你在try之前必须得对变量赋初值，但是编译器却检测不出赋初值为null的错误，以本程序为例，这里将ss赋为null，按照逻辑，try{....}中代码并不一定能给ss赋正确的值，那最终结果ss仍可能是null，所以理论上讲：39行代码仍然可能是错的，不过JAva编译器却检测不出这种错误，我估计是因为A aa = null;  aa.成员名; 这种方式编译器编译时是检测不出这种错误的，只会跑出NullPointerException异常 
		Socket s = null;
		DataInputStream dis = null;  
			
		try
		{
			ss = new ServerSocket(8888); // 14行 
			while (true)    
			{
				s = ss.accept();
				dis = new DataInputStream(s.getInputStream());  
				String str = dis.readUTF();  
				System.out.println("对方说的是: " + str);
			}
		}
		catch (SocketException e)
		{
			System.out.println("网络连接出错，程序终止");
			System.exit(-1);
		}
		catch (IOException e)
		{
			System.out.println("读写数据出错，程序终止");
			System.exit(-1);
		}
		finally
		{
			try
			{
				dis.close();  
				s.close();    
				ss.close();  //39行  
			}
			catch (Exception e)
			{
			}
		}
	}
}