public class Material
{
	//进行前面、后面或双面光照
	public static final int  FACE_FRONT = 0;
	public static final int  FACE_BACK = 1;
	public static final int  FACE_FRONT_AND_BACK = 2;
	
	//材质的光亮度(高光指数)
	public static final int SHININESS = 3;
	
	//材质属性
	public static final int AMBIENT = 4;
	public static final int DIFFUSE  = 5;
	public static final int SPECULAR = 6;
	public static final int EMISSION  = 7;
	public static final int AMBIENT_AND_DIFFUSE = 8; 

	
	//对环境光的反射系数
	/*
	The parameter contains four floating-point values 
		that specify the ambient RGBA reflectance of the material. 
	Floating-point values are mapped directly. 
	Neither integer nor floating-point values are clamped. 
	The default ambient reflectance for both front- and back-facing materials is (0.2, 0.2, 0.2, 1.0). 
	*/
	ColorFloat ambient = new ColorFloat(0.2f,0.2f,0.2f,1.0f);
	
	//对漫反射光的反射系数
	/*
	The parameter contains four floating-point values 
		that specify the diffuse RGBA reflectance of the material. 
	Floating-point values are mapped directly. 
	Neither integer nor floating-point values are clamped. 
	The default diffuse reflectance for both front- and back-facing materials is (0.8, 0.8, 0.8, 1.0). 
	*/
	ColorFloat diffuse = new ColorFloat(0.8f,0.8f,0.8f,1.0f);
	
	//镜面高光的反射系数
	/*
	The parameter contains four floating-point values 
		that specify the specular RGBA reflectance of the material.
	Floating-point values are mapped directly. 
	Neither integer nor floating-point values are clamped. 
	The default specular reflectance for both front- and back-facing materials is (0.0, 0.0, 0.0, 1.0). 
	
	*/
	ColorFloat specular = new ColorFloat(0.0f,0.0f,0.0f,1.0f);

	//辐射光色
	/*
	The parameter contains four floating-point values 
		that specify the RGBA emitted light intensity of the material. 
	Floating-point values are mapped directly. 
	Neither integer nor floating-point values are clamped.
	The default emission intensity for both front- and back-facing materials is (0.0, 0.0, 0.0, 1.0). 
	*/
	ColorFloat emission = new ColorFloat(0.0f,0.0f,0.0f,1.0f);
	
	//光亮度
	/*
	The params parameter is a single floating-point value 
		that specifies the RGBA specular exponent of the material. 
	Integer and floating-point values are mapped directly. 
	Only values in the range [0,128] are accepted.
	The default specular exponent for both front- and back-facing materials is 0. 
	*/
	float shininess = 0.0f;
	
	//面的类型
	int face_type = this.FACE_FRONT;
	
	public Material()
	{}

	public void materialf(int face, int property,  float param  )
	{
		//此时property只能为Material.SHININESS
		
		face_type = face;
		shininess = param;
	}
	
	public void materialfv(int face,  int property,float[] params  )
	{
		switch(property)
		{
		case 4:	
				{
					ambient.red = params[0];
					ambient.green = params[1];
					ambient.blue = params[2];
					ambient.alpha = params[3];
				}
				break;
		case 5:	
				{
					diffuse.red = params[0];
					diffuse.green = params[1];
					diffuse.blue = params[2];
					diffuse.alpha = params[3];
				}
				break;
		case 6:
				{
					specular.red = params[0];
					specular.green = params[1];
					specular.blue = params[2];
					specular.alpha = params[3];
				}
				break;	
		case 7:
				{
					emission.red = params[0];
					emission.green = params[1];
					emission.blue = params[2];
					emission.alpha = params[3];
				}
				break;
		case 8:	
				{
					ambient.red = params[0];
					ambient.green = params[1];
					ambient.blue = params[2];
					ambient.alpha = params[3];
					
					diffuse.red = params[0];
					diffuse.green = params[1];
					diffuse.blue = params[2];
					diffuse.alpha = params[3];
				}
				break;
		}
		
	}
}
