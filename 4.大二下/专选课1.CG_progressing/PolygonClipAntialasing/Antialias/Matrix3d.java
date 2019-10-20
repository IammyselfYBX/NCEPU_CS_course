import java.awt.Point;

//作复合变换时,采用右乘

public class Matrix3d
{
	public static final int LEFT_MULTIPLIER = 0; 
	public static final int RIGHT_MULTIPLIER = 1;

	float a00,a01,a02,a03;
	float a10,a11,a12,a13;
	float a20,a21,a22,a23;
	float a30,a31,a32,a33;

	public Matrix3d()
	{
		identity();	
	}
	
	//矩阵单位化
	public void identity()
	{
		a00 = 1.0f; a01 = 0.0f; a02 = 0.0f; a03 = 0.0f;
		a10 = 0.0f; a11 = 1.0f; a12 = 0.0f; a13 = 0.0f;
		a20 = 0.0f; a21 = 0.0f; a22 = 1.0f; a23 = 0.0f;
		a30 = 0.0f; a31 = 0.0f; a32 = 0.0f; a33 = 1.0f;
	}
	
	//测试两个矩阵是否相等
	public boolean isEqual(Matrix3d matrix)
	{
		if((matrix.a00 <= a00 + 0.000001f) && (matrix.a00 >= a00 - 0.000001f) &&
		   (matrix.a01 <= a01 + 0.000001f) && (matrix.a01 >= a01 - 0.000001f) &&
		   (matrix.a02 <= a02 + 0.000001f) && (matrix.a02 >= a02 - 0.000001f) &&
		   (matrix.a03 <= a03 + 0.000001f) && (matrix.a03 >= a03 - 0.000001f) &&
		   
		   (matrix.a10 <= a10 + 0.000001f) && (matrix.a10 >= a10 - 0.000001f) &&
		   (matrix.a11 <= a11 + 0.000001f) && (matrix.a11 >= a11 - 0.000001f) &&
		   (matrix.a12 <= a12 + 0.000001f) && (matrix.a12 >= a12 - 0.000001f) &&
		   (matrix.a13 <= a13 + 0.000001f) && (matrix.a13 >= a13 - 0.000001f) &&
		   
		   (matrix.a20 <= a20 + 0.000001f) && (matrix.a20 >= a20 - 0.000001f) &&
		   (matrix.a21 <= a21 + 0.000001f) && (matrix.a21 >= a21 - 0.000001f) &&
		   (matrix.a22 <= a22 + 0.000001f) && (matrix.a22 >= a22 - 0.000001f) &&
		   (matrix.a23 <= a23 + 0.000001f) && (matrix.a23 >= a23 - 0.000001f) &&
		   
		   (matrix.a30 <= a30 + 0.000001f) && (matrix.a30 >= a30 - 0.000001f) &&
		   (matrix.a31 <= a31 + 0.000001f) && (matrix.a31 >= a31 - 0.000001f) &&
		   (matrix.a32 <= a32 + 0.000001f) && (matrix.a32 >= a32 - 0.000001f) &&
		   (matrix.a33 <= a33 + 0.000001f) && (matrix.a33 >= a33 - 0.000001f))
				return true;
		
		return false;
	   
	}
	
	
	/*
		诸变换均在世界坐标系中完成,
	*/
	
	//平移
	public  void translate(float x,float y,float z)
	{
		a30 += x;
		a31 += y;
		a32 += z;
	}
	
	//缩放
	public void scale(float factor)
	{
		a00 *= factor;
		a11 *= factor;
		a22 *= factor;
	}
	
	//缩放
	public void scale(float sx,float sy,float sz)
	{
		a00 *= sx;
		a11 *= sy;
		a22 *= sz;
	}
	
