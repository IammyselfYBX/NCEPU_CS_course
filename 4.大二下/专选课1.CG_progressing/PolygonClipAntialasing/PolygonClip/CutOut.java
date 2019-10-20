import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class CutOut extends Applet implements ActionListener,MouseListener,MouseMotionListener
{
	TextField tf;
	String str="";
	int startX,startY;
	int endX,endY;
	int count=1;
	int i=0;
	int m;
	int intflag=0;
	boolean dragflag=false;
	boolean drawflag=true;
	int x[]=new int[100];
	int y[]=new int[100];
	int outx[]=new int[100];
	int outy[]=new int[100];
	int ix,iy;
	int outlenght;
	int tempx[]=new int[100];
	int tempy[]=new int[100];
	boolean flag=true;
	boolean cutflag=false;
	
	public void init()
	{
		
		this.setLayout(new BorderLayout());
		Panel pl=new Panel();
		this.setBackground(Color.black);
		pl.setBackground(Color.green);
		this.add("South",pl);
		
		tf=new TextField(30);
		tf.setBackground(Color.white);
		this.add("North",tf);

		Button b=null;
	  b=new Button("上边裁剪");
	  b.addActionListener(this);
	  pl.add(b);
	  b=new Button("左边裁剪");
	  b.addActionListener(this);
	  pl.add(b);
        b=new Button("右边裁剪");
	  b.addActionListener(this);
	  pl.add(b);
	  b=new Button("下边裁剪");
	  b.addActionListener(this);
	  pl.add(b);
	  b=new Button("全裁剪");
	  b.addActionListener(this);
	  pl.add(b);
	  b=new Button("重画");
	  b.addActionListener(this);
	  pl.add(b);
	  
	  addMouseListener(this);
	  addMouseMotionListener(this);
	  
	  str="请按下鼠标左键并拖拉，画出矩形裁剪窗口";
	  tf.setText(str);
	}
	
	public void start()
	{
		this.setEnabled(true);
	}
	
	public void stop()
	{
		this.setEnabled(false);
	}
	
	public void mousePressed(MouseEvent e)
	{ 
		if(count==1)
		{
		  startX=e.getX();
		  startY=e.getY();
		}
	}
	public void mouseReleased(MouseEvent e)
	{
              Graphics g=getGraphics();

		if(count==1)
		{
			count=count+1;
			endX=e.getX();
			endY=e.getY();
			intflag=3;
			
	g.setColor(Color.yellow);
  	g.drawRect(endX,endY,2,2);
  	g.drawRect(startX,startY,2,2);

	str="请单击鼠标左键，画裁剪多边形，单击鼠标右键结束";
	tf.setText(str);
		}
	}
  public void mouseEntered(MouseEvent e){}
  public void mouseExited(MouseEvent e){}
  public void mouseClicked(MouseEvent e)
  {
  	Graphics g2=getGraphics();
  	
  	if((count!=1)&&(dragflag==true)&&(drawflag==true))
  	{
  		if(e.getModifiers()==MouseEvent.BUTTON3_MASK)
  	  {
  	  	g2.setColor(Color.white);
  	  	g2.drawLine(x[i-1],y[i-1],x[0],y[0]);
  	  	drawflag=false;
  	  	str="请选择裁剪按钮";
	      tf.setText(str);
	      cutflag=true;
	      intflag=1;
	     update(g2);
  	   draw1(g2);
  	 g2.drawLine(x[0],y[0],x[i-1],y[i-1]);

  	  }
  	  else if(e.getModifiers()==MouseEvent.BUTTON1_MASK)
  	  {
  		x[i]=e.getX();
  		y[i]=e.getY();
  		g2.setColor(Color.yellow);
  		g2.drawRect(x[i],y[i],2,2);
  		if(i>0)
  		{
  			g2.setColor(Color.white);
  	    g2.drawLine(x[i-1],y[i-1],x[i],y[i]);
  		}
  		i=i+1;
  	  }
  	}
  }
    
  public void mouseDragged(MouseEvent e)
  {
  	int x0,y0;
  	int x1,y1;
  	
  	if(count==1)
  	{
  		Graphics g1=getGraphics();
  	g1.setColor(Color.yellow);
  	g1.drawRect(startX,startY,2,2);

  	  x0=e.getX();
  	  y0=e.getY();
  	  x1=x0-startX;
  	  y1=y0-startY;
  	  
  	  update(g1);
  	g1.setColor(Color.red);
  	  g1.drawRect(startX,startY,x1,y1);
  	  dragflag=true;
  	}
 
  }
  
  public void mouseMoved(MouseEvent e)
  {
  	Graphics g1=getGraphics();
  	g1.setColor(Color.white);
  	int movex,movey;

  	  if(count!=1&&i>0&&cutflag==false)
  	  {
  	    movex=e.getX();
  	    movey=e.getY();

  	    update(g1);
  	    draw1(g1);
  	  
  	    g1.drawLine(x[i-1],y[i-1],movex,movey);
  	  }

  }
  
  public void draw1(Graphics g)
  {
  	int j;
    g.setColor(Color.red);
  	g.drawRect(startX,startY,endX-startX,endY-startY);
  	g.setColor(Color.yellow);
  	g.drawRect(startX,startY,2,2);
  	g.drawRect(endX,endY,2,2);
  	
  	g.setColor(Color.yellow);
  	for(j=0;j<i;j++)
  	{
       g.drawRect(x[j],y[j],2,2);
  	}
  	
    g.setColor(Color.white);
    for(j=0;j<i-1;j++)
    {
  	g.drawLine(x[j],y[j],x[j+1],y[j+1]);
    }
  }

  
  public void draw(Graphics g)
  {
  	int j;
    g.setColor(Color.red);
  	g.drawRect(startX,startY,endX-startX,endY-startY);
  	g.setColor(Color.yellow);
  	g.drawRect(startX,startY,2,2);
  	g.drawRect(endX,endY,2,2);
  	
  	g.setColor(Color.yellow);
  	for(j=0;j<i;j++)
  	{
  		g.drawRect(x[j],y[j],2,2);
  	}
  	
    g.setColor(Color.white);
    for(j=0;j<i-1;j++)
    {
  	g.drawLine(x[j],y[j],x[j+1],y[j+1]);
    }
  	g.drawLine(x[0],y[0],x[i-1],y[i-1]);
  }
  
  //上裁剪
  public void cutUp()
  {
  	int j;
  	Graphics g3=getGraphics();
  	
  	if(cutflag==true)
  	{
  	  if(flag==true)
  	  {
  	    SutherlandHodgmanPolygonClip(i,x,y,startX,startY,endX,startY);
  	    g3.setColor(Color.green);
  	    for(j=0;j<outlenght-1;j++)
  	    {
  	      g3.drawLine(outx[j],outy[j],outx[j+1],outy[j+1]);
  	    }
  	    g3.drawLine(outx[j],outy[j],outx[0],outy[0]);
  	    for(j=0;j<outlenght;j++)
  	    {
  	  	  tempx[j]=outx[j];
  		    tempy[j]=outy[j];
  	    }
  	    m=outlenght;
  	    flag=false;
  	  }
  	  else
  	  {
  		  update(g3);
  	    draw(g3);
  	
  	    SutherlandHodgmanPolygonClip(m,tempx,tempy,startX,startY,endX,startY);

  	    g3.setColor(Color.green);
  	    for(j=0;j<outlenght-1;j++)
  	    {
  	      g3.drawLine(outx[j],outy[j],outx[j+1],outy[j+1]);
  	    }
  	    g3.drawLine(outx[j],outy[j],outx[0],outy[0]);
  	    for(j=0;j<outlenght;j++)
  	    {
  	  	  tempx[j]=outx[j];
  		    tempy[j]=outy[j];
  	    }
  	    m=outlenght;
  	  }
  	}
  	else
  	{
  		str="请先画裁剪窗口，按下鼠标左键并拖拉";
	    tf.setText(str);
  	}
  }
  
  //左裁剪  
  public void cutLeft()
  {
  	int j;
  	Graphics g3=getGraphics();
  	if(cutflag==true)
  	{
  	  if(flag==true)
  	  {
  		  SutherlandHodgmanPolygonClip(i,x,y,startX,-startY,startX,-endY);
  	    g3.setColor(Color.green);
  	    for(j=0;j<outlenght-1;j++)
  	    {
  	      g3.drawLine(outx[j],outy[j],outx[j+1],outy[j+1]);
  	    }
  	    g3.drawLine(outx[j],outy[j],outx[0],outy[0]);
  	    
  	    for(j=0;j<outlenght;j++)
  	    {
  	  	  tempx[j]=outx[j];
  		    tempy[j]=outy[j];
  	    }
  	    m=outlenght;
  	    flag=false;
  	  }
  	  else
  	  {
  	    update(g3);
  	    draw(g3);
  	
  	    SutherlandHodgmanPolygonClip(m,tempx,tempy,startX,-startY,startX,-endY);

  	    g3.setColor(Color.green);
  	    for(j=0;j<outlenght-1;j++)
  	    {
  	      g3.drawLine(outx[j],outy[j],outx[j+1],outy[j+1]);
  	    }
  	    g3.drawLine(outx[j],outy[j],outx[0],outy[0]);
  	   
  	    for(j=0;j<outlenght;j++)
  	    {
  	  	  tempx[j]=outx[j];
  		    tempy[j]=outy[j];
  	    }
  	    m=outlenght;
  	  }
  	}
  	else
  	{
  	str="请先画裁剪窗口，按下鼠标左键并拖拉";
	    tf.setText(str);
  	}
  }
  
  //右裁剪  
  public void cutRight()
  {
  	int j;
  	Graphics g3=getGraphics();
  	if(cutflag==true)
  	{
  	  if(flag==true)
  	  {
  	    SutherlandHodgmanPolygonClip(i,x,y,endX,startY,endX,endY);
  	    g3.setColor(Color.green);
  	    for(j=0;j<outlenght-1;j++)
  	    {
  	      g3.drawLine(outx[j],outy[j],outx[j+1],outy[j+1]);
  	      
  	    }
  	    g3.drawLine(outx[j],outy[j],outx[0],outy[0]);
  	   
  	    for(j=0;j<outlenght;j++)
  	    {
  	  	  tempx[j]=outx[j];
  		    tempy[j]=outy[j];
  	    }
  	    m=outlenght;
  	    flag=false;
  	  }
  	  else
  	  {
  		  update(g3);
  	    draw(g3);
  	
  	    SutherlandHodgmanPolygonClip(m,tempx,tempy,endX,startY,endX,endY);

  	    g3.setColor(Color.green);
  	    for(j=0;j<outlenght-1;j++)
  	    {
  	      g3.drawLine(outx[j],outy[j],outx[j+1],outy[j+1]);
  	     
  	    }
  	    g3.drawLine(outx[j],outy[j],outx[0],outy[0]);
  	   
  	    for(j=0;j<outlenght;j++)
  	    {
  	  	  tempx[j]=outx[j];
  		    tempy[j]=outy[j];
  	    }
  	    m=outlenght;
  	  }
  	}
  	else
  	{
  		str="请先画裁剪窗口，按下鼠标左键并拖拉";
	    tf.setText(str);
  	}
  }
  
  //下裁剪 
  public void cutDown()
  {
  	int j;
  	Graphics g3=getGraphics();
  	
  	if(cutflag==true)
  	{
  	  if(flag==true)
  	  {
  	    SutherlandHodgmanPolygonClip(i,x,y,-startX,endY,-endX,endY);
  
  	    g3.setColor(Color.green);
  	    for(j=0;j<outlenght-1;j++)
  	    {
  	      g3.drawLine(outx[j],outy[j],outx[j+1],outy[j+1]);
         
  	    }
  	    g3.drawLine(outx[j],outy[j],outx[0],outy[0]);
  	   
  	    for(j=0;j<outlenght;j++)
  	    {
  	  	  tempx[j]=outx[j];
  		    tempy[j]=outy[j];
  	    }
  	    m=outlenght;
  	    flag=false;
  	  }
  	  else
  	  {
  		  update(g3);
  	    draw(g3);
  	
  	    SutherlandHodgmanPolygonClip(m,tempx,tempy,-startX,endY,-endX,endY);

  	    g3.setColor(Color.green);
  	    for(j=0;j<outlenght-1;j++)
  	    {
  	      g3.drawLine(outx[j],outy[j],outx[j+1],outy[j+1]);
          
  	    }
  	    g3.drawLine(outx[j],outy[j],outx[0],outy[0]);
        
  	    for(j=0;j<outlenght;j++)
  	    {
  	  	  tempx[j]=outx[j];
  		    tempy[j]=outy[j];
  	    }
  	    m=outlenght;
  	  }
  	}
  	else
  	{
  		str="请先画裁剪窗口，按下鼠标左键并拖拉";
	    tf.setText(str);
  	}
  }
  
  //全裁剪   
  public void cut()
  {
  	cutLeft();
  	cutUp();
  	cutRight();
  	cutDown();
  }
  
  //求多边形的边SP与裁剪边的交点I
  public void Intersect(int sx,int sy,int px,int py,int cx0,int cy0,int cx1,int cy1)
  {
  	if(cy0==cy1)
  	{
  		iy=cy0;
  		ix=sx+(int)((double)(cy0-sy)*(double)(px-sx)/(double)(py-sy)+0.5);
  	}
  	else
  	{
  		ix=cx0;
  		iy=sy+(int)((double)(cx0-sx)*(double)(py-sy)/(double)(px-sx)+0.5);
  	}
  }
  
  //测试顶点与裁剪边的关系
  public boolean Inside(int tx,int ty,int cx0,int cy0,int cx1,int cy1)
  {
  	if(cx1>cx0)
  	{
  		if(ty>=cy0) return true;
  	}
  	else if(cx1<cx0)
  	{
  		if(ty<=cy0) return true;
  	}
  	else if(cy1>cy0)
  	{
  		if(tx<=cx0) return true;
  	}
  	else if(cy1<cy0)
  	{
  		if(tx>=cx0) return true;
  	}
  	return false;
  }
  
  //将新的顶点加入到结果多边形顶点数组中
  public void Output(int newx,int newy)
  {
  	outx[outlenght]=newx;
  	outy[outlenght]=newy;
  	outlenght=outlenght+1;
  }
  
  //Sutherland-Hodgman算法
  public void SutherlandHodgmanPolygonClip(int inlenght,int xx[],int yy[],int cx0,int cy0,int cx1,int cy1)
  {
  	int sx,sy,px,py;
  	int j;
  	
  	outlenght=0;
  	
  	sx=xx[inlenght-1];
  	sy=yy[inlenght-1];
  	
  	for(j=0;j<inlenght;j++)
  	{
  		px=xx[j];
  		py=yy[j];
  		
  		if(Inside(px,py,cx0,cy0,cx1,cy1))
  		{
  			if(Inside(sx,sy,cx0,cy0,cx1,cy1))
  			{
  				Output(px,py);
  			}
  			else
  			{
  				Intersect(sx,sy,px,py,cx0,cy0,cx1,cy1);
  				Output(ix,iy);
  				Output(px,py);
  			}
  		}
  		else if(Inside(sx,sy,cx0,cy0,cx1,cy1))
  		{
  			Intersect(sx,sy,px,py,cx0,cy0,cx1,cy1);
  			Output(ix,iy);
  		}
  		sx=px;
  		sy=py;
  	}
  }
  
  public void paint(Graphics g)
  {
  	if(intflag==1) draw(g);
  	else if(intflag==2)
  	{
  		draw(g);
  		g.setColor(Color.green);
  		for(int j=0;j<outlenght-1;j++)
  		g.drawLine(outx[j],outy[j],outx[j+1],outy[j+1]);
  		g.drawLine(outx[0],outy[0],outx[outlenght-1],outy[outlenght-1]);
  	}
  	else if(intflag==3)
  	{
  		g.setColor(Color.yellow);
  	        g.drawRect(endX,endY,2,2);
  	        g.drawRect(startX,startY,2,2);
  	        g.setColor(Color.red);
  	        g.drawRect(startX,startY,endX-startX,endY-startY);
  	}		
  }
	
	public void actionPerformed(ActionEvent ev)
	{
		String label=ev.getActionCommand();

		if(label.equals("重画"))
		{
			repaint();
			dragflag=false;
			drawflag=true;
			flag=true;
			cutflag=false;
			intflag=0;
      i=0;
      count=1;
      str="请按下鼠标左键并拖拉，画出矩形裁剪窗口";
	    tf.setText(str);
		}
			
		if(label.equals("上边裁剪"))
		{
			cutUp();
			intflag=2;
		}

		if(label.equals("左边裁剪"))
		{
			cutLeft();
			intflag=2;
		}
		
		if(label.equals("右边裁剪"))
		{
			cutRight();
			intflag=2;
		}
		
		if(label.equals("下边裁剪"))
		{
			cutDown();
			intflag=2;
		}
		
		if(label.equals("全裁剪"))
		{
			cut();
			intflag=2;
		}
	}		
}