public class TestSleep{
	public static void main(String[] args){
		A aa = new A();
		Thread tt = new Thread(aa);
		tt.start();		
	}
}
class A implements Runnable{
	public void run(){ //9��	
	      for (int i=0; i<10; ++i){
		System.out.println(Thread.currentThread().getName() + "   " + i);
		try{
	 	     Thread.sleep(1000); //��  �����Thread.sleep(1000)���׳��쳣,����
                                                                      //�Ľ��в�׽��������9 �ĺ������ throws Exception
		}catch (Exception e){  }
	     }
	}
}
