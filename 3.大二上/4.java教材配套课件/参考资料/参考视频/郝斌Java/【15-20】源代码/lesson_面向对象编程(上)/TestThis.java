class A
{
	private int i;
	public A(int i)
	{
		this.i = i;  //将形参 i 赋给该构造方法本次运行所创建的那个新对象的i数据成员
	}
	public void show(){
		System.out.println("i = " + this.i);
			//this表示当前时刻正在调用show方法的对象
			//this可以省略
	}
}

public class TestThis
{
	public static void main(String[] args){
		A aa1 = new A(100);
		aa1.show();
		
		A aa2 = new A(200);
		aa2.show();
	}	
}

