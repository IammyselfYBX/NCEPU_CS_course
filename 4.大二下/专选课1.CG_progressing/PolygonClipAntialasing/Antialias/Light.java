public class Light
{
		
	//光的类型:全向点光源或聚光
	public static final int  OMNI_LIGHT = 0;
	public static final int  SPOT_LIGHT = 1;

	//光源类型:点光源或平行光源
	public static final int  POSITIONAL_SOURCE = 2;
	public static final int  DIRECTIONAL_SOURCE = 3;
	
	
	//光的属性
	public static final int  SPOT_EXPONENT = 4;
	public static final int  SPOT_CUTOFF  = 5;
	public static final int  CONSTANT_ATTENUATION = 6;
	public static final int  LINEAR_ATTENUATION  = 7;
	public static final int  QUADRATIC_ATTENUATION = 8; 

	public static final int  AMBIENT = 9;
	public static final int  DIFFUSE = 10;
	public static final int  SPECULAR  = 11;
	public static final int  POSITION  = 12;
	public static final int  SPOT_DIRECTION = 13; 
	
	public static final int ON_OFF = 14;
	
	//点光源聚光指数
	/*
	The parameter is a single floating-point value 
		that specifies the intensity distribution of the light.
	Floating-point values are mapped directly. 
	
	Only values in the range [0,128] are accepted. 
	
	Effective light intensity is attenuated by the cosine of 
		the angle between the direction of the light and the 
		direction from the light to the vertex being lighted, 
		raised to the power of the spot exponent.
	Thus, higher spot exponents result in a more focused light source, 
		regardless of the spot cutoff angle (see the following paragraph). 
	
	The default spot exponent is 0, resulting in uniform light distribution. 

	*/
	float spot_exponent = 0.0f;
	
	
	//点光源聚光发散半角
	/*
	The parameter is a single floating-point value 
		that specifies the maximum spread angle of a light source. 
	Floating-point values are mapped directly. 
	
	Only values in the range [0,90], and the special value 180, are accepted.
	If the angle between the direction of the light and the direction from the light to the vertex being lighted 
		is greater than the spot cutoff angle, then the light is completely masked. 
	Otherwise, its intensity is controlled by the spot exponent and the attenuation factors. 
	The default spot cutoff is 180, resulting in uniform light distribution. 
	*/
	float spot_cutoff = 180.0f;
	
	//下面是并于衰减因子的英文描述
	/*
	The three parameters are all  a single floating-point value respectively that specifies one of the three light attenuation factors. 
	Floating-point values are mapped directly. 
	Only nonnegative values are accepted. 
	If the light is positional, rather than directional, 
		its intensity is attenuated by the reciprocal of the sum of: 
		the constant factor, the linear factor multiplied by the distance between the light and the vertex being lighted, and the quadratic factor multiplied by the square of the same distance. 
	The default attenuation factors are (1,0,0), resulting in no attenuation. 
	*/
	
	//常数衰减因子
	float constant_attenuation = 1.0f;
	//线性衰减因子
	float linear_attenuation = 0.0f;
	//二次衰减因子
	float quadratic_attenuation = 0.0f;
	
	
	//环境光
	/*
	The parameter contains four floating-point values that specify the ambient RGBA intensity of the light. 
	Floating-point values are mapped directly. 
	Floating-point values are not  clamped. 
	The default ambient light intensity is (0.0, 0.0, 0.0, 1.0). 
	*/
	ColorFloat ambient = new ColorFloat(0.0f,0.0f,0.0f,1.0f);
	
	//漫反射光
	/*
	The parameter contains four floating-point values that specify the diffuse RGBA intensity of the light. 
	Floating-point values are mapped directly. 
	Floating-point values are not clamped. 
	The default diffuse intensity is (1.0, 1.0, 1.0, 1.0).
	*/
	ColorFloat diffuse = new ColorFloat(1.0f,1.0f,1.0f,1.0f);
	
	//镜面高光
	/*
	The parameter contains four floating-point values 
		that specify the specular RGBA intensity of the light.  
	Floating-point values are mapped directly. 
	Floating-point values are not  clamped. 
	The default specular intensity is (1.0, 1.0, 1.0, 1.0) .
	*/
	
	ColorFloat specular = new ColorFloat(1.0f,1.0f,1.0f,1.0f);

	//点光源位置,或平行光的照射方向
	/*
	The parameter contains four floating-point values that specify the position of the light in homogeneous object coordinates.
	Both integer and floating-point values are mapped directly. 
	Neither integer nor floating-point values are clamped. 
	The position is not (is) transformed by the modelview matrix(and it is stoparam in eye coordinates in OpenGL).
	If the w component of the position is 0.0, the light is treated as a directional source. 
		Diffuse and specular lighting calculations take the lights direction, but not its actual position, into account, and attenuation is disabled. 
	Otherwise, diffuse and specular lighting calculations are based on the actual location of the light in world coordinates(in eye coordinates in OpenGL), and attenuation is enabled. 
	The default position is (100,0,0,1); thus, the default light source is directional, parallel to, and in the direction of the –x axis. 
	*/
	
	Vertex3d position = new Vertex3d(100.0f,0.0f,0.0f,1.0f);
	
	//聚光的照射方向(聚光是方向光)
	/*
	The parameter contains three floating-point values that specify the direction of the light in homogeneous object coordinates. 
	Both integer and floating-point values are mapped directly.
	Neither integer nor floating-point values are clamped. 
	It is significant only when  SPOT_CUTOFF is not 180, which it is by default. 
	The default direction is (-1,0,0.0). 
	*/
	Vector3d spot_direction = new Vector3d(-1.0f,0.0f,0.0f);
	
	//光源的类型
	int type_source =  POSITIONAL_SOURCE;
	
	//光的类型
	int type = OMNI_LIGHT;
	
	//说明是第几盏灯
	int index = 0;
	
	boolean on_off = true;
	
	public Light(int index)
	{
		this.index = index;
	}
	
	public void setType(int type)
	{
		switch(type)
		{
			case 0:	this.type = OMNI_LIGHT;break;
			case 1:	this.type = SPOT_LIGHT;break;
			case 2: this.type_source = POSITIONAL_SOURCE;break; 
			case 3: this.type_source = DIRECTIONAL_SOURCE;break;
		}
	}
	
	public void lightb(int property,boolean bFlag)
	{
		if(property == ON_OFF)on_off = bFlag;
	}
	
	public void lightf(int property,float param)
	{
		switch(property)
		{
			case 4:	spot_exponent = param < 0.0f ? 0.0f : (param > 128.0f ? 128.0f : param);break;
			case 5:
					{	
						if(param == 180.0f)
						{
							spot_cutoff = 180.0f;
						}
						else
							spot_cutoff = param < 0.0f ? 0.0f : (param > 90.0f ? 90.0f : param);
					
					}
					break;
			case 6:	constant_attenuation = param;break;
			case 7: linear_attenuation =  param;break;
			case 8: quadratic_attenuation =  param;break;			
						
		}
		
	}
	
	public void lightfv(int property,float[] params)
	{
		switch(property)
		{
		case 9:	
				{
					ambient.red = params[0];
					ambient.green = params[1];
					ambient.blue = params[2];
					ambient.alpha = params[3];
				}
				break;
		case 10:	
				{
					diffuse.red = params[0];
					diffuse.green = params[1];
					diffuse.blue = params[2];
					diffuse.alpha = params[3];
				}
				break;
		case 11:
				{
					specular.red = params[0];
					specular.green = params[1];
					specular.blue = params[2];
					specular.alpha = params[3];
				}
				break;	
				
		case 12:
				{
					float ww = params[3];;
			
					if(Math.abs(ww) > 0.000001f)//当w != 0 时表示一个位置光源
					{
						type_source = POSITIONAL_SOURCE;
						float x = params[0] / ww;
						float y = params[1] / ww;
						float z = params[2] / ww;
					
						position.x = x;
						position.y = y;
						position.z = z;
						position.w = 1.0f;
					}	
					//如果为方向光,则光的位置主要说明光的照射方向(反方向)
					else 
					{
						type_source = DIRECTIONAL_SOURCE;
						
						float sign = (ww < 0.0f) ? -1.0f : 1.0f;
							ww = 0.000001f * sign;
						
						float x = params[0] / ww;
						float y = params[1] / ww;
						float z = params[2] / ww;
						
						Vector3d vector = new Vector3d(-x,-y,-z);
						vector.unitize();
						position.x = vector.x;
						position.y = vector.y;
						position.z = vector.z;
						position.w = 1.0f;
					}
					
				}
				break;	
					
		case 13:
				{
					
					
						
					float ww = params[3];
					float sign = (ww < 0.0f) ? -1.0f : 1.0f;
					if(Math.abs(ww) < 0.000001f)//当w = 0 时表示一个无穷远点
						ww = 0.000001f * sign;
					float x = params[0] / ww;
					float y = params[1] / ww;
					float z = params[2] / ww;
					
					//齐次坐标表示
					spot_direction.x = x;
					spot_direction.y = y;
					spot_direction.z = z;
					spot_direction.unitize();
				}
				break;
		}
	}
}

