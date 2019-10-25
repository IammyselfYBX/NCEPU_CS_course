class A
{
	public int i = 2;
	public boolean flag = true;
	
	public A(int j, boolean f)
	{
		i = j;
		flag = f;		
	}
	
	public void show()
	{
		System.out.printf("%d\n", i);
		System.out.printf("%b\n", flag); //boolean用%b或%B来输出
	}
	
}

class TestConst_2
{
	public static void main(String[] args)
	{
		A aa = new A(88, false);
		aa.show();
		
//		int k;  //局部变量编译器是不会自动进行初始化的，java要求所有的局部变量在使用之前都必须的初始化
//		System.out.printf("%d\n", k);
	}
}