class TestData
{
	public static void main(String[] args)
	{
		byte b = 10;  // 1���ֽ�
		int i = 6;   // 4���ֽ�
		i = b; // OK
		//b = i; //error   �ᶪʧ����
		b = (byte)i; //Ok  ǿ������ת��
		//b = i;  //������������֤���ˣ�(byte)i������ı�i�������������

/*		
		float x;
		//x = 10*0.2;  //error    10*0.2; ��double����
		//x = 10*0.2f; //OK
		x = (float)(10*0.2);
		System.out.printf(b + ", " + i + ", " + x);
*/
	}
}
