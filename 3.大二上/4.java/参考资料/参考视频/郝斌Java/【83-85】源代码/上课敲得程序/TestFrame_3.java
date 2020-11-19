import java.awt.*;

public class TestFrame_3 
{
    public static void main(String args[]) {
        MyFrame f1 = 
            new MyFrame(100,100,200,200,Color.BLUE);  //一个类A中定义的属性的类型可以就是类A本身
        MyFrame f2 = 
            new MyFrame(300,100,200,200,Color.YELLOW);
        MyFrame f3 = 
            new MyFrame(100,300,200,200,Color.GREEN);
        MyFrame f4 = 
            new MyFrame(300,300,200,200,Color.MAGENTA);
    }
}


class MyFrame extends Frame
{
    public static int id = 0;
    
    MyFrame(int x,int y,int w,int h,Color color)
    {
        super("MyFrame " + (++id));
        setBackground(color);
        setLayout(null); //设置布局管理器为空
        setBounds(x,y,w,h);
        setVisible(true);
    }
}
