/*
	try{.....}�ж���ľֲ�����ֻ����try {......}��ʹ�ã������������ط�ʹ��
*/

public class Test
{
	public static void main(String[] args)
	{
		try
		{
			int i = 10;
			System.out.println("i = " + i);
		}
		catch (Exception e)
		{
			//System.out.println("i = " + i);  //error   ��Ϊ��try{.....}�ж���ľֲ�����ֻ����try{....}��ʹ�ã�   try{.....}�ж���ľֲ�����������catch(..) {.....} �� finally{.....}��ʹ��
		}
		finally
		{ 
			//System.out.println("i = " + i);    //error ԭ��ͬ��
		}
		
		//System.out.println("i = " + i);    //�ܽ�: try{.....}�ж���ľֲ�����ֻ����try {......}��ʹ�ã������������ط�ʹ��
	}
}