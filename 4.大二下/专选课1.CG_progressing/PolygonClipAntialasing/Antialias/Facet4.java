
import java.awt.Point;

import java.awt.Color;

public class Facet4 extends Facet
{
	int index[] = new int[4];
	
	public Facet4(int vertex0,int vertex1,int vertex2,int vertex3)
	{
		this.type = 4;
		this.index[0] = vertex0;
		this.index[1] = vertex1;
		this.index[2] = vertex2;
		this.index[3] = vertex3;
	}
	
	
	
}
