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
	
	//默认equasl方法比较的是：是否是同一快内存，是返回true，不是返回false，但实际需求通常是不管是否是同一块内存，只要内容一样，不同内存相同内容的类对象调用equals方法返回值也应该是true，所以本程序重写equals方法是十分必要的，否则会导致编译器认为MyKey mk1 = new MyKey(2);    MyKey mk1 = new MyKey(2); mk1和mk2不相等，最终会导致容器中出现了重复元素,即容器中同时出现了mk1 和mk2这两个元素，站在用户的角度，用户会认为容器中出现了重复元素
	@Override
	public boolean equals(Object o){
		return (o instanceof MyKey) && (this.id == ((MyKey)o).id);		
	}
	
	//如果注释掉了这里的hashCode方法，则会导致占用不同内存但是内容一样的两个MyKey对象的hahsCode()返回值是一样的
	@Override
	public int hashCode(){
		return new Integer(id).hashCode(); //已知： Integer it1 = new Integer(22); Integer it2 = new Integer(22);  	则it1.hashCode()的值和it2.hashCode()的值是一样的，可以参见“C:\Documents and Settings\hb\桌面\hashCode\TestHashCode_1.java”
	}	
}