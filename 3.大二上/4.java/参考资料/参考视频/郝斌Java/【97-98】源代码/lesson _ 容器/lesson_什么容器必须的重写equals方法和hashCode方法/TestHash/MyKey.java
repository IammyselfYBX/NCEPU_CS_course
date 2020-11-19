public class MyKey implements Comparable{
	private final int id;
	
	public MyKey(int id){
		this.id = id;	
	}	
	
	public int getId(){
		return id;	
	}
	
	@Override
	public int compareTo(Object o){
		return this.id - ((MyKey)o).id;		
	}
	
	//Ĭ��equasl�����Ƚϵ��ǣ��Ƿ���ͬһ���ڴ棬�Ƿ���true�����Ƿ���false����ʵ������ͨ���ǲ����Ƿ���ͬһ���ڴ棬ֻҪ����һ������ͬ�ڴ���ͬ���ݵ���������equals��������ֵҲӦ����true�����Ա�������дequals������ʮ�ֱ�Ҫ�ģ�����ᵼ�±�������ΪMyKey mk1 = new MyKey(2);    MyKey mk1 = new MyKey(2); mk1��mk2����ȣ����ջᵼ�������г������ظ�Ԫ��,��������ͬʱ������mk1 ��mk2������Ԫ�أ�վ���û��ĽǶȣ��û�����Ϊ�����г������ظ�Ԫ��
	@Override
	public boolean equals(Object o){
		return (o instanceof MyKey) && (this.id == ((MyKey)o).id);		
	}
	
	//���ע�͵��������hashCode��������ᵼ��ռ�ò�ͬ�ڴ浫������һ��������MyKey�����hahsCode()����ֵ��һ����
	@Override
	public int hashCode(){
		return new Integer(id).hashCode(); //��֪�� Integer it1 = new Integer(22); Integer it2 = new Integer(22);  	��it1.hashCode()��ֵ��it2.hashCode()��ֵ��һ���ģ����Բμ���C:\Documents and Settings\hb\����\hashCode\TestHashCode_1.java��
	}	
}