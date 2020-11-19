import java.awt.*;
import java.awt.event.*;

public class TestCalculate
{
	public static void main(String[] args)
	{
		new Calculate().launch();
	}	
} 

class Calculate extends Frame
{
	private boolean firstFlag = true;
	private String str1 = "";
	private String str2 = "";
	private TextField tf = null;
	private String strOper = null;   //18行  strOper用来记录到底是+还是-还是*还是/操作,因为我们点击"="按钮时是无法通过该事件得到上次我们执行的到底是+还是-还是*还是/操作，所以我们需要定义一个属性strOper来记录单击"="之前的上次执行的操作
	
	
	public void launch()
	{
		setTitle("郝斌设计的计算器");
		tf = new TextField(30);
		tf.setBackground(Color.GREEN);
		//setLayout(new BorderLayout());  //Frame默认的布局管理器就是BorderLayout
		add(tf, BorderLayout.NORTH);
		Panel p = new Panel(new GridLayout(4, 4, 5, 5));
		for (int i=0; i<10; ++i)
		{
			Button bn = new Button("" + i);
			bn.setActionCommand("数字");
			p.add(bn);
			bn.addActionListener(new MyMonitor());			
		}
		
		Button bnAdd = new Button("+");  
		p.add(bnAdd);
		bnAdd.setActionCommand("算术操作");
		bnAdd.addActionListener(new MyMonitor());
		
		Button bnSub = new Button("-");  
		p.add(bnSub);
		bnSub.setActionCommand("算术操作");
		bnSub.addActionListener(new MyMonitor());
		
		Button bnMult = new Button("*"); 
		bnMult.addActionListener(new MyMonitor()); 
		p.add(bnMult);
		bnMult.setActionCommand("算术操作");
		
		Button bnDiv = new Button("/");  
		p.add(bnDiv);
		bnDiv.setActionCommand("算术操作");
		bnDiv.addActionListener(new MyMonitor());
		
		Button bnEq = new Button("=");  
		p.add(bnEq);
		bnEq.setActionCommand("=");
		bnEq.addActionListener(new MyMonitor());
		
		Button bnClear = new Button("清零");  
		p.add(bnClear);
		bnClear.setActionCommand("清零");
		bnClear.addActionListener(new MyMonitor());
		
		p.add(bnAdd);
		p.add(bnSub);
		p.add(bnMult);
		p.add(bnDiv);
		p.add(bnEq);
		p.add(bnClear);		
		
		add(p, BorderLayout.CENTER);
		setBounds(300, 300,300, 300);
		setBackground(Color.BLUE);
		setVisible(true);
		addWindowListener(  new WindowAdapter()
							  {
									@Override
									public void windowClosing(WindowEvent e)
									{
										System.exit(-1);
									} 				
							  }		
		);
	}
	
	class MyMonitor implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//如果是对=按钮的点击操作，则我们需要得到上次动作命令名称的信息，因为本次事件中只能得到按钮标签的信息= 和 按钮动作命令名称=， 无法得到上次执行的到底是+还是-还是*还是/操作，所以我们需要单独定义一个属性用来记录动作命令名称的信息，参见18行代码
			/*actionPerformed()方法算法如下：
				第一：	我们必须先得通过e得到按钮的动作命令名称strAc和按钮标签字符串的
						信息strLab
				第二：  然后通过判断按钮的动作命令名称strAc来执行不同的操作，即：
						如果strAc是"数字"，即如果是对0-9按钮的单击操作， 则更新str1 或者 str2的值
						如果strAc是"算术操作"，即如果是对"+" "-" "*" "/"按钮的单击操作，则我们必须得把按钮标签字符窜strLb的值赋给属性strOper, 注意不能把strAc赋给strOper, 因为此时strAc的值是"算术操作"  
						如果strAc是"="， 则。。。。。。略
						如果strAc是"清零",则。。。。。。略
			
			*/
			
			
			String strAc = e.getActionCommand();
			Button bn = (Button)e.getSource();
			String strLb = bn.getLabel();
			
			if (strAc.equals("数字"))
			{
				if (firstFlag)
				{
					str1 = str1 + strLb;   //103
					tf.setText(str1);
				}
				else
				{
					str2 = str2 + strLb;  //109
					tf.setText(str2);
				}
			}
			else if (strAc.equals("算术操作"))  //如果是+ - * / 操作 
			{
				strOper = strLb;  //118   千万不要写成了 strOper = strAc;  因为本语句要被执行的话，此时strAc的值一定是"算术操作", 我们需要的是+ - * / 即我们需要的是按钮标签字符窜的信息
				firstFlag = false;
			}
			else if (strAc.equals("="))
			{
				result();
			}
			else if (strAc.equals("清零"))
			{
				str1 = str2 = "";
				tf.setText("");
				firstFlag = true;
			}				
		}
	}
	
	public void result()
	{
		double num1 = Double.parseDouble(str1);
		double num2 = Double.parseDouble(str2);
		double num3 = 0;
		
		if (strOper.equals("+"))
		{
			num3 = num1 + num2;
		}
		else if (strOper.equals("-"))
		{
			num3 = num1 - num2;
		}
		else if (strOper.equals("*"))
		{
			num3 = num1 * num2;
		}
		else if (strOper.equals("/"))
		{
			num3 = num1 / num2;
		}
		
		tf.setText("" + num3);
		str1 = String.valueOf(num3);   //不能写成了 str1 = str2;
		str2 = "";
		//firstFlag = false;	  //本行代码可以省略	
	}	
}
