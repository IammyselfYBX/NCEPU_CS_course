public class LightingSystem
{
	//全局环境光
	public static final int LIGHT_MODEL_AMBIENT = 0;
	//近视点与无穷远视点
	public static final int LIGHT_MODEL_LOCAL_VIEWER = 0;
	//双面光照
	public static final int LIGHT_MODEL_TWO_SIDE = 0;
	
	//全局环境光
	/*
	The parameter contains four floating-point values 
		that specify the ambient RGBA intensity of the entire scene.
	Floating-point values are mapped directly. 
	Neither integer nor floating-point values are clamped. 
	The default ambient scene intensity is (0.2, 0.2, 0.2, 1.0). 
	*/
	ColorFloat globalAmbient = new ColorFloat(0.2f,0.2f,0.2f,1.0f);
	
	
	//近视点与无穷远视点
	/*
	The parameter is a single floating-point value that specifies how specular reflection angles are computed. 
	If bLocalView is false, specular reflection angles take the view direction to be parallel to and in the direction of the –z axis, regardless of the location of the vertex in world coordinates. 
	Otherwise specular reflections are computed from the origin of the world coordinate system. 
	The default is 0. 
	*/
	boolean bLocalView = false;
	
	//双面光照
	/*
	The parameter is a single floating-point value that specifies whether one- or two-sided lighting calculations are done for polygons. 
	It has no effect on the lighting calculations for points, lines, or bitmaps. If bTwoSide is  false, one-sided lighting is specified, and only the front material parameters are used in the lighting equation.
	Otherwise, two-sided lighting is specified.
	In this case, vertices of back-facing polygons are lighted using the back material parameters, and have their normals reversed before the lighting equation is evaluated.
	Vertices of front-facing polygons are always lighted using the front material parameters, with no change to their normals. 
	The default is 0. 
	*/
	boolean bTwoSide = false;
	
	/*
	Remarks

	In RGBA mode, the lighted color of a vertex is the sum of 
		(1)the material emission intensity, 
		(2)the product of the material ambient reflectance and the lighting model full-scene ambient intensity,	and 
		(3)the contribution of each enabled light source. 
			Each light source contributes the sum of three terms: ambient, diffuse, and specular. 
			The ambient light source contribution is the product of the material ambient reflectance and the light's ambient intensity. 
			The diffuse light source contribution is the product of the material diffuse reflectance, the light's diffuse intensity, and the dot product of the vertex's normal with the normalized vector from the vertex to the light source. 
			The specular light source contribution is the product of the material specular reflectance, the light's specular intensity, and the dot product of the normalized vertex-to-eye and vertex-to-light vectors, raised to the power of the shininess of the material.
		All three light source contributions are attenuated equally based on the distance from the vertex to the light source and on light source direction, spread exponent, and spread cutoff angle. 
		All dot products are replaced with zero if they evaluate to a negative value.

		The alpha component of the resulting lighted color is set to the alpha value of the material diffuse reflectance.

	*/
	
	public LightingSystem()
	{
	}
	
	public void lightModelb(int property,boolean bFlag)
	{
		if(property == LIGHT_MODEL_LOCAL_VIEWER)
			bLocalView = bFlag;
		else if(property == LIGHT_MODEL_TWO_SIDE)
			bTwoSide = bFlag;
	}
	
	public void lightModelfv(int property,float[] params)
	{
		if(property == LIGHT_MODEL_AMBIENT )
		{
			globalAmbient.red = params[0];
			globalAmbient.green = params[1];
			globalAmbient.blue = params[2];
			globalAmbient.alpha = params[3];
		}
	}
	
	
	/*
	按物体的顶点计算其光亮度
		light----一个光源或多个光源
		material---物体的材质
		vertex----的几何顶点,所有的几何变换完成之后并没有进行观察变换的点
		viewer----视点的位置
	
	所有计算均在世界坐标系中完成	
	*/
	/*
		第一,本方法不进行无穷远视点的处理;
		第二,本方法不进行双面光照处理
	*/
	
	public void lighting(Light[] light,Material material,Vertex3d[] vertex,ViewFinder viewer)
	{
		//三个过渡浮点变量
		float toRad = (float)(Math.PI / 180.0);
		float thta = viewer.theta  * toRad;
		float fai = viewer.phi * toRad;
		
		//观察点在世界坐标系中的三个坐标分量
		float xViewer = (float)(viewer.viewDistance * Math.cos(fai) * Math.cos(thta));
		float yViewer = (float)(viewer.viewDistance * Math.cos(fai) * Math.sin(thta));
		float zViewer = (float)(viewer.viewDistance * Math.sin(fai));
		
		
		//i按顶点个数循环,j按光的个数循环
		int i,j;
		for(i = 0;i < vertex.length;i++)
		{
			if(vertex[i].visibility)
			{
				//clrVertex为顶点的最终光亮度
				ColorFloat clrVertex = new ColorFloat(0.0f,0.0f,0.0f,1.0f);
					
				/*
				计算第一项:原材料自身发散的光强
				----材质自身发散的光最为简单,由材质的emission决定,不乘任何系数直接加入到光强之中
				*/
				clrVertex.red = material.emission.red;
				clrVertex.green = material.emission.green;
				clrVertex.blue = material.emission.blue;
					
				//下面计算第二项:全局环境光的照射----全局环境光的光强乘以材质的环境属性
					
				//强度
				float r = globalAmbient.red * material.ambient.red;
				float g = globalAmbient.green * material.ambient.green;
				float b = globalAmbient.blue * material.ambient.blue;
					
				//加入进去,至此已包含两项
				clrVertex.red += r;
				clrVertex.green += g;
				clrVertex.blue += b;
					
				/*
					下面一个循环计算第三个大项:从光源来的贡献
				*/
			
				for(j = 0;j < light.length;j++)
				{	
					//只有当光是开启的,光源才能发光,物体才会获得该光的照射
					if(light[j].on_off ==true)
					{
						//第一步:计算衰减系数
						float attenuation = 1.0f;
						
						/*
							如果光源为一个点光源(位置光源)则需要计算被光照的点至光源的距离,以计算衰减系数
							如果是平行光源(定向光源),则不衰减
						*/
						if(light[j].type_source == Light.POSITIONAL_SOURCE)
						{
							float c0 = light[j].constant_attenuation;
							float c1 = light[j].linear_attenuation;
							float c2 = light[j].quadratic_attenuation;
							
							if(c0 < 0.000001f) c0 = 0.000001f;
							attenuation = c0;
							
							//计算顶点离光源的距离
							if((c1 > 0.000001f) ||(c2 > 0.000001f))
							{
								float x_x = light[j].position.x - vertex[i].x ;
								float y_y = light[j].position.y - vertex[i].y ;
								float z_z = light[j].position.z - vertex[i].z ;
							
								float distance = (float)Math.sqrt(x_x * x_x + y_y * y_y + z_z * z_z);
								
								//通过衰减函数计算衰减系数
								attenuation = c0 + c1 * distance + c2 * distance * distance;
				
							}
							
							attenuation = 1.0f / attenuation;
							
							attenuation = Math.min(attenuation,1.0f);
						}
						
						//第二步:计算聚光效果因子
						
						//如果光为聚光,则光只能影响位于光锥之内的顶点,如果光为泛光,则spotFactor简单地为1.0f.
						float spotFactor = 1.0f;
						
						//如果光源是一个点光源且是一个聚光灯,则具有聚光效果
						if((light[j].type_source == Light.POSITIONAL_SOURCE) &&
						   (light[j].type == Light.SPOT_LIGHT))
						{
							if((light[j].spot_cutoff >= 0.0f) &&
							   (light[j].spot_cutoff <= 90.0f))
							{
								//聚光灯光源指向顶点的向量的三个分量
								float v_x = vertex[i].x - light[j].position.x;
								float v_y = vertex[i].y - light[j].position.y;
								float v_z = vertex[i].z - light[j].position.z;
								
								//聚光灯光源指向顶点的向量(viewer ---- vertex)
								Vector3d v_xyz = new Vector3d(v_x,v_y,v_z);
								
								//向量单位化
								v_xyz.unitize();
								
								//计算向量v与聚光灯照射方向这两个单位向量的点积
								float fInsideCone = v_xyz.dot(light[j].spot_direction);
								
								//取0和它自身的最大者
								fInsideCone = fInsideCone < 0.0f ? 0.0f : fInsideCone;
								
								//如果fInsideCone小于聚光发散半角的余弦,则表明该顶点落于光锥之外,聚光对它没有任何影响
								if(fInsideCone < Math.cos(light[j].spot_cutoff * toRad))
									spotFactor = 0.0f;
								else
								{
									spotFactor = fInsideCone;
								
									//聚光效果还与聚光指数有关,它应该是聚光指数的次方
									fInsideCone = 1.0f;
									for(int m = 0;m < (int)light[j].spot_exponent;m++)
										fInsideCone *= spotFactor;
									spotFactor = fInsideCone;	
								}
								
							}
							
						}
						
						//第三步:完成第三项的计算,这三项就是从光源来的贡献
						
						//计算环境反射部分,对r,g,b重新赋值:即环境子项
						r = material.ambient.red * light[j].ambient.red;	
						g = material.ambient.green * light[j].ambient.green;	
						b = material.ambient.blue * light[j].ambient.blue;	
						
						//计算漫反射部分
						//在计算漫反射部分时,要计算顶点法线向量和顶点指向光源的向量这两个单位向量的点积,即夹角的余弦
						
						//由顶点指向光源的向量的三个分量
						float x_l = light[j].position.x - vertex[i].x ;
						float y_l = light[j].position.y - vertex[i].y ;
						float z_l = light[j].position.z - vertex[i].z ;
					
						//由顶点指向光源的向量(vertex----viewer)
						Vector3d xyz_light = new Vector3d(x_l,y_l,z_l);
						
						/*
							如果光源为定向光源,即方向光,此时,光的位置在无穷远点处,
								因而光是平行光,任何顶点至光源的向量均平等于光的照射方向
						*/
						
						if(light[j].type_source == Light.DIRECTIONAL_SOURCE)
						{
							xyz_light.x = -1.0f * light[j].position.x;
							xyz_light.y = -1.0f * light[j].position.y;
							xyz_light.z = -1.0f * light[j].position.z;
						}
						
						//单位化
						xyz_light.unitize();
						
						float cos = xyz_light.dot(vertex[i].normal);
						cos = cos < 0.0f ? 0.0f : cos;
						
						//计算漫反射部分的三个RGB子项
						float rDiffuse = material.diffuse.red * light[j].diffuse.red * cos;	
						float gDiffuse = material.diffuse.green * light[j].diffuse.green * cos;	
						float bDiffuse = material.diffuse.blue * light[j].diffuse.blue * cos;
						
						//加入漫反射部分
						r += rDiffuse;
						g += gDiffuse;
						b += bDiffuse;
						
						//计算高光部分
						/*
							首先反射项也取决于光是否直接落在顶点上,
								如果顶点法线和由顶点指向光源的向量之点积小于或等于0.0,则没有高光反射
						*/
						if(cos > 0.0f)
						{
							//计算从顶点指向视点的单位向量
							float x_viewer = xViewer - vertex[i].x;
							float y_viewer = yViewer - vertex[i].y;
							float z_viewer = zViewer - vertex[i].z;
							
							Vector3d xyz_viewer = new Vector3d(x_viewer,y_viewer,z_viewer);
							xyz_viewer.unitize();
							
							//计算顶点到光源和顶点到视点这两个单位向量的和
							Vector3d vector = xyz_viewer.add(xyz_light);
							vector.unitize();
							
							//计算顶点法线向量与向量之点积
							float shine = vector.dot(vertex[i].normal);
							
							shine = shine < 0.0f ? 0.0f : shine;
							
							//引进发散度
							float factor = 1.0f;
							for(int k = 0;k < (int)material.shininess;k++)
								factor *= shine;
							
							//计算高光的三个子项
							float rSpecular = material.specular.red * light[j].specular.red * factor;	
							float gSpecular = material.specular.green * light[j].specular.green * factor;	
							float bSpecular = material.specular.blue * light[j].specular.blue * factor;
							
							//加入这三个项
							r += rSpecular;
							g += gSpecular;
							b += bSpecular;
						}
						
						//现在只要将衰减指数和聚光效果加入进来,就得到了来自光源的贡献
						
						r *= (attenuation * spotFactor);
						g *= (attenuation * spotFactor);
						b *= (attenuation * spotFactor);
						
						//一个顶点的最后光亮度
						clrVertex.red += r;
						clrVertex.green += g;
						clrVertex.blue += b;
						
					}//if
				}//for --j
			
				//用光亮度的三个分量代替颜色的三个强度
				clrVertex.clamp();
				vertex[i].color.red = clrVertex.red;
				vertex[i].color.green = clrVertex.green;
				vertex[i].color.blue = clrVertex.blue;
				
				//alpha	被设置为材质的漫反射项的alpha
				vertex[i].color.alpha = material.diffuse.alpha;
			}//if(vertex[i].visibility)end	
		}//for --i
	}
	
	public void lighting(Light[] light,Material material,Facet[] facet,Vertex3d[] vertex,ViewFinder viewer)
	{
		//三个过渡浮点变量
		float toRad = (float)(Math.PI / 180.0);
		float thta = viewer.theta  * toRad;
		float fai = viewer.phi * toRad;
		
		//观察点在世界坐标系中的三个坐标分量
		float xViewer = (float)(viewer.viewDistance * Math.cos(fai) * Math.cos(thta));
		float yViewer = (float)(viewer.viewDistance * Math.cos(fai) * Math.sin(thta));
		float zViewer = (float)(viewer.viewDistance * Math.sin(fai));
		
		
		//i按面个数循环,j按光的个数循环
		int i,j;
		for(i = 0;i < facet.length;i++)
		{
			if(facet[i].visibility)
			{
				//clrFacet为面的最终光亮度
				ColorFloat clrFacet = new ColorFloat(0.0f,0.0f,0.0f,1.0f);
					
				/*
				计算第一项:原材料自身发散的光强
				----材质自身发散的光最为简单,由材质的emission决定,不乘任何系数直接加入到光强之中
				*/
				clrFacet.red = material.emission.red;
				clrFacet.green = material.emission.green;
				clrFacet.blue = material.emission.blue;
					
				//下面计算第二项:全局环境光的照射----全局环境光的光强乘以材质的环境属性
					
				//强度
				float r = globalAmbient.red * material.ambient.red;
				float g = globalAmbient.green * material.ambient.green;
				float b = globalAmbient.blue * material.ambient.blue;
					
				//加入进去,至此已包含两项
				clrFacet.red += r;
				clrFacet.green += g;
				clrFacet.blue += b;
			
				//计算一个面的中心点
			
				Vertex3d vertexCenter = new Vertex3d(0.0f,0.0f,0.0f);
			
				Facet3 facet_3 = new Facet3(0,0,0);
				Facet4 facet_4 = new Facet4(0,0,0,0);
				int type = facet[i].type;
			
				//逼近三角形中点的迭代次数
				int iteration = 0;
				//if-else if{}语句完成小面中心的计算
				if(type == 3)
				{
					facet_3 = (Facet3)facet[i];
					
					//三角形的重心点
					vertexCenter.x = (vertex[facet_3.index[0]].x + vertex[facet_3.index[1]].x + vertex[facet_3.index[2]].x) / 3.0f;
					vertexCenter.y = (vertex[facet_3.index[0]].y + vertex[facet_3.index[1]].y + vertex[facet_3.index[2]].y) / 3.0f;
					vertexCenter.z = (vertex[facet_3.index[0]].z + vertex[facet_3.index[1]].z + vertex[facet_3.index[2]].z) / 3.0f;
				}
				else if(type == 4)
				{
					facet_4 = (Facet4)facet[i];
					
					//三角形0-1-2的重心
					float xc_012 = (vertex[facet_4.index[0]].x + vertex[facet_4.index[1]].x + vertex[facet_4.index[2]].x) / 3.0f;
					float yc_012 = (vertex[facet_4.index[0]].y + vertex[facet_4.index[1]].y + vertex[facet_4.index[2]].y) / 3.0f;
					float zc_012 = (vertex[facet_4.index[0]].z + vertex[facet_4.index[1]].z + vertex[facet_4.index[2]].z) / 3.0f;
	
					//三角形0-2-3的重心
					float xc_023 = (vertex[facet_4.index[0]].x + vertex[facet_4.index[2]].x + vertex[facet_4.index[3]].x) / 3.0f;
					float yc_023 = (vertex[facet_4.index[0]].y + vertex[facet_4.index[2]].y + vertex[facet_4.index[3]].y) / 3.0f;
					float zc_023 = (vertex[facet_4.index[0]].z + vertex[facet_4.index[2]].z + vertex[facet_4.index[3]].z) / 3.0f;
	
					
					vertexCenter.x = (xc_012 + xc_023) / 2.0f;
					vertexCenter.y = (yc_012 + yc_023) / 2.0f;
					vertexCenter.z = (zc_012 + zc_023) / 2.0f;
					
				}
			
				/*
					下面一个循环计算第三个大项:从光源来的贡献
				*/
			
				//令小面中心点的法线就是面的法线
				vertexCenter.normal = facet[i].normal;
			
				for(j = 0;j < light.length;j++)
				{	
					//只有当光是开启的,光源才能发光,物体才会获得该光的照射
					if(light[j].on_off == true)
					{
						//第一步:计算衰减系数
						float attenuation = 1.0f;
						
						/*
							如果光源为一个点光源(位置光源)则需要计算被光照的点至光源的距离,以计算衰减系数
							如果是平行光源(定向光源),则不衰减
						*/
						if(light[j].type_source == Light.POSITIONAL_SOURCE)
						{
							float c0 = light[j].constant_attenuation;
							float c1 = light[j].linear_attenuation;
							float c2 = light[j].quadratic_attenuation;
							
							if(c0 < 0.000001f) c0 = 0.000001f;
							attenuation = c0;
							
							if((c1 > 0.000001f) ||(c2 > 0.000001f))
							{
								float x_x = light[j].position.x - vertexCenter.x ;
								float y_y = light[j].position.y - vertexCenter.y ;
								float z_z = light[j].position.z - vertexCenter.z ;
							
								//计算顶点光源的距离
								float distance = (float)Math.sqrt(x_x * x_x + y_y * y_y + z_z * z_z);
								
								//通过衰减函数计算衰减系数
								attenuation = c0 + c1 * distance + c2 * distance * distance;
				
							}

							attenuation = 1.0f / attenuation;
							attenuation = Math.min(attenuation,1.0f);
						}
						
						//第二步:计算聚光效果因子
						
						//如果光为聚光,则光只能影响位于光锥之内的顶点,如果光为泛光,则spotFactor简单地为1.0f.
						float spotFactor = 1.0f;
						
						//如果光源是一个点光源且是一个聚光灯,则具有聚光效果
						if((light[j].type_source == Light.POSITIONAL_SOURCE) &&
						   (light[j].type == Light.SPOT_LIGHT))
						{
							if((light[j].spot_cutoff >= 0.0f) &&
							   (light[j].spot_cutoff <= 90.0f))
							{
								//聚光灯光源指向顶点的向量的三个分量
								float v_x = vertexCenter.x - light[j].position.x;
								float v_y = vertexCenter.y - light[j].position.y;
								float v_z = vertexCenter.z - light[j].position.z;
								
								//聚光灯光源指向顶点的向量(viewer ---- vertex)
								Vector3d v_xyz = new Vector3d(v_x,v_y,v_z);
								
								//向量单位化
								v_xyz.unitize();
								
								//计算向量v与聚光灯照射方向这两个单位向量的点积
								float fInsideCone = v_xyz.dot(light[j].spot_direction);
								
								//取0和它自身的最大者
								fInsideCone = fInsideCone < 0.0f ? 0.0f : fInsideCone;
								
								//如果fInsideCone小于聚光发散半角的余弦,则表明该顶点落于光锥之外,聚光对它没有任何影响
								if(fInsideCone < Math.cos(light[j].spot_cutoff * toRad))
									spotFactor = 0.0f;
								else
								{
									spotFactor = fInsideCone;
								
									//聚光效果还与聚光指数有关,它应该是聚光指数的次方
									fInsideCone = 1.0f;
									for(int m = 0;m < (int)light[j].spot_exponent;m++)
										fInsideCone *= spotFactor;
									spotFactor = fInsideCone;	
								}
								
							}
							
						}
						
						//第三步:完成第三项的计算,第三项就是从光源来的贡献
						
						//计算环境反射部分,对r,g,b重新赋值:即环境子项
						r = material.ambient.red * light[j].ambient.red;	
						g = material.ambient.green * light[j].ambient.green;	
						b = material.ambient.blue * light[j].ambient.blue;	
						
						//计算漫反射部分
						//在计算漫反射部分时,要计算顶点法线向量和顶点指向光源的向量这两个单位向量的点积,即夹角的余弦
						
						//由顶点指向光源的向量的三个分量
						float x_l = light[j].position.x - vertexCenter.x ;
						float y_l = light[j].position.y - vertexCenter.y ;
						float z_l = light[j].position.z - vertexCenter.z ;
					
						//由顶点指向光源的向量(vertex----viewer)
						Vector3d xyz_light = new Vector3d(x_l,y_l,z_l);
						
						/*
							如果光源为定向光源,即方向光,此时,光的位置在无穷远点处,
								因而光是平行光,任何顶点至光源的向量均平等于光的照射方向
						*/
						
						if(light[j].type_source == Light.DIRECTIONAL_SOURCE)
						{
							xyz_light.x = -1.0f * light[j].position.x;
							xyz_light.y = -1.0f * light[j].position.y;
							xyz_light.z = -1.0f * light[j].position.z;
						}
						
						//单位化
						xyz_light.unitize();
						
						float cos = xyz_light.dot(vertexCenter.normal);
						cos = cos < 0.0f ? 0.0f : cos;
						
						//计算漫反射部分的三个RGB子项
						float rDiffuse = material.diffuse.red * light[j].diffuse.red * cos;	
						float gDiffuse = material.diffuse.green * light[j].diffuse.green * cos;	
						float bDiffuse = material.diffuse.blue * light[j].diffuse.blue * cos;
						
						//加入漫反射部分
						r += rDiffuse;
						g += gDiffuse;
						b += bDiffuse;
						
						//计算高光部分
						/*
							首先反射项也取决于光是否直接落在顶点上,
								如果顶点法线和由顶点指向光源的向量之点积小于或等于0.0,则没有高光反射
						*/
						if(cos > 0.0f)
						{
							//计算从顶点指向视点的单位向量
							float x_viewer = xViewer - vertexCenter.x;
							float y_viewer = yViewer - vertexCenter.y;
							float z_viewer = zViewer - vertexCenter.z;
							
							Vector3d xyz_viewer = new Vector3d(x_viewer,y_viewer,z_viewer);
							xyz_viewer.unitize();
							
							//计算顶点到光源和顶点到视点这两个单位向量的和
							Vector3d vector = xyz_viewer.add(xyz_light);
							vector.unitize();
							
							//计算顶点法线向量与向量之点积
							float shine = vector.dot(vertexCenter.normal);
							
							shine = shine < 0.0f ? 0.0f : shine;
							
							//引进发散度
							float factor = 1.0f;
							for(int k = 0;k < (int)material.shininess;k++)
								factor *= shine;
							
							//计算高光的三个子项
							float rSpecular = material.specular.red * light[j].specular.red * factor;	
							float gSpecular = material.specular.green * light[j].specular.green * factor;	
							float bSpecular = material.specular.blue * light[j].specular.blue * factor;
							
							//加入这三个项
							r += rSpecular;
							g += gSpecular;
							b += bSpecular;
						}
						
						//现在只要将衰减指数和聚光效果加入进来,就得到了来自光源的贡献
						
						r *= (attenuation * spotFactor);
						g *= (attenuation * spotFactor);
						b *= (attenuation * spotFactor);
						
						//一个顶点的最后光亮度
						clrFacet.red += r;
						clrFacet.green += g;
						clrFacet.blue += b;
					}//if
				}//for --j
			
				//用光强的三个分量代替颜色的三个强度,此时,颜色应为小面的颜色
				clrFacet.clamp();
				facet[i].color.red = clrFacet.red;
				facet[i].color.green = clrFacet.green;
				facet[i].color.blue = clrFacet.blue;
				//alpha	被设置为材质的漫反射项的alpha
				facet[i].color.alpha = material.diffuse.alpha;
			}//if(facet[i].visibility)--end
		}//for --i
	}
}


