/*	
	2008��10��18��16:27:16
	GridLayout�Ĺ��캯��
		public GriLayout(int, int); 
	���÷�
*/
import java.awt.*;

public class TestGridLayout 
{
	public static void main(String args[]) 
	{
        Frame f = new Frame("GridLayout Example");
        
		Button b1 = new Button("b1");
        Button b2 = new Button("b2");
        Button b3 = new Button("b3");
        Button b4 = new Button("b4");
        Button b5 = new Button("b5");
        Button b6 = new Button("b6");
        f.setLayout (new GridLayout(2,10)); //��һ�������Ƕ��٣�������ľ��Ƕ����У������Ǳ��������������Զ����������
        f.add(b1);        
        f.add(b2);
        f.add(b3);        
        f.add(b4);
        f.add(b5);        
        f.add(b6);
        
        f.pack();  //����Ѹ����ע�͵������������ͱ��һ��ֻ�б�������С���ڣ�ժ��API����pack() - �� java.awt.Window �еķ����� �����˴��ڵĴ�С�����ʺ������������ѡ��С�Ͳ��֡� ���±�Ҳ���ǰ����������������������������ɵ�������Ĵ�С�Զ���������Ĵ�С �����������������        
        f.setVisible(true);
	}
}
