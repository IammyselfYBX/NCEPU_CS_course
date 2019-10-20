import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;

public class LinePrimitive extends BasicPrimitive
{

	int xMin,xMax,yMin,yMax;
	
	float[] color0 = new float[3];
	float[] color1 = new float[3];
	
	public LinePrimitive()
	{
		xMin = 0;
		xMax = 800;
		yMin = 0;
		yMax = 600;
	}
	
	
	public void setColor(float[] color0,float[] color1)
	{
		for(int i = 0;i < 3;i++)
		{
			this.color0[i] = color0[i];
			this.color1[i] = color1[i];
		}
	}
	
	public void setClipRegion(int xMin,int xMax,int yMin,int yMax)
	{
		this.xMin = xMin;
		this.xMax = xMax;
		this.yMin = yMin;
		this.yMax = yMax;
	}
	
	//	仅完成一条实线的绘制,线的颜色由线段的第一个点的颜色来决定
	public void drawLine(Graphics g,int x1,int y1,int x2,int y2)
	{
		int dx = x2 - x1;
		int dy = y2 - y1;
		
		int ix = (int)Math.abs(dx);
		int iy = (int)Math.abs(dy);
		int inc = (ix >= iy) ? ix : iy;
		
		Color colorOld = g.getColor();
		g.setColor(new Color(color0[0],color0[1],color0[2]));
		g.drawLine(x1,y1,x1,y1);
		
		int x = 0;
		int y = 0;
		boolean bPlot = false;
		
		int plotX = x1;
		int plotY = y1;
		
		for(int i = 0;i <= inc;i++) 
		{
			x += ix;
			y += iy;
			
			bPlot = false;
			
			if(x > inc)
			{
				bPlot = true;
				
				x -= inc;
				
				if(dx > 0) plotX++;
				if(dx < 0) plotX--;
			}
			
			if(y > inc)
			{
				bPlot = true;
				
				y -= inc;
				
				if(dy > 0) plotY++;
				if(dy < 0) plotY--;
			}
			
			if(bPlot)
				g.drawLine(plotX,plotY,plotX,plotY);

		}
		
		g.setColor(colorOld);
	}
	
	//仅完成一条给定线型的线段的绘制,其颜色由线段的第一个点的颜色来决定
	public void drawLine(Graphics g,int x1,int y1,int x2,int y2,short lineMode)
	{
		int dx = x2 - x1;
		int dy = y2 - y1;
		
		int ix = (int)Math.abs(dx);
		int iy = (int)Math.abs(dy);
		int inc = (ix >= iy) ? ix : iy;

		Color colorOld = g.getColor();
		g.setColor(new Color(color0[0],color0[1],color0[2]));

		
		int maskBit = 0;
		short mask = (short)0x0001;
		
		
		
		if((mask & lineMode) != 0)
			g.drawLine(x1,y1,x1,y1);
		mask = (short)(mask << 1);
		maskBit++;
		
		int x = 0;
		int y = 0;
		boolean bPlot = false;
		
		int plotX = x1;
		int plotY = y1;
		
		for(int i = 0;i <= inc;i++) 
		{
			x += ix;
			y += iy;
			
			bPlot = false;
			
			if(x > inc)
			{
				bPlot = true;
				
				x -= inc;
				
				if(dx > 0) plotX++;
				if(dx < 0) plotX--;
			}
			
			if(y > inc)
			{
				bPlot = true;
				
				y -= inc;
				
				if(dy > 0) plotY++;
				if(dy < 0) plotY--;
			}
			
			if(bPlot)
			{
				boolean bMask = ((mask & lineMode) != 0);
			
				if(bMask)g.drawLine(plotX,plotY,plotX,plotY);
				
				mask <<= 1;
				
				maskBit++;
				
				if(maskBit == 16)
				{
					maskBit = 0;
					mask = (short)0x0001;
				}
			
			}
			
		}
		g.setColor(colorOld);
	}
	
	//剪切直线
	public void lineCliped(Graphics g,int x1,int y1,int x2,int y2,short lineMode,int renderModel)
	{
		float u1[] = {0.0f};
		float u2[] = {1.0f};
		
		float dx = x2 - x1;
		float dy = y2 - y1;
		
		if(clipTest(-dx,x1 - xMin,u1,u2)	&&
		   clipTest(dx,xMax - x1,u1,u2)		&&
		   clipTest(-dy,y1 - yMin,u1,u2)	&&
		   clipTest(dy,yMax - y1,u1,u2))
		{
			if(u2[0] < 1.0)
			{
				x2 = x1 + round(u2[0] * dx);
				y2 = y1 + round(u2[0] * dy);
			}
			
			if(u1[0] > 0.0)
			{
				x1 += round(u1[0] * dx);
				y1 += round(u1[0] * dy);
			}
		
		drawLine(g,x1,y1,x2,y2,lineMode,renderModel);
		//g.drawLine(x1,y1,x2,y2);
		}
	}
	
