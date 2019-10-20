

import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Vector;

public class Cube
{
	//宽长高,分别对应于X,Y,Z轴
	float width = 10.0f;		
	float length = 10.0f;
	float height = 10.0f;
	
	//几何顶点
	Vertex3d vertex[] = new Vertex3d[8];
	
	//经过透视之后的点
	Point viewPoint[] = new Point[8];
	
	//面的拓扑结构
	Facet facet[] = new Facet[6];
	
	//边的拓扑结构
	Edge edge[] = new Edge[12];
	
	//几何变换的变换矩阵
	Matrix3d transGeometry = new Matrix3d();

	//将8个点光透到地面
	Vertex3d vertex_to_ground[] = new Vertex3d[8];
	
	//立方体是否允许产生阴影
	boolean enable_shadow = false;
	
	public Cube(float width,float length,float height)
	{
		this.width = width;
		this.length = length;
		this.height = height;
		init();
		
	}
	
	private void init()
	{
		float w = this.width / 2.0f;
		float l = this.length / 2.0f;
		float h = this.height / 2.0f;
		
		//x方向为宽度,y方向为长度,z方向高度
		
		vertex[0] = new Vertex3d(-w,-l,-h);
		vertex[1] = new Vertex3d(-w,l,-h);
		vertex[2] = new Vertex3d(-w,l,h);
		vertex[3] = new Vertex3d(-w,-l,h);
		vertex[4] = new Vertex3d(w,-l,-h);
		vertex[5] = new Vertex3d(w,l,-h);
		vertex[6] = new Vertex3d(w,l,h);
		vertex[7] = new Vertex3d(w,-l,h);
		
		//记录每个顶点所属于的面,当然有三个面共同一个顶点
		vertex[0].residence.addElement(new Integer(0));
		vertex[0].residence.addElement(new Integer(2));
		vertex[0].residence.addElement(new Integer(3));
		
		vertex[1].residence.addElement(new Integer(0));
		vertex[1].residence.addElement(new Integer(3));
		vertex[1].residence.addElement(new Integer(4));
		
		vertex[2].residence.addElement(new Integer(1));
		vertex[2].residence.addElement(new Integer(3));
		vertex[2].residence.addElement(new Integer(4));
		
		vertex[3].residence.addElement(new Integer(1));
		vertex[3].residence.addElement(new Integer(2));
		vertex[3].residence.addElement(new Integer(3));
		
		vertex[4].residence.addElement(new Integer(0));
		vertex[4].residence.addElement(new Integer(2));
		vertex[4].residence.addElement(new Integer(5));
		
		vertex[5].residence.addElement(new Integer(0));
		vertex[5].residence.addElement(new Integer(4));
		vertex[5].residence.addElement(new Integer(5));
		
		vertex[6].residence.addElement(new Integer(1));
		vertex[6].residence.addElement(new Integer(4));
		vertex[6].residence.addElement(new Integer(5));
		
		vertex[7].residence.addElement(new Integer(1));
		vertex[7].residence.addElement(new Integer(2));
		vertex[7].residence.addElement(new Integer(5));
		
		
		//依次为底面,顶面,左面,背面,右面,前面:

		facet[0] = new Facet4(0,1,5,4);
		facet[1] = new Facet4(3,7,6,2);
		facet[2] = new Facet4(3,0,4,7);
		facet[3] = new Facet4(0,3,2,1);
		facet[4] = new Facet4(1,2,6,5);
		facet[5] = new Facet4(4,5,6,7);
		
		//构造边对象
		edge[0] = new Edge(0,1,0,3);
		edge[1] = new Edge(1,2,3,4);
		edge[2] = new Edge(2,3,1,3);
		edge[3] = new Edge(3,0,2,3);

		edge[4] = new Edge(3,7,1,2);
		edge[5] = new Edge(2,6,1,4);
		edge[6] = new Edge(1,5,0,4);
		edge[7] = new Edge(0,4,0,2);
		
		edge[8] = new Edge(4,5,0,5);
		edge[9] = new Edge(5,6,4,5);
		edge[10] = new Edge(6,7,1,5);
		edge[11] = new Edge(7,4,2,5);
		
		initFacetNormal();
		vertexNormal();
		
	}
	
