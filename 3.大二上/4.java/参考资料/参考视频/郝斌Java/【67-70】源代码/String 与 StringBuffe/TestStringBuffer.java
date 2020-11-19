public class TestStringBuffer{
	public static void main(String[] args){
		StringBuffer sb = new StringBuffer();
		sb.append("abc");
		sb.append("123");
		System.out.println("sb = " + sb);  //sb = abc123
		sb.insert(3, "--"); 
		System.out.println("sb = " + sb);  //sb = abc--123
		sb.delete(2,6); //把下标从2开始到6-1结束的字符删除
		System.out.println("sb = " + sb); //sb = ab23
		sb.reverse();
		System.out.println("sb = " + sb);  //sb = 32ba
		String str = sb.toString();
		System.out.printf("str = " + str); //str = 32ba
	}
}