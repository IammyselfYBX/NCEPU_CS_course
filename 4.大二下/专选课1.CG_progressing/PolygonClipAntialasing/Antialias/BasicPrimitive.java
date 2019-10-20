
import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;

public class BasicPrimitive
{
	//线模式
	public static final short LINE_SOLID = (short)0xFFFF;
	public static final short LINE_DOT = (short)0x0101;
	public static final short LINE_DASH = (short)0x0F0F;
	public static final short LINE_DASH_DOT = (short)0x1C47;
	
	//线的着色方式,即计算模型
	public static final int LINE_SINGLE_COLOR = 0;
	public static final int LINE_GRADUAL_COLOR = 1;
	
	
	
	//填充的计算模型
	public static final int FILL_FALT = 0;
	public static final int FILL_GOURAUD_SMOOTH = 1;
	
	//多边形填充模式
	public static final short FILL_SOLID = (short)0xFFFF;
	

	
	
		/*
		集1的线模式:
			0x8000	0xC000	0xE000	0xF000
			0xF800	0xFC00	0xFE00	0xFF00
			0xFF80	0xFFC0	0xFFE0	0xFF00
			0xFFF8	0xFFFC	0xFFFE	
		集2的线模式:
			0x8080	0xC0C0	0xE0E0	0xF0F0
			0xF8F8	0xFCFC	0xFEFE
		集3的线模式:
			0x8888	0xCCCC	0xEEEE	0xAAAA
			0xE4E4	0xF6F6	0xFF18	0xFFFF
	*/

	public BasicPrimitive()
	{
	
	}
}