	private boolean clipTest(float p,float q,float[] u1,float[] u2)
	{
		float r;
		boolean  bClip = true;
		
		if(p < 0.0f)
		{
			r = q / p;
			if( r > u2[0]) bClip = false;
			else if(r > u1[0])
				u1[0] = r;
		}
		else if( p > 0.0)
		{
			r = q / p;
		
			if(r < u1[0]) bClip = false;
			else if( r < u2[0])
				u2[0] = r;
		
		}
		else
		{
			if( q < 0.0) bClip = false;
		}
		
		return (bClip);
	}
	
	//采用Gouraud模型光照直线,线为实型线,其颜色需要进行线性插值
	public void lineLighted(Graphics g,int x1,int y1,int x2,int y2)
	{
		Color colorOld = g.getColor();
		

		int dx = x2 - x1;
		int dy = y2 - y1;
		
		int ix = (int)Math.abs(dx);
		int iy = (int)Math.abs(dy);
		int inc = (ix >= iy) ? ix : iy;

		
		//颜色增量
		float[] increment = new float[3];
		
		//线性插值颜色
		float[] clrLinear = {color0[0],color0[1],color0[2]};

		
		increment[0] = (color1[0] - color0[0]) / inc;
		increment[1] = (color1[1] - color0[1]) / inc;
		increment[2] = (color1[2] - color0[2]) / inc;
		
		g.setColor(new Color(clrLinear[0],clrLinear[1],clrLinear[2]));

		g.drawLine(x1,y1,x1,y1);
		
		int x = 0;
		int y = 0;
		boolean bPlot = false;
		
		int plotX = x1;
		int plotY = y1;
		
		for(int i = 0;i <= inc;i++) 
		{
			x += ix;
			y += iy;
			
			bPlot = false;
			
			if(x > inc)
			{
				bPlot = true;
				
				x -= inc;
				
				if(dx > 0) plotX++;
				if(dx < 0) plotX--;
			}
			
			if(y > inc)
			{
				bPlot = true;
				
				y -= inc;
				
				if(dy > 0) plotY++;
				if(dy < 0) plotY--;
			}
			
			if(bPlot)
			{
				clrLinear[0] += increment[0];
				clrLinear[1] += increment[1];
				clrLinear[2] += increment[2];
				g.setColor(new Color(clrLinear[0],clrLinear[1],clrLinear[2]));
				g.drawLine(plotX,plotY,plotX,plotY);
			}
		}
		
		g.setColor(colorOld);
	}

	//统一方法,即能绘制任何给定的线型,也能绘制一条颜色渐变的线型
	public void drawLine(Graphics g,int x1,int y1,int x2,int y2,short lineMode,int renderModel)
	{
		
		int dx = x2 - x1;
		int dy = y2 - y1;
		
		int ix = (int)Math.abs(dx);
		int iy = (int)Math.abs(dy);
		int inc = (ix >= iy) ? ix : iy;

		Color colorOld = g.getColor();
		
		//颜色增量
		float[] increment = new float[3];
		
		//线性插值颜色
		float[] clrLinear = {color0[0],color0[1],color0[2]};

		if(renderModel == BasicPrimitive.LINE_GRADUAL_COLOR)
		{
			increment[0] = (color1[0] - color0[0]) / inc;
			increment[1] = (color1[1] - color0[1]) / inc;
			increment[2] = (color1[2] - color0[2]) / inc;
		}
		g.setColor(new Color(clrLinear[0],clrLinear[1],clrLinear[2]));

		
		int maskBit = 0;
		short mask = (short)0x0001;
		
		
		
		if((mask & lineMode) != 0)
			g.drawLine(x1,y1,x1,y1);
		mask = (short)(mask << 1);
		maskBit++;
		
		int x = 0;
		int y = 0;
		boolean bPlot = false;
		
		int plotX = x1;
		int plotY = y1;
		
		for(int i = 0;i <= inc;i++) 
		{
			x += ix;
			y += iy;
			
			bPlot = false;
			
			if(x > inc)
			{
				bPlot = true;
				
				x -= inc;
				
				if(dx > 0) plotX++;
				if(dx < 0) plotX--;
			}
			
			if(y > inc)
			{
				bPlot = true;
				
				y -= inc;
				
				if(dy > 0) plotY++;
				if(dy < 0) plotY--;
			}
			
			if(bPlot)
			{
				if(renderModel == BasicPrimitive.LINE_GRADUAL_COLOR)
				{
					clrLinear[0] += increment[0];
					clrLinear[1] += increment[1];
					clrLinear[2] += increment[2];
					g.setColor(new Color(clrLinear[0],clrLinear[1],clrLinear[2]));
				}
				else
				{
					g.setColor(new Color(color0[0],color0[1],color0[2]));
				}
				
				boolean bMask = ((mask & lineMode) != 0);
			
				if(bMask)g.drawLine(plotX,plotY,plotX,plotY);
				
				mask <<= 1;
				
				maskBit++;
				
				if(maskBit == 16)
				{
					maskBit = 0;
					mask = (short)0x0001;
				}
			
			}
			
		}
		g.setColor(colorOld);
	}

	
	private int round(float a)
	{
		return ((int)(a + 0.5f));
	}
	
}
