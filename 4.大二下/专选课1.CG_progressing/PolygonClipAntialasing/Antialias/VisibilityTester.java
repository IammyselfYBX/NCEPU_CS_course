
//	可见性测试工具,可以逐步增加可见性测试方法

public class VisibilityTester
{
	boolean visibility = true;
	public VisibilityTester()
	{
	}
	
	public static boolean tester(Vector3d normal)
	{
		Vector3d viewDirection = new Vector3d(0.0f,0.0f,1.0f);
		
		if(normal.dot(viewDirection) > 0.000001f)
			return true;
		else 
			return false;
	}
	
	//更加精确的算法
	public static boolean tester(Vertex3d vertex0,Vertex3d vertex1,Vertex3d vertex2)
	{
		float x = vertex0.x * (vertex1.y * vertex2.z - vertex2.y * vertex1.z);
		float y = vertex1.x * (vertex2.y * vertex0.z - vertex0.y * vertex2.z);
		
		float z = vertex2.x * (vertex0.y * vertex1.z - vertex1.y * vertex0.z);
		
		//前提:视点在(0,0,0)位置
		//利用该点相对于一个平面的取向,可以确定该平面是可见的还是隐藏的.
		
		if((-x - y - z) >= -10.0f)return false;
		
		return true;
		
	}
	
}
