/*
	功能：把一个long类型的数据写入byte数组中,然后再从byte数组中读取出
		  这个long类型的数据
		  
		  因为网络编程中经常要把数值型数据存入byte数组中然后打包成
		  DatagramPacket经过网络传输到目的机，目的机再从byte数组中
		  把原数值型数据还原回来
	
	目的: ByteArrayOutputStream   DataOutputStream  ByteInputStream DataInputStream 流的使用
		  记住: DataOutputStream流中的writeLong(long n)是把n变量在内存
		  		中的二进制代码写入该流所连接到的设备中
		  		
	注意：查API文档得知：
			构造  ByteArrayOutputStream 对象时不需要也不能指定缓冲数组，因为缓冲数组默认已经内置好了 		
		  	构造  ByteArrayInputStream 对象时必须的指定缓冲数组是谁！
*/

import java.io.*;

public class TestByteArrayOutputStream1
{
	public static void main(String args[]) throws Exception
	{
		long n = 9876543210L;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();  //9行  API:"public ByteArrayOutputStream(): 创建一个新的 byte 数组输出流。缓冲区的容量最初是 32 字节，如有必要可增加其大小。 "
									//9行代码一旦执行完毕，意味着两点: 1、在内存中生成了一个大小为32个字节的byte数组   2、有一根叫做baos的管道已链接到了该byte数组中，并且可以通过这个管道向该byte数组中写入数据
									//虽然此时可以通过baos向baos所连接到的在内存中分配好的byte数组中写入数据，但是ByteArrayOutputStream流并没有提供可以直接把long类型数据直接写入ByteArrayOutputStream流所连接到的byte数组中的方法, 简单说我们没法通过baos向baos所连接到的byte数组中写入long类型的数据, 查API文档可以发现: ByteArrayOutputStream流中并没有类似writeLong()这样的方法，但是DataOutputStream流中却有writeLong() writeFloat()等方法
		DataOutputStream dos = new DataOutputStream(baos);
		
		dos.writeLong(n);  //把n变量所代表的10000L在内存中的二进制代码写入dos所依附的baos管道所连接到的内存中的大小为32字节的byte数组中，由运行结果来看，这是二进制写入，既不是把10000L转化为字符'1' '0' '0' '0' '0'写入byte数组中，而是把10000L在内存中的总共8个字节的二进制代码写入byte数组中
		
		dos.flush();
		byte[] buf = baos.toByteArray();  //DataOutputStream 流中并没有toByteArray()方法，但是ByteArrayOutputStream 流中却有toByteArray()方法, 所以不可以把baos 改为dos，否则编译时会出错! ByteArrayOutputStream流中toByteArray()方法的含义，摘自API“创建一个新分配的 byte 数组。其大小是此输出流的当前大小，并且缓冲区的有效内容已复制到该数组中”

		//利用ByteArrayInputStream 和 DataInputStream 可以从byte数组中得到原long类型的数值10000L
		ByteArrayInputStream bais = new ByteArrayInputStream(buf);
		DataInputStream dis = new DataInputStream(bais);
		long l = dis.readLong();

		System.out.println("l = " + l);
		dos.close();
	}
}
/*
	在JDK 1.6中的运行结果是：
----------------
l = 9876543210
----------------
*/