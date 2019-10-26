import java.net.*;
import java.io.*;

public class TestUDPClient
{
	public static void main(String args[]) throws Exception
	{
		//定义码头ds
		DatagramSocket ds = new DatagramSocket();
		
		
		//13行到23行完成的功能是： 定义可以发送数据的集装箱dp
		long n = 10000L; //13行
		ByteArrayOutputStream baos = new ByteArrayOutputStream();  //注意ByteArrayOutputStream的所有构造函数都没有byte[] buf这样的形参，即定义ByteArrayOutputStream流对象时是不能指定byte数组的，因为这个连接到的byte数组是由ByteArrayOutputStream自动生成的  9行  API:"public ByteArrayOutputStream(): 创建一个新的 byte 数组输出流。缓冲区的容量最初是 32 字节，如有必要可增加其大小。 "
									//9行代码一旦执行完毕，意味着两点: 1、在内存中生成了一个大小为32个字节的byte数组   2、有一根叫做baos的管道已链接到了该byte数组中，并且可以通过这个管道向该数组中写入数据
									//虽然此时可以通过baos向baos所连接到的在内存中分配好的byte数组中写入数据，但是ByteArrayOutputStream流并没有提供可以直接把long类型数据直接写入ByteArrayOutputStream流所连接到的byte数组中的方法, 简单说我们没法通过baos向baos所连接到的byte数组中写入long类型的数据, 查API文档可以发现: ByteArrayOutputStream流中并没有类似writeLong()这样的方法，但是DataOutputStream流中却有writeLong() writeFloat()等方法
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeLong(n);  //把n变量所代表的10000L写入dos所依附的baos管道所连接到的内存中的大小为32字节的byte数组中
		
		byte[] buf = baos.toByteArray();  //DataOutputStream 流中并没有toByteArray()方法，但是ByteArrayOutputStream 流中却有toByteArray()方法, 所以不可以把baos 改为dos，否则编译时会出错! ByteArrayOutputStream流中toByteArray()方法的含义，摘自API“创建一个新分配的 byte 数组。其大小是此输出流的当前大小，并且缓冲区的有效内容已复制到该数组中”
		DatagramPacket dp = new DatagramPacket(buf, buf.length, 
											   new InetSocketAddress("127.0.0.1", 5678)
											   );  //23行
		
		//在码头上把集装箱中的数据发送给对方
		ds.send(dp);
		
		//关闭码头
		ds.close();		
	}
}