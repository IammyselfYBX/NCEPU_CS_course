import java.awt.*;
public class TestFlowLayout2 {
    public static void main(String args[]) {
        Frame f = new Frame("Java Frame");
        FlowLayout l = 
            new FlowLayout(FlowLayout.LEFT, 30, 30); //�ڶ�������400��ʾ����f�����е����֮����м�࣬�����Ҽ�ࣻ   ������������ʾ����f�����е����֮��Ĵ�ֱ��࣬�����¾���ļ��
        f.setLayout(l); 
        f.setLocation(300,400);
        f.setSize(300,100);  //����ߴ�����̫С����7����ť����ʾ��ȫ��������������������󴰿ڣ��ͻῴ��������7����ť!
        f.setBackground(new Color(255,222,255));
        for(int i = 1; i<=7; i++){
            f.add(new Button("BUTTON"));
        }
        f.setVisible(true);
    }
}
