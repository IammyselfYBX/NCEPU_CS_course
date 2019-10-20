import java.awt.*;
public class BorderRectangle extends Rectangle
{
	int x,y,width,height;
	Color color;
	public BorderRectangle(int x,int y,int width,int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		color = new Color(255,255,255);
	}
	
	public void setBkColor(Color color)
	{
		this.color = color;
	}
	
	public void draw(Graphics g)
	{
		
		
		Color colorOld = g.getColor();
		g.setColor(color);
		g.fillRect(x + 2,y + 2,width - 2,height - 2);
		
		g.setColor(new Color(128,128,128));
		g.drawLine(x,y,x + width,y);
		g.drawLine(x,y,x,y + height);
		
		g.setColor(Color.black);
		g.drawLine(x + 1,y + 1,x + width - 2,y + 1);
		g.drawLine(x + 1,y + 2,x + 1,y + height -1);
		
		g.setColor(new Color(180,180,180));
		g.drawLine(x + width -1,y + 1,x + width -1, y + height -1);
		g.drawLine(x + width -1,y + height -1,x + 2,y + height -1);
		
		g.setColor(Color.white);
		g.drawLine(x + width,y,x + width,y + height -1);
		g.drawLine(x + width,y + height,x + 1,y + height);
		
		g.setColor(colorOld);
		
	}
	
	
	
}