	//初始化面的法线.
	public void initFacetNormal()
	{
		facet[0].normal = new Vector3d(0.0f,0.0f,-1.0f);
		facet[1].normal = new Vector3d(0.0f,0.0f,1.0f);
		facet[2].normal = new Vector3d(0.0f,-1.0f,0.0f);
		facet[3].normal = new Vector3d(-1.0f,0.0f,0.0f);
		facet[4].normal = new Vector3d(0.0f,1.0f,0.0f);
		facet[5].normal = new Vector3d(1.0f,0.0f,0.0f);
	}

	//计算顶点法线
	public void vertexNormal()
	{
		for (int i = 0;i < 8;i++)
		{
			int index_0 = ((Integer)(vertex[i].residence.elementAt(0))).intValue();
			int index_1 = ((Integer)(vertex[i].residence.elementAt(1))).intValue();
			int index_2 = ((Integer)(vertex[i].residence.elementAt(2))).intValue();
			
			Vector3d normal = new Vector3d(facet[index_0].normal.x,facet[index_0].normal.y,facet[index_0].normal.z);
			normal = normal.add(facet[index_1].normal);
			normal = normal.add(facet[index_2].normal);
			normal = normal.numberMultiply(1.0f / 3.0f);
			normal.unitize();
			vertex[i].normal = normal;
		}
	}
	
	//设置尺寸大小
	public void setSize(float width,float length,float height)
	{
		this.width = width;
		this.length = length;
		this.height = height;
	}
	
	
	//设置第index个小面颜色
	public void setFacetColor(int index,ColorFloat color)
	{
		ColorFloat clrFloat = new ColorFloat(color.red,color.green,color.blue,color.alpha);
		facet[index].color = clrFloat;
	}
	
	
	//设置第index条边颜色
	public void setEdgeColor(int index,ColorFloat color)
	{
		ColorFloat clrFloat = new ColorFloat(color.red,color.green,color.blue,color.alpha);
		edge[index].color = clrFloat;
	}
	
	//设置第index个顶点颜色
	public void setVertexColor(int index,ColorFloat color)
	{
		ColorFloat clrFloat = new ColorFloat(color.red,color.green,color.blue,color.alpha);
		vertex[index].color = clrFloat;

	}

	//该方法实现几何变换
	
	public void transform(Matrix3d transMatrix)
	{
		//vertex将保存经几何变换之后的点
		for(int i = 0;i < vertex.length;i++)
		{
			
			Vertex3d vTemp = transMatrix.transform(vertex[i]);
			
			vertex[i].x = vTemp.x;
			vertex[i].y = vTemp.y;
			vertex[i].z = vTemp.z;
				
		}
		
		transGeometry.multiply(transMatrix,Matrix3d.RIGHT_MULTIPLIER);
		
		//如果该立方体产生阴影,则应该记录几何变换后的顶点,以便将它们透视到地面上
		if(enable_shadow)
		{
			for(int i = 0;i < 8;i++)
			{
				vertex_to_ground[i] = new Vertex3d(0.0f,0.0f,0.0f);
				vertex_to_ground[i].x = vertex[i].x;
				vertex_to_ground[i].y = vertex[i].y;
				vertex_to_ground[i].z = vertex[i].z;
			}
		}
		
	}


	
	/*
	.这个方法得到经过:
		(1)世界坐标到观察坐标的变换；
		(2)透视投影坐标的变换
	的结果，
	.toViewCoord参数仅仅为一个世界坐标到观察坐标的
		变换变换矩阵，绝不包含几何坐标变换矩阵
	.得到面的法线和面的可见性
	.没有进行线的可见性的处理
	.几何坐标由Cube的transGeometry提供，而
		toViewCoord则由Watcher提供，因为对于一个
		场景，我们只设一个固定的观察者
	*/
	public void perspective(Matrix3d toViewCoord,float screenDistance)
	{
		
		int i =0;

		Vertex3d leftCoord[] = new Vertex3d[8];
		
		//观察变换
		for( i = 0;i < vertex.length ; i++)
				leftCoord[i] = toViewCoord.transform(vertex[i]);
		
		//进行透视
		for(i = 0;i < vertex.length ;i++)
			viewPoint[i] = toViewCoord.perspectiveWatch(leftCoord[i],screenDistance);

		//计算小面的法线和面的可见性.
		simpleVisibilityTest(leftCoord);
	}
	
