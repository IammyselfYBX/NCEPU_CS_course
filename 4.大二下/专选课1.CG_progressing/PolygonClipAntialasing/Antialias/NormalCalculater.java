public class NormalCalculater
{
	public NormalCalculater()
	{}
	
	public static Vector3d normal(Vertex3d v0,Vertex3d v1,Vertex3d v2)
	{
		Vector3d vector1 = new Vector3d(v1.x - v0.x,v1.y - v0.y,v1.z - v0.z);
		Vector3d vector2 = new Vector3d(v2.x - v0.x,v2.y - v0.y,v2.z - v0.z);
		
		Vector3d vector = vector1.cross(vector2);
		return (vector.unitize());
		
	}
}
