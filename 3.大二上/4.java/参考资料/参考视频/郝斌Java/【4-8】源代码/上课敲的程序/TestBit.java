public class TestBit
{
	public static void main(String[] args)
	{
		int i = -3;
		int j = 11;
		int k = i & j;  //3:  0000 0011  取反  1111 1100 加1:  1111 1101 即-3的二进制代码是 1111 1101  而11的二进制代码是: 0000 1011
		
		System.out.printf("%d\n", k);
	}
}