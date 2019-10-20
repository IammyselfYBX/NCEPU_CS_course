
import java.awt.Point;

import java.awt.Color;
import java.util.Vector;

public class Vertex3d extends SubObject
{
	float x = 0.0f;
	float y = 0.0f;
	float z = 0.0f;
	float w = 1.0f;
	Vector3d normal = new Vector3d(1.0f,0.0f,0.0f);
		
	ColorFloat color = new ColorFloat(0.0f,0.0f,0.0f,1.0f);
	
	Vector residence = new Vector(1,1);
	
	boolean visibility = true;
	
	public Vertex3d(float x,float y,float z)
	{
		this.type = 1;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vertex3d(float x,float y,float z,float w)
	{
		this.type = 1;
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	public Vertex3d(float[] vertex)
	{
		this.type = 1;
		x = vertex[0];
		y = vertex[1];
		z = vertex[2];
		w = vertex[3];
	}
	
	public Vertex3d(float[] vertex,ColorFloat color)
	{
		this.type = 1;
		x = vertex[0];
		y = vertex[1];
		z = vertex[2];
		w = vertex[3];
		
		this.color.red = color.red;
		this.color.green = color.green;
		this.color.blue = color.blue;
		this.color.alpha = color.alpha ;

	}
	
	public Vertex3d(float vertex[],Vector3d normal,ColorFloat color)
	{
		this.type = 1;
		x = vertex[0];
		y = vertex[1];
		z = vertex[2];
		w = vertex[3];
		this.normal = normal;
		
		this.color.red = color.red;
		this.color.green = color.green;
		this.color.blue = color.blue;
		this.color.alpha = color.alpha ;
	}
}
