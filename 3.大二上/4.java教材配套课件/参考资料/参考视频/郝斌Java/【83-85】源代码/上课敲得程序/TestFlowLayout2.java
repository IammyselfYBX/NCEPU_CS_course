import java.awt.*;
public class TestFlowLayout2 {
    public static void main(String args[]) {
        Frame f = new Frame("Java Frame");
        FlowLayout l = 
            new FlowLayout(FlowLayout.LEFT, 30, 30); //第二个参数400表示的是f容器中的组件之间的行间距，即左右间距；   第三个参数表示的是f容器中的组件之间的垂直间距，即上下距离的间距
        f.setLayout(l); 
        f.setLocation(300,400);
        f.setSize(300,100);  //如果尺寸设置太小，则7个按钮就显示不全，不过可以利用鼠标拉大窗口，就会看到完整的7个按钮!
        f.setBackground(new Color(255,222,255));
        for(int i = 1; i<=7; i++){
            f.add(new Button("BUTTON"));
        }
        f.setVisible(true);
    }
}
