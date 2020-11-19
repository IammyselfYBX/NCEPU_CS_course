class TestData
{
	public static void main(String[] args)
	{
		byte b = 10;  // 1个字节
		int i = 6;   // 4个字节
		i = b; // OK
		//b = i; //error   会丢失数据
		b = (byte)i; //Ok  强制类型转化
		//b = i;  //本语句错误，这充分证明了：(byte)i并不会改变i本身的数据类型

/*		
		float x;
		//x = 10*0.2;  //error    10*0.2; 是double类型
		//x = 10*0.2f; //OK
		x = (float)(10*0.2);
		System.out.printf(b + ", " + i + ", " + x);
*/
	}
}
