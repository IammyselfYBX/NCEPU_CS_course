import java.awt.*;

public class TestPanel_1 
{
     public static void main(String args[]) 
     {
     	 Frame f = new Frame("Java Frame with Panel");
         Panel p = new Panel(); 
         f.setLayout(null); 
         f.setBounds(300,300,500,500); //Frame�������������������Ļ���Ե�
         f.setBackground(new Color(100,100,102));  //������ɫ�������ֱ�ʹ��һ���ֽڱ�ʾ
         p.setBounds(300/2, 300/2, 500/2, 500/2);  //Panel�������������Panel���ڵĸ����ڶ��Ե�
         p.setBackground(new Color(204,204,255));
         f.add(p);  // ����java.awt.Container���е�һ�������� �ѵ�ǰPanel������ӵ���ǰFrame������
         f.setVisible(true);
    }
}
