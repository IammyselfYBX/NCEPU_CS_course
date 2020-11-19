import java.awt.*;

public class TestPaint {
	public static void main(String[] args) {
		new PaintFrame().launchFrame();
	}
}

class PaintFrame extends Frame {
	
	public void launchFrame() {
		setBounds(200,200,640,480);
		setVisible(true);
	}
	
	//当Frame需要重画时，paint方法就会被自动调用, 重画就是重新显示时，重新画出来
	//所谓重画包括：Ｆｒａｍｅ对象第一次在显示器上被显示出来的时候，Ｆｒａｍｅ窗口被其他窗口盖住但又变成当前窗口的时候，改变窗口大小的时候
	public void paint(Graphics g) {  //该方法的原型是: public void paint(Graphics g);       paint()是Container类的方法，当容器对象被重画时，paint方法就会被容器对象自动被调用, Frame对象建立之后，它内部就有一个画笔了，一旦Frame对象所代表的窗口被重画，Frame对象就会自动的把它自己的画笔发送给paint()方法的形参, 我们所要做的就是重写paint()方法就可以了
							//形参 (Graphics g) 千万不要生，否则就不是重写Frame的paint方法了 
		Color c = g.getColor();  //18行  g就是画笔，g.getColor()就是得到当前画笔的颜色
		g.setColor(Color.RED);  //设置画笔为红色
		g.fillOval(50, 50, 500, 30);  //填充实心的椭圆   前两个参数表示左上顶点的坐标， 后两个参数表示宽度和高度，这4个参数合起来表示由这4个参数所确定的长方形中的最大内置椭圆, 当然如果后两个参数的值一样的化，那就变成了一个内置圆了，要知道圆只不过是椭圆的一种特殊形式而已嘛  O(∩_∩)O哈哈~
				//drawOval() 绘制空心椭圆  fillOval()绘制实心椭圆,实心椭圆的颜色是由g.getColor()确定的
		g.setColor(Color.green);
		g.fillRect(80,80,40,40);  //前两个参数表示左上顶点的坐标
		g.drawLine(300, 300, 400, 400); //这是一根很细的线， 
		g.fillRect(100, 400, 400, 5); //把实心矩形的高度设低一点就变成了一根粗线了
		g.setColor(c); //24行  18行：这只画笔在使用之前就已经有颜色了，所以在修改颜色之前最好把以前的颜色保存起来    24行： 再恢复到以前的颜色    这是良好的编程 
	}	
}