	/*
	这个经过重载的方法与上一个方法相比，
		功能上多了一个将透视到屏幕上的点进行平移
		的功能，这样，坐标系的(0,0,0)点一定变换到
		屏幕上的viewCenter点。
	这是绘制的基础.
	*/
	
	public void perspective(Matrix3d toViewCoord,float screenDistance,Point viewCenter)
	{
		
		int i =0;
		/*
			.为了在面的可见性测试中也能应用观察坐标系的点,减少重复计算,因而应记录作为
				中间计算量的观察坐标的点
		*/
		Vertex3d leftCoord[] = new Vertex3d[8];
		
		
		//观察变换
		for( i = 0;i < vertex.length ; i++)
				leftCoord[i] = toViewCoord.transform(vertex[i]);
		
		//变换到屏幕坐标系
		for(i = 0;i < vertex.length ;i++)
		{
			viewPoint[i] = toViewCoord.perspectiveWatch(leftCoord[i],screenDistance);
			viewPoint[i].translate(viewCenter.x,viewCenter.y);
		}
	

		//计算小面的法线和面的可见性
		simpleVisibilityTest(leftCoord);
	}
	
	/*
	这个重载的方法,又不相同了
	第一,其计算是逐步完成的,即先计算经过几何变换后的点,
		再计算几何变换后的点在观察坐标系中的点,接着将该点透视到	
		屏幕坐标系,最后进行视口变换
	第二,它支持阴影的绘制,即可以存储几何变换后的点
	第三,效果更好,因为它没有重复计算

	*/
	public void perspective(Matrix3d toViewCoord,ViewFinder viewfinder)
	{
		int i = 0;
		
		Vertex3d leftCoord[] = new Vertex3d[8];
		
		//将几何变换后的点变换到观察坐标系,这时vertex_clone记录经观察变换的点
		for(i = 0;i < 8;i++)
			leftCoord[i] = toViewCoord.transform(vertex[i]);

		
		//变换到屏幕坐标系
		for(i = 0;i < 8;i++)
			viewPoint[i] = toViewCoord.perspectiveWatch(leftCoord[i],viewfinder.screenDistance);
		
		//进行视口变换
		for(i = 0;i < 8;i++)
			viewPoint[i] = viewfinder.viewport(viewPoint[i]);

		//直接传递左手坐标系即观察坐标系的点,进行可见性测试
		
		simpleVisibilityTest(leftCoord);
	}
	


	//简单的可见性测试,应用法线.该方法来自平面方程式法
	public void simpleVisibilityTest(Vertex3d[] leftHandCoord)
	{
		Vertex3d leftCoord[] = new Vertex3d[8];
		int i =0;
		
		//基于左手坐标系
		for( i = 0;i < 8; i++)
			leftCoord[i] = leftHandCoord[i];
		
		for(i = 0;i < 6;i++)
		{
			//计算法线,其实是按右手规则计算向量的叉积
			facet[i].normal = NormalCalculater.normal(
						leftCoord[((Facet4)facet[i]).index[0]],		
						leftCoord[((Facet4)facet[i]).index[1]],
						leftCoord[((Facet4)facet[i]).index[2]]);
			facet[i].visibility = VisibilityTester.tester(facet[i].normal);
		}
	}

	
	public void  render(Graphics g,int renderMode)
	{
		Renderer renderer = new Renderer();
		/*
			.其实,几何顶点坐标这时在绘制物体时的几何体时已不必要了,
				但几何顶点含有绘制属性,比如颜色等,因而还是应该作为一个参数传过去
		*/
		renderer.render(g,viewPoint,facet,edge,vertex,renderMode);
	}
	
}
