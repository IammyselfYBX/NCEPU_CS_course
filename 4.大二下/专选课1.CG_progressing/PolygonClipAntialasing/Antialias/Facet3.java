
import java.awt.Point;
import java.awt.Color;

public class Facet3 extends Facet
{
	int index[] = new int[3];

	public Facet3(int vertex0,int vertex1,int vertex2)
	{
		this.type = 3;
		this.index[0] = vertex0;
		this.index[1] = vertex1;
		this.index[2] = vertex2;
		
	}	
	
}