	//缩放
	public void scale(float x,float y,float z,float sx,float sy,float sz)
	{
		/*
		Matrix3d transMatrix = new Matrix3d();
			
		transMatrix.a00 = sx;
		transMatrix.a11 = sy;
		transMatrix.a22 = sz;
		
		transMatrix.a30 = (1.0 - sx) * x;
		transMatrix.a31 = (1.0 - sy) * y;
		transMatrix.a32 = (1.0 - sz) * z;
		this.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);		
		
		*/
		
		//相对点的缩放,
		//第一步,将坐标系平移至相对点;
		//第二步,进行缩放变换;
		//第三步,将坐标系平移回原来的位置
		
		Matrix3d transMatrix = new Matrix3d();
		transMatrix.translate(-x,-y,-z);
		
		//只带一个参数的scale方法只改变矩阵主对角线上的元素,因而这里应使用矩阵乘法
		Matrix3d scaleMatrix = new Matrix3d();
		scaleMatrix.scale(sx,sy,sz);
		transMatrix.multiply(scaleMatrix,Matrix3d.RIGHT_MULTIPLIER);		
		
		transMatrix.translate(x,y,z);
		this.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);		
		
	}
	
	//缩放
	public void scale(Vertex3d vertex,float sx,float sy,float sz)
	{
		Matrix3d transMatrix = new Matrix3d();
		transMatrix.translate(-vertex.x,-vertex.y,-vertex.z);
		
		//只带一个参数的scale方法只改变矩阵主对角线上的元素,因而这里应使用矩阵乘法
		Matrix3d scaleMatrix = new Matrix3d();
		scaleMatrix.scale(sx,sy,sz);
		
		transMatrix.multiply(scaleMatrix,Matrix3d.RIGHT_MULTIPLIER);		
		
		transMatrix.translate(vertex.x,vertex.y,vertex.z);
		this.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);		
	}
	
	//绕Z轴旋转
	public void rotateZ(float theta)
	{
		float rad = (float)(Math.PI / 180.0);
		theta *= rad; 
		Matrix3d transMatrix = new Matrix3d();
		transMatrix.a00 = (float)Math.cos(theta);
		transMatrix.a01 = (float)Math.sin(theta);
		
		transMatrix.a10 = (float)(-1.0 * Math.sin(theta));
		transMatrix.a11 = (float)Math.cos(theta);
		this.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);		
	}
	
	//相对给定点绕Z轴旋转
	public void rotateZ(float x,float y,float z,float theta)
	{
		Matrix3d transMatrix = new Matrix3d();
		transMatrix.translate(-x,-y,-z);
		transMatrix.rotateZ(theta);
		transMatrix.translate(x,y,z);
		this.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);		
	}
	
	//相对给定点绕Z轴旋转,对于相对X,Y轴的解释类同
	public void rotateZ(Vertex3d vertex,float theta)
	{
		Matrix3d transMatrix = new Matrix3d();
		transMatrix.translate(-vertex.x,-vertex.y,-vertex.z);
		transMatrix.rotateZ(theta);
		transMatrix.translate(vertex.x,vertex.y,vertex.z);
		this.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);		

	}
	
	//绕Y轴旋转
	public void rotateY(float theta)
	{
		float rad = (float)(Math.PI / 180.0);
		theta *= rad;
		Matrix3d transMatrix = new Matrix3d();
		transMatrix.a00 = (float)Math.cos(theta);
		transMatrix.a02 = (float)(-1.0 * Math.sin(theta));
		
		transMatrix.a20 = (float)Math.sin(theta);
		transMatrix.a22 = (float)Math.cos(theta);
		this.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);		
	}
	
	//绕Y轴旋转
	public void rotateY(float x,float y,float z,float theta)
	{
		Matrix3d transMatrix = new Matrix3d();
		transMatrix.translate(-x,-y,-z);
		transMatrix.rotateY(theta);
		transMatrix.translate(x,y,z);
		this.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);		
	}
	
	//绕Y轴旋转
	public void rotateY(Vertex3d vertex,float theta)
	{
		Matrix3d transMatrix = new Matrix3d();
		transMatrix.translate(-vertex.x,-vertex.y,-vertex.z);
		transMatrix.rotateY(theta);
		transMatrix.translate(vertex.x,vertex.y,vertex.z);
		this.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);		
	}
	
	//绕X轴旋转
	public void rotateX(float theta)
	{
		float rad = (float)(Math.PI / 180.0);
		theta *= rad;
		Matrix3d transMatrix = new Matrix3d();
		transMatrix.a11 = (float)Math.cos(theta);
		transMatrix.a12 = (float)Math.sin(theta);
		
		transMatrix.a21 = (float)(-1.0 * Math.sin(theta));
		transMatrix.a22 = (float)Math.cos(theta);
		this.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);		
	}
	
	//绕X轴旋转
	public void rotateX(float x,float y,float z,float theta)
	{
		Matrix3d transMatrix = new Matrix3d();
		transMatrix.translate(-x,-y,-z);
		transMatrix.rotateX(theta);
		transMatrix.translate(x,y,z);
		this.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);
	}
	
	//绕X轴旋转
	public void rotateX(Vertex3d vertex,float theta)
	{
		Matrix3d transMatrix = new Matrix3d();
		transMatrix.translate(-vertex.x,-vertex.y,-vertex.z);
		transMatrix.rotateX(theta);
		transMatrix.translate(vertex.x,vertex.y,vertex.z);
		this.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);
	}
	
	//相对任意轴旋转
	public void rotate(Vertex3d vertex,Vector3d axis,float theta)
	{
		float rad = (float)(Math.PI / 180.0);
		theta *= rad;
		
		Vector3d vector = new Vector3d(axis.x,axis.y,axis.z);
		vector.unitize();
		float a = vector.x;
		float b = vector.y;
		float c = vector.z;
		
		float mag = b * b + c * c;
		Matrix3d transMatrix = new Matrix3d();
		if(mag <= 0.000001f)
		{
			transMatrix.translate(-vertex.x,-vertex.y,-vertex.z);
			
			//此时,绕X轴旋转
			theta *= a;	//because a = 1.0 or -1.0
			transMatrix.rotateX(vertex,theta);
			
			transMatrix.translate(vertex.x,vertex.y,vertex.z);
			this.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);		
			
			return;
		}
		
		/*
		第一步,将坐标系平移至点vertex;
		第二步，AB及其在yoz平面的投影线所构成的平面绕x轴旋转，角度为
				AB及其在yoz平面的投影线与z轴之夹角；
		第三步，将AB绕y轴旋转角度;
		第四步，将点绕z轴绕转theta;
		第五步至第七步，分别作第三至第一步的逆变换。
		
		*/
		Matrix3d trans = new Matrix3d();
		mag = (float)Math.sqrt(mag);
		transMatrix.identity();
		transMatrix.translate(-vertex.x,-vertex.y,-vertex.z);
		
		
		//rotate X ,the cos and sin of the angle
		trans.a11 = c / mag;	trans.a12 = b / mag;
		trans.a21 = - b / mag;	trans.a22 = c / mag;
		
		transMatrix.multiply(trans,Matrix3d.RIGHT_MULTIPLIER);
		
		trans.identity();
		
		//rotate Y ,the cos and sin of the angle
		trans.a00 = mag;	trans.a02 = a;
		trans.a20 = -a;		trans.a22 = mag;
		transMatrix.multiply(trans,Matrix3d.RIGHT_MULTIPLIER);
		transMatrix.rotateZ(theta);
		
		
		trans.identity();
		trans.a00 = mag;	trans.a02 = -a;
		trans.a20 = a;		trans.a22 = mag;
		transMatrix.multiply(trans,Matrix3d.RIGHT_MULTIPLIER);
		
		trans.identity();
		trans.a11 = c / mag;	trans.a12 = -b / mag;
		trans.a21 = b / mag;	trans.a22 = c / mag;
		
		transMatrix.multiply(trans,Matrix3d.RIGHT_MULTIPLIER);
		transMatrix.translate(vertex.x,vertex.y,vertex.z);
		this.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);		
	}
	
	//相对X轴错切
	public void skewX(float sy, float sz)
	{
		Matrix3d transMatrix = new Matrix3d();
		transMatrix.a10 = sy;
		transMatrix.a20 = sz;
		
		this.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);		
	}
	
	//相对X轴错切
	public void skewX(float x,float y,float z,float sy, float sz)
	{
		Matrix3d transMatrix = new Matrix3d();
		transMatrix.translate(-x,-y,-z);
		transMatrix.skewX(sy,sz);
		transMatrix.translate(x,y,z);
		this.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);		
		
	}
	
	//相对Y轴错切
	public void skewX(Vertex3d vertex,float sy, float sz)
	{
		Matrix3d transMatrix = new Matrix3d();
		transMatrix.translate(-vertex.x,-vertex.y,-vertex.z);
		transMatrix.skewX(sy,sz);
		transMatrix.translate(vertex.x,vertex.y,vertex.z);
		this.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);		
		
	}
	
	//相对Y轴错切
	public void skewY(float sx, float sz)
	{
		Matrix3d transMatrix = new Matrix3d();
		transMatrix.a01 = sx;
		transMatrix.a21 = sz;
		
		this.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);		
	}
	
	//相对Y轴错切
	public void skewY(float x,float y,float z,float sx, float sz)
	{
		Matrix3d transMatrix = new Matrix3d();
		transMatrix.translate(-x,-y,-z);
		transMatrix.skewY(sx,sz);
		transMatrix.translate(x,y,z);
		this.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);		
		
	}
	
	//相对Z轴错切
	public void skewY(Vertex3d vertex,float sx, float sz)
	{
		Matrix3d transMatrix = new Matrix3d();
		transMatrix.translate(-vertex.x,-vertex.y,-vertex.z);
		transMatrix.skewY(sx,sz);
		transMatrix.translate(vertex.x,vertex.y,vertex.z);
		this.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);		
		
	}
	
	//相对Z轴错切
	public void skewZ(float sx, float sy)
	{
		Matrix3d transMatrix = new Matrix3d();
		transMatrix.a02 = sx;
		transMatrix.a12 = sy;
		
		this.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);		
	}
	
	//相对Z轴错切
	public void skewZ(float x,float y,float z,float sx, float sy)
	{
		Matrix3d transMatrix = new Matrix3d();
		transMatrix.translate(-x,-y,-z);
		transMatrix.skewZ(sx,sy);
		transMatrix.translate(x,y,z);
		this.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);		
		
	}
	
	//相对Z轴错切
	public void skewZ(Vertex3d vertex,float sx, float sy)
	{
		Matrix3d transMatrix = new Matrix3d();
		transMatrix.translate(-vertex.x,-vertex.y,-vertex.z);
		transMatrix.skewZ(sx,sy);
		transMatrix.translate(vertex.x,vertex.y,vertex.z);
		this.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);		
	}
	
	//相对世界坐标XOY平面反射
	public void reflexXOY()
	{
		Matrix3d transMatrix = new Matrix3d();
		transMatrix.scale(1.0f,1.0f,-1.0f);

		this.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);
	}
	
	//相对YOZ平面反射
	public void reflexYOZ()
	{
		Matrix3d transMatrix = new Matrix3d();
		transMatrix.scale(-1.0f,1.0f,1.0f);

		this.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);
	}
	
	//相对ZOX平面反射
	public void reflexZOX()
	{
		Matrix3d transMatrix = new Matrix3d();
		transMatrix.scale(1.0f,-1.0f,1.0f);

		this.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);
	}
	
	//相对X轴反射
	public void reflexX()
	{
		Matrix3d transMatrix = new Matrix3d();
		transMatrix.scale(1.0f,-1.0f,-1.0f);

		this.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);
	}
	
	//相对Y轴反射
	public void reflexY()
	{
		Matrix3d transMatrix = new Matrix3d();
		transMatrix.scale(-1.0f,1.0f,-1.0f);

		this.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);
	}
	
	//相对Z轴反射
	public void reflexZ()
	{
		Matrix3d transMatrix = new Matrix3d();
		transMatrix.scale(-1.0f,-1.0f,1.0f);

		this.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);
	}
	
	//相对世界坐标原点反射
	public void reflexO()
	{
		Matrix3d transMatrix = new Matrix3d();
		transMatrix.scale(-1.0f,-1.0f,-1.0f);
		this.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);
	}
	
	//变换矩阵置换
	public void replace(Matrix3d matrix)
	{
		this.identity();
		this.multiply(matrix,Matrix3d.RIGHT_MULTIPLIER);		
	}
	
	//矩阵乘法,矩阵乘法不满足交换律
	public void multiply(Matrix3d matrix,int position)
	{
		Matrix3d A = null;
		Matrix3d B = null;
		
		if(position == Matrix3d.LEFT_MULTIPLIER)
		{
			A = matrix;
			B = this;
		}
		else if(position == Matrix3d.RIGHT_MULTIPLIER )
		{
			A = this;
			B = matrix;
		}
		
		float c00 = A.a00 * B.a00 + A.a01 * B.a10 + A.a02 * B.a20;
		float c01 = A.a00 * B.a01 + A.a01 * B.a11 + A.a02 * B.a21;
		float c02 = A.a00 * B.a02 + A.a01 * B.a12 + A.a02 * B.a22;
		
		float c10 = A.a10 * B.a00 + A.a11 * B.a10 + A.a12 * B.a20;
		float c11 = A.a10 * B.a01 + A.a11 * B.a11 + A.a12 * B.a21;
		float c12 = A.a10 * B.a02 + A.a11 * B.a12 + A.a12 * B.a22;
		
		float c20 = A.a20 * B.a00 + A.a21 * B.a10 + A.a22 * B.a20;
		float c21 = A.a20 * B.a01 + A.a21 * B.a11 + A.a22 * B.a21;
		float c22 = A.a20 * B.a02 + A.a21 * B.a12 + A.a22 * B.a22;
		
		float c30 = A.a30 * B.a00 + A.a31 * B.a10 + A.a32 * B.a20 + B.a30;
		float c31 = A.a30 * B.a01 + A.a31 * B.a11 + A.a32 * B.a21 + B.a31;
		float c32 = A.a30 * B.a02 + A.a31 * B.a12 + A.a32 * B.a22 + B.a32;
		
		a00 = c00;	a01 = c01;	a02 = c02;
		a10 = c10;	a11 = c11;	a12 = c12;
		a20 = c20;	a21 = c21;	a22 = c22;
		a30 = c30;	a31 = c31;	a32 = c32;
	}

	//从世界坐标到观察坐标的变换矩阵
	public void toViewCoordinate(float theta,float phi,float r)
	{
		float rad = (float)(Math.PI / 180.0);
		float thta = theta * rad;
		float fai = phi * rad;
		
		Matrix3d transMatrix = new Matrix3d();
		float x = (float)(r * Math.cos(fai) * Math.cos(thta));
		float y = (float)(r * Math.cos(fai) * Math.sin(thta));
		float z = (float)(r * Math.sin(fai));
		
		transMatrix.translate(-x,-y,-z);
		transMatrix.rotateZ(90.0f - theta);
		transMatrix.rotateX(-90.0f - phi);
		
		Matrix3d toLeft = new Matrix3d();
		toLeft.a00 = -1.0f;
		transMatrix.multiply(toLeft,Matrix3d.RIGHT_MULTIPLIER);		
		
		/*
		//由于只改变主线上的元素,所以用这条语句来代替上述三条语句将会引起错误
		transMatrix.scale(-1.0f,1.0f,1.0f);
		*/
		
		this.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);		
	}

	//获取变换后的点,一个方便的工具工具
	public Vertex3d transform(Vertex3d vertex)
	{
		float x = vertex.x * a00 + vertex.y * a10 + vertex.z * a20 + a30;
		float y = vertex.x * a01 + vertex.y * a11 + vertex.z * a21 + a31;
		float z = vertex.x * a02 + vertex.y * a12 + vertex.z * a22 + a32;
		
		return (new Vertex3d(x,y,z));
	}
	
	//viewDistance为观察点至屏幕坐标系的原点的距离
	public Point perspective(Vertex3d vertex,float viewDistance)
	{
		Vertex3d leftCoord = this.transform(vertex);
		
		float xe = leftCoord.x;
		float ye = leftCoord.y;
		float ze = leftCoord.z;

		float sign = 1.0f;
		if(ze < 0.0f)sign = -1.0f;
		if(Math.abs(ze) <= 0.000001f) ze = sign * 0.0001f;
		
		int xs = (int)(xe * viewDistance / ze);
		int ys = (int)(ye * viewDistance / ze);
		
		ys = -ys;
		
		return (new Point(xs,ys));
	}
	
	/*
		.perspectiveWatch()----该方法透视投影观察坐标系下的点
		.vertex为观察坐标系下的一个点.
	*/
	public Point perspectiveWatch(Vertex3d vertex,float viewDistance)
	{
			
		float xe = vertex.x;
		float ye = vertex.y;
		float ze = vertex.z;

		float sign = 1.0f;
		if(ze < 0.0f)sign = -1.0f;
		if(Math.abs(ze) <= 0.000001f) ze = sign * 0.0001f;
		
		int xs = (int)(xe * viewDistance / ze);
		int ys = (int)(ye * viewDistance / ze);
		
		ys = -ys;
		
		return (new Point(xs,ys));
	}
	
	
	
}
