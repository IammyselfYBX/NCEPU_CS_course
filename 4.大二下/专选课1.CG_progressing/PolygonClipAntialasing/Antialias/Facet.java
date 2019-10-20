public class Facet extends SubObject 
{
	//面的颜色向量
	ColorFloat color = new ColorFloat(0.0f,0.0f,0.0f,1.0f);
	
	//法线
	Vector3d normal = new Vector3d(1.0f,0.0f,0.0f);
	
	//面的可见性
	boolean visibility = true;

	public Facet()
	{
	}
}
