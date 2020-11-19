class A{
	private int i = 1;	
	private void f(){
		System.out.println("哈哈");
	}
	
	//B是A的内部类
	class B{
		public int bi = 10;
		
		//非静态的内部类可以访问外部类所有的成员
		public void g(){
			System.out.printf("i = %d\n", i);
			f();  
		}
	}
	
	public void k(){
		//g();  //error 外部类的方法不可以直接访问内部类的成员
		//System.out.println(bi);  //error 外部类的方法不可以直接访问内部类的成员
		
		B bb = new B();
		bb.g();
	}	
}

public class Test{
	public static void main(String[] args){
		A aa = new A();
		aa.k();
	}
}
