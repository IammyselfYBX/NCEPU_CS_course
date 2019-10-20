


import java.awt.Color;


public class Edge extends SubObject
{
	int index[] = new int[2];
	
	//记录与该边相邻的两个面的序号
	int residence[] = new int[2];
	
	boolean visibility = true;
		
	ColorFloat color = new ColorFloat(0.0f,0.0f,0.0f,1.0f);
	
	public Edge(int vertex0,int vertex1)
	{
		this.type = 2;
		this.index[0] = vertex0;
		this.index[1] = vertex1;
	}
	
	public Edge(int vertex0,int vertex1,int adjacent_facet_1,int adjacent_facet_2)
	{
		this.type = 2;
		this.index[0] = vertex0;
		this.index[1] = vertex1;
		this.residence[0] = adjacent_facet_1;
		this.residence[1] = adjacent_facet_2;
	}
}
