public class TestBit
{
	public static void main(String[] args)
	{
		int i = -3;
		int j = 11;
		int k = i & j;  //3:  0000 0011  ȡ��  1111 1100 ��1:  1111 1101 ��-3�Ķ����ƴ����� 1111 1101  ��11�Ķ����ƴ�����: 0000 1011
		
		System.out.printf("%d\n", k);
	}
}