import java.awt.*;

public class TestPanel_1 
{
     public static void main(String args[]) 
     {
     	 Frame f = new Frame("Java Frame with Panel");
         Panel p = new Panel(); 
         f.setLayout(null); 
         f.setBounds(300,300,500,500); //Frame的设置是相对于整个屏幕而言的
         f.setBackground(new Color(100,100,102));  //三个颜色分量都分别使用一个字节表示
         p.setBounds(300/2, 300/2, 500/2, 500/2);  //Panel的设置是相对于Panel所在的父窗口而言的
         p.setBackground(new Color(204,204,255));
         f.add(p);  // 这是java.awt.Container类中的一个方法， 把当前Panel对象添加到当前Frame对象中
         f.setVisible(true);
    }
}
