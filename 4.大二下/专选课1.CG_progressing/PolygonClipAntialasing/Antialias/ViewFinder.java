
//	取景器类,该取景器没有进行剪切功能处理,因而是有缺陷的
//	但当眼睛位于场景的外接球之外时,非常有用

import java.awt.Point;

public class ViewFinder
{
	Point viewCenter = new Point(0,0);	//世界坐标的原点透视至Java窗口中的点
	float theta = 0.0f;
	float phi = 0.0f;
	float viewDistance = 10.0f;		//视点至世界坐标原点的距离
	float screenDistance = 10.0f;	//视点至屏幕的距离
	
	float scale_x = 1.0f;
	float scale_y = 1.0f;
	
	public ViewFinder()
	{}
	
	public ViewFinder(float theta,float phi,float viewDistance,float screenDistance,Point viewCenter)
	{
		this.theta = theta;
		this.phi = phi;
		this.viewDistance = viewDistance;
		this.screenDistance = screenDistance;
		this.viewCenter = viewCenter;
		
	
	}
	
	public ViewFinder(float theta,float phi,float viewDistance,float screenDistance,Point viewCenter,float scale_x,float scale_y)
	{
		this.theta = theta;
		this.phi = phi;
		this.viewDistance = viewDistance;
		this.screenDistance = screenDistance;
		this.viewCenter = viewCenter;
		
		this.scale_x = scale_x;
		this.scale_y = scale_y;
		
	}
	
	
	
	public void setViewport(Point viewCenter,float scale_x,float scale_y)
	{
		this.viewCenter = viewCenter;
		this.scale_x = scale_x;
		this.scale_y = scale_y;
	}
	
	public Point  viewport(Point toViewport)
	{
		
		return (new Point((int)(toViewport.x * scale_x) + viewCenter.x,(int)(toViewport.y * scale_y) + viewCenter.y));
		
	}
}
