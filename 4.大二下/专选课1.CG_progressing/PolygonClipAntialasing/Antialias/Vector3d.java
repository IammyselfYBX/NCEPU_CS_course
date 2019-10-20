
//向量类

public class Vector3d
{
	float x = 0.0f;
	float y = 0.0f;
	float z = 0.0f;
	
	public Vector3d(float x,float y,float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector3d(float vector[])
	{
		x = vector[0];
		y = vector[1];
		z = vector[2];
	}
	
	public Vector3d(Vertex3d vertex)
	{
		float w = vertex.w;
		
		float sign = (w < 0.0f) ? -1.0f : 1.0f;
		
		if(Math.abs(w) < 0.000001f)w = sign * 0.000001f;
		x = vertex.x / w;
		y = vertex.y / w;
		z = vertex.z / w;
	}
	
	public Vector3d add(Vector3d vector)
	{
		return (new Vector3d(x + vector.x, y + vector.y,z + vector.z));
	}
	
	public Vector3d add(float x,float y,float z)
	{
		return (new Vector3d(this.x + x, this.y + y,this.z + z));
	}
	
	public Vector3d subtract(Vector3d vector)
	{
		return (new Vector3d(x - vector.x, y - vector.y,z - vector.z));
	}
	
	public Vector3d subtract(float x,float y,float z)
	{
		return (new Vector3d(this.x - x, this.y - y,this.z - z));
	}
	
	public float dot(Vector3d vector)
	{
		return (x * vector.x + y * vector.y + z * vector.z);
	}
	
	public Vector3d cross(Vector3d vector)
	{
		float xcross = y * vector.z - z * vector.y;
		float ycross = z * vector.x - x * vector.z;
		float zcross = x * vector.y - y * vector.x;
		
		return (new Vector3d(xcross,ycross,zcross));
	}
	
	public Vector3d  numberMultiply(float s)
	{
		return (new Vector3d(s * x,s * y,s * z));
	}
	
	//
	public float mag()
	{
		return ((float)(Math.sqrt(x * x + y * y + z * z)));
	}
	
	public Vector3d unitize()
	{
		float mag = this.mag();
		if(mag <= 0.000001f)mag = 1.0f;
		
		//return (new Vector3d(x / mag,y / mag,z / mag));
		
		x /= mag;
		y /= mag;
		z /= mag;
		
		return this;
		
	}
	
	public float distance(Vector3d vector)
	{
		Vector3d v = null;
		v = vector.subtract(this);
		return (v.mag());
	}
	
	//向量绕Z轴旋转
	public Vector3d rotateZ(float theta)
	{
		float rad = (float)(Math.PI / 180.0);
		theta *= rad;
		
		float xr = (float)(x * Math.cos(theta) - y * Math.sin(theta));
		float yr = (float)(x * Math.sin(theta) + y * Math.cos(theta));
		
		x = xr;
		y = yr;
		return this;
		
	}
	
	//向量绕Y轴旋转
	public Vector3d rotateY(float theta)
	{
		float rad = (float)(Math.PI / 180.0);
		theta *= rad;
		
		float xr = (float)(x * Math.cos(theta) + z * Math.sin(theta));
		float zr = (float)(-x * Math.sin(theta) + z * Math.cos(theta));
		
		x = xr;
		z = zr;
		return this;
		
	}
	
	//向量绕X轴旋转
	public Vector3d rotateX(float theta)
	{
		float rad = (float)(Math.PI / 180.0);
		theta *= rad;
		
		float yr = (float)(y * Math.cos(theta) - z * Math.sin(theta));
		float zr = (float)(y * Math.sin(theta) + z * Math.cos(theta));
		
		y = yr;
		z = zr;
		return this;
		
	}
	
	//求出this向量绕任意给定的单位向量(x0,y0,z0)旋转一个角度的结果
	public Vector3d rotate(float theta,float x0,float y0,float z0)
	{
		//给定的向量
		Vector3d vector = new Vector3d(x0,y0,z0);
		vector.unitize();
		
		//给定向量的方向数
		float a = vector.x;
		float b = vector.y;
		float c = vector.z;
		
		float v = (float)Math.sqrt(c * c + b * b);
		
		//如果 v=0 事实上就是绕X轴旋转,此时 a 有可能为 +1.0或 -1.0
		if(v <= 0.000001f)return (this.rotateX(a * theta));
		
		float c_v = c / v;
		float b_v = b / v;
		
		
		float y1 = y * c_v - z * b_v;
		float z1 = y * b_v + z * c_v;
		
		float x2 = x * v - z1 * a;
		float z2 = x * a + z1 * v;

		float x3 = (float)(x2 * Math.cos(theta) - y1 * Math.sin(theta));
		float y3 = (float)(x2 * Math.sin(theta) + y1 * Math.cos(theta));

		float x4 = x3 * v + z2 * a;
		float z4 = -x3 * a + z2 * v;
		
		x = x4;
		y = y3 * c_v + z4 * b_v;
		z = -y3 * b_v + z4 * c_v;

		return this;
	}

	//求出绕任意给定的单位向量vector旋转一个角度的结果
	public Vector3d rotate(float theta,Vector3d vector)
	{
		//给定的向量
		Vector3d vector_unit = new Vector3d(vector.x,vector.y,vector.z);
		vector_unit.unitize();
		
		//给定的向量的方向数
		float a = vector_unit.x;
		float b = vector_unit.y;
		float c = vector_unit.z;
		
		float v = (float)Math.sqrt(c * c + b * b);
		
		//如果 v = 0 事实上就是绕X轴旋转,此时 a 有可能为 +1.0或 -1.0
		if(v <= 0.000001f)return (this.rotateX(a * theta));
		
		float c_v = c / v;
		float b_v = b / v;
		
		
		float y1 = y * c_v - z * b_v;
		float z1 = y * b_v + z * c_v;
		
		float x2 = x * v - z1 * a;
		float z2 = x * a + z1 * v;

		float x3 = (float)(x2 * Math.cos(theta) - y1 * Math.sin(theta));
		float y3 = (float)(x2 * Math.sin(theta) + y1 * Math.cos(theta));

		float x4 = x3 * v + z2 * a;
		float z4 = -x3 * a + z2 * v;
		
		x = x4;
		y = y3 * c_v + z4 * b_v;
		z = -y3 * b_v + z4 * c_v;

		return this;
	}

	//获取变换后的点,一个方便的工具工具
	public Vector3d transform(Matrix3d matrix)
	{
		//平移变换不得进入一个与自由向量相关联的变换矩阵
		float x_x = x * matrix.a00 + y * matrix.a10 + z * matrix.a20;
		float y_y = x * matrix.a01 + y * matrix.a11 + z * matrix.a21;
		float z_z = x * matrix.a02 + y * matrix.a12 + z * matrix.a22;
		
		x = x_x;
		y = y_y;
		z = z_z;
		this.unitize();
		return this;
	}
}
