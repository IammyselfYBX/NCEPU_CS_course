import java.io.*;

public class TestData
{
	public static void main(String[] args) throws Exception 
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		long m = 1234567;
		dos.writeLong(m);
		
		
		byte[] buf2 = baos.toByteArray();
		ByteArrayInputStream bais = new ByteArrayInputStream(buf2);
		DataInputStream dis = new DataInputStream(bais);
		long n;
		n = dis.readLong();
		//dis.readLong(n);  //error	
		
		System.out.println("n = " + n);	
	}
}