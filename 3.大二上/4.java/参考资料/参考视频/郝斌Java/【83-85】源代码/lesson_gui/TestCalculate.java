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
	private String strOper = null;   //18��  strOper������¼������+����-����*����/����,��Ϊ���ǵ��"="��ťʱ���޷�ͨ�����¼��õ��ϴ�����ִ�еĵ�����+����-����*����/����������������Ҫ����һ������strOper����¼����"="֮ǰ���ϴ�ִ�еĲ���
	
	
	public void launch()
	{
		setTitle("�±���Ƶļ�����");
		tf = new TextField(30);
		tf.setBackground(Color.GREEN);
		//setLayout(new BorderLayout());  //FrameĬ�ϵĲ��ֹ���������BorderLayout
		add(tf, BorderLayout.NORTH);
		Panel p = new Panel(new GridLayout(4, 4, 5, 5));
		for (int i=0; i<10; ++i)
		{
			Button bn = new Button("" + i);
			bn.setActionCommand("����");
			p.add(bn);
			bn.addActionListener(new MyMonitor());			
		}
		
		Button bnAdd = new Button("+");  
		p.add(bnAdd);
		bnAdd.setActionCommand("��������");
		bnAdd.addActionListener(new MyMonitor());
		
		Button bnSub = new Button("-");  
		p.add(bnSub);
		bnSub.setActionCommand("��������");
		bnSub.addActionListener(new MyMonitor());
		
		Button bnMult = new Button("*"); 
		bnMult.addActionListener(new MyMonitor()); 
		p.add(bnMult);
		bnMult.setActionCommand("��������");
		
		Button bnDiv = new Button("/");  
		p.add(bnDiv);
		bnDiv.setActionCommand("��������");
		bnDiv.addActionListener(new MyMonitor());
		
		Button bnEq = new Button("=");  
		p.add(bnEq);
		bnEq.setActionCommand("=");
		bnEq.addActionListener(new MyMonitor());
		
		Button bnClear = new Button("����");  
		p.add(bnClear);
		bnClear.setActionCommand("����");
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
			//����Ƕ�=��ť�ĵ����������������Ҫ�õ��ϴζ����������Ƶ���Ϣ����Ϊ�����¼���ֻ�ܵõ���ť��ǩ����Ϣ= �� ��ť������������=�� �޷��õ��ϴ�ִ�еĵ�����+����-����*����/����������������Ҫ��������һ������������¼�����������Ƶ���Ϣ���μ�18�д���
			/*actionPerformed()�����㷨���£�
				��һ��	���Ǳ����ȵ�ͨ��e�õ���ť�Ķ�����������strAc�Ͱ�ť��ǩ�ַ�����
						��ϢstrLab
				�ڶ���  Ȼ��ͨ���жϰ�ť�Ķ�����������strAc��ִ�в�ͬ�Ĳ���������
						���strAc��"����"��������Ƕ�0-9��ť�ĵ��������� �����str1 ���� str2��ֵ
						���strAc��"��������"��������Ƕ�"+" "-" "*" "/"��ť�ĵ��������������Ǳ���ðѰ�ť��ǩ�ַ���strLb��ֵ��������strOper, ע�ⲻ�ܰ�strAc����strOper, ��Ϊ��ʱstrAc��ֵ��"��������"  
						���strAc��"="�� �򡣡�����������
						���strAc��"����",�򡣡�����������
			
			*/
			
			
			String strAc = e.getActionCommand();
			Button bn = (Button)e.getSource();
			String strLb = bn.getLabel();
			
			if (strAc.equals("����"))
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
			else if (strAc.equals("��������"))  //�����+ - * / ���� 
			{
				strOper = strLb;  //118   ǧ��Ҫд���� strOper = strAc;  ��Ϊ�����Ҫ��ִ�еĻ�����ʱstrAc��ֵһ����"��������", ������Ҫ����+ - * / ��������Ҫ���ǰ�ť��ǩ�ַ��ܵ���Ϣ
				firstFlag = false;
			}
			else if (strAc.equals("="))
			{
				result();
			}
			else if (strAc.equals("����"))
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
		str1 = String.valueOf(num3);   //����д���� str1 = str2;
		str2 = "";
		//firstFlag = false;	  //���д������ʡ��	
	}	
}
