import java.awt.*;

public class Renderer
{
	public static final int RENDER_VERTICES = 0;
	public static final int RENDER_WIRE = 1;
	public static final int RENDER_WIRE_LIGHTED = 2;
	public static final int RENDER_FLAT = 3;
	public static final int RENDER_GOURAUD_SMOOTH = 4;
	
	public static final int DISABLE_LIGHTING = 0;
	public static final int ENABLE_LIGHTING = 1;
	
	
	public Renderer()
	{
		
	}
	
	/*
	.point----为几何顶点的透视点,为屏幕坐标(经过平移);
	.facet----面的拓扑结构;
	.edge-----为线的拓扑结构;
	.renderMode-----为绘制模式:线框型或刻板面型	或Gouraud光滑明暗着色模式
	.此着色类现在还没有处理光照和材质问题
	*/
	
	public void render(Graphics g,Point[] point,Facet[] facet,Edge[] edge,Vertex3d[] vertex,int renderMode)
	{
		if(renderMode == RENDER_VERTICES)
		{
			render_vertices(g,point,vertex);
			return;
		}
		else if(renderMode == RENDER_WIRE)
		{
			this.render_wire(g, point,edge);
			return;
		}
		else if(renderMode == RENDER_WIRE_LIGHTED)
		{
			this.render_wire(g,point,edge,vertex);
			return;
		}
		else if((renderMode == RENDER_FLAT) || (renderMode == RENDER_GOURAUD_SMOOTH))
		{
			key_Matte(g,point,facet);	
			this.render_solid(g,point,facet,vertex,renderMode);
		}
		
	}
	
	//绘制顶点模型
	public void render_vertices(Graphics g,Point[] point,Vertex3d[] vertex)
	{
		Color colorOld = g.getColor();
		for(int i = 0; i < point.length;i++)
		{
			Color color = new Color(vertex[i].color.red,vertex[i].color.green,vertex[i].color.blue);
			g.setColor(color);
			g.drawLine(point[i].x,point[i].y,point[i].x,point[i].y);
		}
		g.setColor(colorOld);
	}
	
	
	//绘制线型体
	public void render_wire(Graphics g,Point[] point,Edge[] edge)
	{
		Color colorOld = g.getColor();
		for(int i = 0; i < edge.length;i++)
		{
			
			if(edge[i].visibility)
			{
				Color color = new Color(edge[i].color.red,
							edge[i].color.green,edge[i].color.blue);
				g.setColor(color);
			
				g.drawLine(point[edge[i].index[0]].x,
					   point[edge[i].index[0]].y,
					   point[edge[i].index[1]].x,
					   point[edge[i].index[1]].y);
				
			}
		}
		g.setColor(colorOld);
	}

	//绘制线型体,线的颜色由两个顶点的颜色来决定,因而可以支持光照
	public void render_wire(Graphics g,Point[] point,Edge[] edge,Vertex3d[] vertex)
	{
		Color colorOld = g.getColor();
		for(int i = 0; i < edge.length;i++)
		{
						
			if(edge[i].visibility)
			{
				float color0[] = {vertex[edge[i].index[0]].color.red,
								vertex[edge[i].index[0]].color.green,
								vertex[edge[i].index[0]].color.blue };
				
				float color1[] = {vertex[edge[i].index[1]].color.red,
								vertex[edge[i].index[1]].color.green,
								vertex[edge[i].index[1]].color.blue };
				
				LinePrimitive lineTool = new LinePrimitive();
				
				lineTool.setColor(color0,color1);
				
				lineTool.lineLighted(g,
						point[edge[i].index[0]].x,
					   point[edge[i].index[0]].y,
					   point[edge[i].index[1]].x,
					   point[edge[i].index[1]].y);
			}
		}
		g.setColor(colorOld);
	}

	/*
		.同时适用于有限单元化为四边形和三角形的小面
		.程序编制略显冗长,但它仅适用于单一的四边形和三角形序列,
			也适用于二者组成的混合序列
	*/
	
