class A{
	private int i = 1;	
	private void f(){
		System.out.println("����");
	}
	
	//B��A���ڲ���
	class B{
		public int bi = 10;
		
		//�Ǿ�̬���ڲ�����Է����ⲿ�����еĳ�Ա
		public void g(){
			System.out.printf("i = %d\n", i);
			f();  
		}
	}
	
	public void k(){
		//g();  //error �ⲿ��ķ���������ֱ�ӷ����ڲ���ĳ�Ա
		//System.out.println(bi);  //error �ⲿ��ķ���������ֱ�ӷ����ڲ���ĳ�Ա
		
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
