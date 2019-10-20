
//import java.awt.*;
import java.awt.image.*;

public class SceneAccumulator 
{
	public SceneAccumulator(){}	
	
	
	//累积像素,取平均值
	public static  void accumulate(int[][] src,int[] dst )
	{
		//抖动次数
		int ditherTimes = src.length;
		int nTotal = src[0].length;
 
		ColorModel colorModel = ColorModel.getRGBdefault();
		

		for(int j = 0;j < nTotal;j++)
		{
			int r = 0;
			int g = 0;
			int b = 0;

			for(int i = 0;i < ditherTimes;i++)
			{
				r += colorModel.getRed(src[i][j]);
				g += colorModel.getGreen(src[i][j]);
				b += colorModel.getBlue(src[i][j]);
		
			}
			
			r /= ditherTimes;
			g /= ditherTimes;
			b /= ditherTimes;
			
			dst[j] = (0xFF000000 | (( r << 16 ) | ( g << 8 ) | b ));
		}
	}
	

	
}