	public void render_solid(Graphics g,Point[] point,Facet[] facet,Vertex3d[] vertex,int renderMode)
	{
		
		Color colorOld = g.getColor();
		for(int i = 0; i < facet.length;i++)
		{	
			int type = facet[i].type;
			
			/*
			.由于Facet3和Facet4类的对象之间不能进行相互转化,
				所以我们不得不重复地书写几乎同样的代码
			*/
			
			Facet3 facet_3 = new Facet3(0,0,0);
			Facet4 facet_4 = new Facet4(0,0,0,0);
			
			if(type == 3)
			{
				facet_3 = (Facet3)facet[i];
			
				//如果这个小面是可见的，就将它绘制出来
				if(facet_3.visibility)
				{
					//如果是Flat着色模式,
					if(renderMode == RENDER_FLAT)
					{
						Polygon polygon = new Polygon();
			
			
						for(int j = 0;j < facet_3.index.length;j++)
						{
							polygon.addPoint(point[facet_3.index[j]].x,
											 point[facet_3.index[j]].y);
											 
						}
					
						//只是保证它为一个环状,该语句不是绝对必要
						polygon.addPoint(point[facet_3.index[0]].x,
									point[facet_3.index[0]].y);
					
						//设置小面颜色，在这里我们采用面的颜色，而不是采用三角形的第一个顶点的颜色.
						
						Color color = new Color(facet_3.color.red,
												facet_3.color.green,
												facet_3.color.blue );
						
						
						g.setColor(color);
					
						g.fillPolygon(polygon);
					}
					
					//如果是Gouraud着色模式
					else if(renderMode == RENDER_GOURAUD_SMOOTH)
					{
						TrianglePrimitive triFacet = new TrianglePrimitive(
									point[facet_3.index[0]],
									point[facet_3.index[1]],
									point[facet_3.index[2]]);
					
						//几何顶点只传递了颜色信息,此时,顶点的几何数据并不需要
					
						float color0[] = vertex[facet_3.index[0]].color.getRGB();
						float color1[] = vertex[facet_3.index[1]].color.getRGB();
						float color2[] = vertex[facet_3.index[2]].color.getRGB();
						
						
						triFacet.setColor(color0,color1,color2);
						
						triFacet.fillTriangle(g,BasicPrimitive.FILL_GOURAUD_SMOOTH );
					}
				}
			}
			if(type == 4)
			{
				facet_4 = (Facet4)facet[i];
			
				if(facet_4.visibility)
				{
					if(renderMode == RENDER_FLAT)
					{
						Polygon polygon = new Polygon();
			
						for(int j = 0;j < facet_4.index.length;j++)
						{
							polygon.addPoint(point[facet_4.index[j]].x,
											 point[facet_4.index[j]].y);
											 
						}
					
						polygon.addPoint(point[facet_4.index[0]].x,
									point[facet_4.index[0]].y);
					
					
						Color color = new Color(facet_4.color.red,
												facet_4.color.green,
												facet_4.color.blue);
						
												
						g.setColor(color);
					
						g.fillPolygon(polygon);

					
					}
					else if(renderMode == RENDER_GOURAUD_SMOOTH)
					{
						TrianglePrimitive triFacet_1 = new TrianglePrimitive(
									point[facet_4.index[0]],
									point[facet_4.index[1]],
									point[facet_4.index[2]]);
					
						TrianglePrimitive triFacet_2 = new TrianglePrimitive(
									point[facet_4.index[0]],
									point[facet_4.index[2]],
									point[facet_4.index[3]]);
	
					
						//几何顶点只传递了颜色信息,此时,顶点的几何数据并不需要
						float color0[] = vertex[facet_4.index[0]].color.getRGB();
						float color1[] = vertex[facet_4.index[1]].color.getRGB();
						float color2[] = vertex[facet_4.index[2]].color.getRGB();
						float color3[] = vertex[facet_4.index[3]].color.getRGB();
					
						triFacet_1.setColor(color0,color1,color2);
						
						triFacet_2.setColor(color0,color2,color3);
					
						/*
							如果将上一句更为:
								triFacet_2.setColor(color0,color2,color2);
							就有可能绘制出具有Grouaud效果的刻面效果,当然这只是一种编程实践,
								并无理论支持,确切地说,它依赖于颜色的特写安排,对于本处的立方体和下一节的球是成立的,
								但对于再下一节的圆柱却不成立了,原因就是颜色安排的顺序是不够好,因而绘制不出刻面效果.
							对于光照物体,由于顶点的颜色并不是人工指定的,所以,这样替换不仅绘制不出刻面效果,反而引起错误
						*/
						
					
						triFacet_1.fillTriangle(g,BasicPrimitive.FILL_GOURAUD_SMOOTH );
						triFacet_2.fillTriangle(g,BasicPrimitive.FILL_GOURAUD_SMOOTH );
					}
				}
			}
		}
		
		g.setColor(colorOld);
	}	
	
	
	/*
		.Key-Matte算法：
			用同一种屏幕上不出现的颜色填充每个
			多边形，以保证覆盖掉屏幕上已经存在
			的图像这是一种简单思想，可以避免填
			色溢出或填不满的现象
		.本处简单使用黑色
		.最好是找出一个对象的所有着色色的线性组合,使得增加一个颜色时互不相同
	*/
	public void key_Matte(Graphics g,Point[] point,Facet[] facet)
	{
		Color colorOld = g.getColor();
			
		g.setColor(new Color(0.0f,0.0f,0.0f));

		/*
			facet.length表示共有多少个面需要处理
		*/
		for(int i = 0; i < facet.length;i++)
		{
			int type = facet[i].type;
			
			Facet3 facet_3 = new Facet3(0,0,0);
			Facet4 facet_4 = new Facet4(0,0,0,0);
			if(type == 3)
		    {
				facet_3 = (Facet3)facet[i];
				
				//如果这个小面是可见的，就将它绘制出来
				if(facet_3.visibility)
				{
					Polygon polygon = new Polygon();
			
			
					for(int j = 0;j < facet_3.index.length;j++)
					{
						polygon.addPoint(point[facet_3.index[j]].x,
										 point[facet_3.index[j]].y);
										 
					}
					g.fillPolygon(polygon);
				}
			}
			if(type == 4)
			{
				facet_4 = (Facet4)facet[i];
				if(facet_4.visibility)
				{
					Polygon polygon = new Polygon();
			
			
					for(int j = 0;j < facet_4.index.length;j++)
					{
						polygon.addPoint(point[facet_4.index[j]].x,
										 point[facet_4.index[j]].y);
										 
					}
					g.fillPolygon(polygon);
				}
			}
		}
		g.setColor(colorOld);
	}
}
