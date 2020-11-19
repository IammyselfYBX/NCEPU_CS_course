import java.io.*;

public class TestPrintWriter
	public static void main (String[] args) {
		
		try 
		{
			InputStreamReader  is = new InputStreamReader(System.in);
			BufferedReader in=new BufferedReader(is);
			PrintWriter out  = new PrintWriter(new FileWriter("d:/haobin.java"));  //new PrintWriter(new FileWriter("d:/haobin.java", true)); 加true参数表示数据追加到文件的末尾，没有true参数，表示直接覆盖掉原文件的内容
			String s = in.readLine();
			
			// 从键盘逐行读入数据输出到文件
			while (!s.equals("")) 
			{
				out.println(s);  //把s代表的字符串写入out所关联到的文件中,并追加换行符，如果把out.println(s);改为out.print(s); 则不会追加换行符
				s = in.readLine();
			}
			in.close();   // 关闭BufferedReader输入流.		     
			out.flush();  //20行
			//out.close();  // 关闭连接文件的PrintWriter输出流.  在把20行注释掉的情况下，如果也把本行注释掉，则运行发现"d:/haobin.java"文件的内容仍然为空,即数据没有写到文件中
		}
		catch (IOException e) 
		{
			e.printStackTrace();  
		}
	 }
}
