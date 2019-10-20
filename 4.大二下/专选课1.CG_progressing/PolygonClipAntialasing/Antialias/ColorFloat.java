public class ColorFloat
{
	float red = 0.0f;
	float green = 0.0f;
	float blue = 0.0f;
	float alpha = 1.0f;
	
	public ColorFloat(float red,float green,float blue)
	{
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public ColorFloat(float red,float green,float blue,float alpha)
	{
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = alpha;
	}
	
	public ColorFloat add(ColorFloat color)
	{
		ColorFloat colorFloat = new ColorFloat(this.red + color.red,
											   this.green + color.green,
											   this.blue  + color.blue ,
												this.alpha  + color.alpha );
		return	(colorFloat.clamp());
	}
	
	public ColorFloat addEqual(ColorFloat color)
	{
		this.red += color.red;
		this.green += color.green;
		this.blue  += color.blue;
		this.alpha  += color.alpha;
		
		return	(this.clamp());
	}
	

	public ColorFloat scaleLightness(float scale)
	{
		this.red *= scale;
		this.green *= scale;
		this.blue  *= scale;
		this.alpha *= scale;
		
		return	(this.clamp());
	}

	public void set(float red,float green,float blue)
	{
	
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	
	public void set(float red,float green,float blue,float alpha)
	{
	
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = alpha;
	}
	
	public void set(float[] rgb)
	{
		this.red = rgb[0];
		this.green = rgb[1];
		this.blue = rgb[2];
	}
	
	public float getRed()
	{
		return (red);
	}
	
	public float getGreen()
	{
		return (green);
	}
	
	public float getBlue()
	{
		return (blue);
	}
	
	public float getAlpha()
	{
		return (alpha);
	}
	
	public float[] getRGB()
	{
		float clrFloat[] = {red,green,blue};
		return (clrFloat);
	}
	
	public ColorFloat clamp()
	{
		red = red < 0.0f ? 0.0f : (red > 1.0f ? 1.0f : red);
		green = green < 0.0f ? 0.0f : (green > 1.0f ? 1.0f : green);
		blue = blue < 0.0f ? 0.0f : (blue > 1.0f ? 1.0f : blue);
		alpha = alpha < 0.0f ? 0.0f : (alpha > 1.0f ? 1.0f : alpha);
	
		return (this);
	
	
	}
}
