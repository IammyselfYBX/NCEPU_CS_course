class A
{
	private int i;
	public A(int i)
	{
		this.i = i;  //���β� i �����ù��췽�������������������Ǹ��¶����i���ݳ�Ա
	}
	public void show(){
		System.out.println("i = " + this.i);
			//this��ʾ��ǰʱ�����ڵ���show�����Ķ���
			//this����ʡ��
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

