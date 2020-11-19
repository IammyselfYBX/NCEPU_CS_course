/**
 * ����:̹����Ϸ��5.0[]
 * 1.����̹��.
 * 2.�ҵ�̹�˿������������ƶ�
 * 3.���Է����ӵ�,�ӵ�����(���5)
 * 4.���ҵ�̹�˻��е���̹��ʱ�����˾���ʧ(��ը��Ч��)
 * 5.�ұ����к���ʾ��ըЧ��
 * 6.��ֹ����̹���ص��˶�(*)
 *    6.1�������ж��Ƿ���ײ�ĺ���д��EnemyTank��
 * 7.���Էֹ�(*)
 * 	  7.1��һ����ʼ��Panle,����һ���յ�
 *    7.2��˸Ч��
 * 8.����������Ϸ��ʱ����ͣ�ͼ�����*��
 * 	  8.1���û������ͣʱ���ӵ����ٶȺ�̹���ٶ���Ϊ0,����̹�˵ķ���Ҫ�仯
 * 9.���Լ�¼��ҵĳɼ���*��
 *    9.1���ļ���.
 *    9.2��дһ����¼�࣬��ɶ���Ҽ�¼
 *    9.3����ɱ��湲�����˶���������̹�˵Ĺ���.
 *    9.4�����˳���Ϸ,���Լ�¼��ʱ�ĵ���̹�����꣬�����Իָ�
 * 10.java��β��������ļ���*��
 * 		10.1�������ļ��Ĳ���
 */
package com.test3;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
public class MyTankGame3 extends JFrame implements ActionListener {

	MyPanel mp=null;
	
	//����һ����ʼ���
	MyStartPanel msp=null;
	
	//��������Ҫ�Ĳ˵�
	JMenuBar jmb=null;
	//��ʼ��Ϸ
	JMenu jm1=null;
	JMenuItem jmil=null;
	//�˳�ϵͳ
	JMenuItem jmi2=null;
	//�����˳�
	JMenuItem jmi3=null;
	JMenuItem jmi4=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTankGame3 mtg=new MyTankGame3();
	}
	
	//���캯��
	public MyTankGame3()
	{
		//mp=new MyPanel();
		
		//����mp�߳�
		//Thread t=new Thread(mp);
		//t.start();
		//this.add(mp);
		//ע�����
		//this.addKeyListener(mp);
		
		//�����˵����˵�ѡ��
		jmb=new JMenuBar();
		jm1 =new JMenu("��Ϸ(G)");
		//���ÿ�ݷ�ʽ
		jm1.setMnemonic('G');
		jmil =new JMenuItem("��ʼ����Ϸ(N)");
		jmi2 =new JMenuItem("�˳���Ϸ(E)");
		jmi3 =new JMenuItem("�����˳���Ϸ(C)");
		jmi4 =new JMenuItem("�����Ͼ���Ϸ(S)");
		
		//ע�����
		jmi4.addActionListener(this);
		jmi4.setActionCommand("conGame");
		
		//ע�����
		jmi3.addActionListener(this);
		jmi3.setActionCommand("saveExit");
		
		jmi2.addActionListener(this);
		jmi2.setActionCommand("exit");
		jmi2.setMnemonic('E');
		//��jmil��Ӧ
		jmil.addActionListener(this);
		jmil.setActionCommand("newgame");
		jm1.add(jmil);
		jm1.add(jmi2);
		jm1.add(jmi3);
		jm1.add(jmi4);
		jmb.add(jm1);
		
		msp=new MyStartPanel();
		Thread t=new Thread(msp);
		t.start();
		
		this.setJMenuBar(jmb);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(msp);
		this.setSize(600, 500);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//���û���ͬ�ĵ��������ͬ�Ĵ���
		if(arg0.getActionCommand().equals("newgame"))
		{
			//����ս�����
			mp=new MyPanel("newGame");
			
			//����mp�߳�
			Thread t=new Thread(mp);
			t.start();
			//��ɾ���ɵĿ�ʼ���
			this.remove(msp);
			this.add(mp);
			//ע�����
			this.addKeyListener(mp);
			//��ʾ,ˢ��JFrame
			this.setVisible(true);
			
			
		}else if(arg0.getActionCommand().equals("exit"))
		{
			//�û�������˳�ϵͳ�Ĳ˵�
			//������ٵ�������.
			Recorder.keepRecording();
			
			System.exit(0);
		}//�Դ����˳�����
		else if(arg0.getActionCommand().equals("saveExit"))
		{
			System.out.println("111");
			System.out.println("mp.ets.size="+mp.ets.size());
			//����
			Recorder rd=new Recorder();
			rd.setEts(mp.ets);
			//������ٵ��˵������͵��˵�����
			rd.keepRecAndEnemyTank();
			
			//�˳�
			System.exit(0);
		}else if(arg0.getActionCommand().equals("conGame"))
		{
			//����ս�����
			mp=new MyPanel("con");
		
			
			//����mp�߳�
			Thread t=new Thread(mp);
			t.start();
			//��ɾ���ɵĿ�ʼ���
			this.remove(msp);
			this.add(mp);
			//ע�����
			this.addKeyListener(mp);
			//��ʾ,ˢ��JFrame
			this.setVisible(true);
		}
	}

}
//����һ����ʾ����
class MyStartPanel extends JPanel implements Runnable
{
	int times=0;
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		//��ʾ��Ϣ
		
		if(times%2==0)
		{
			g.setColor(Color.yellow);
			//������Ϣ������
			Font myFont=new Font("������κ",Font.BOLD,30);
			g.setFont(myFont);
			g.drawString("stage: 1", 150, 150);
		}
		
	}

	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			//����
			try {
				
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
			times++;
			
			//�ػ�
			this.repaint();
		}
		
	}
	
}

//�ҵ����
class MyPanel extends JPanel implements KeyListener,Runnable
{

	//����һ���ҵ�̹��
	Hero hero=null;
	
	
	
	
	//������˵�̹����
	Vector<EnemyTank> ets=new Vector<EnemyTank>();
	Vector<Node> nodes=new Vector<Node>();
	
	//����ը������
	Vector<Bomb> bombs=new Vector<Bomb>();
	
	int enSize=3;
	
	//��������ͼƬ,����ͼƬ�������һ��ը��
	Image image1=null;
	Image image2=null;
	Image image3=null;
	
	//���캯��
	public MyPanel(String flag)
	{
		
		//�ָ���¼ 
		Recorder.getRecoring();
		
		hero=new Hero(100,100);
		
		
		
		
		if(flag.equals("newGame"))
		{
			//��ʼ�����˵�̹��
			for(int i=0;i<enSize;i++)
			{
				//����һ�����˵�̹�˶���
				EnemyTank et=new EnemyTank((i+1)*50,0);
				et.setColor(0);
				et.setDirect(2);
				//��MyPanel�ĵ���̹�����������õ���̹��
				et.setEts(ets);
				
				//�������˵�̹��
				Thread t=new Thread(et);
				t.start();
				//������̹�����һ���ӵ�
				Shot s=new Shot(et.x+10,et.y+30,2);
				//���������̹��
				et.ss.add(s);
				Thread t2=new Thread(s);
				t2.start();
				//����
				ets.add(et);
			}
		}else{
			
			System.out.println("������");
			nodes=new Recorder().getNodesAndEnNums();
			//��ʼ�����˵�̹��
			for(int i=0;i<nodes.size();i++)
			{
				Node node=nodes.get(i);
				//����һ�����˵�̹�˶���
				EnemyTank et=new EnemyTank(node.x,node.y);
				et.setColor(0);
				et.setDirect(node.direct);
				//��MyPanel�ĵ���̹�����������õ���̹��
				et.setEts(ets);
				
				//�������˵�̹��
				Thread t=new Thread(et);
				t.start();
				//������̹�����һ���ӵ�
				Shot s=new Shot(et.x+10,et.y+30,2);
				//���������̹��
				et.ss.add(s);
				Thread t2=new Thread(s);
				t2.start();
				//����
				ets.add(et);
			}
		}
		
		
		try {
			image1=ImageIO.read(new File("bomb_1.gif"));
			image2=ImageIO.read(new File("bomb_2.gif"));
			image3=ImageIO.read(new File("bomb_3.gif"));
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		//���ſ�ս����
		AePlayWave apw=new AePlayWave("./111.wav");
		apw.start();
		
		//��ʼ��ͼƬd
//		image1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
//		image2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
//		image3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
	}
	
	
	//������ʾ��Ϣ
	public void showInfo(Graphics g)
	{
		//������ʾ��Ϣ̹��(��̹�˲�����ս��)
		this.drawTank(80,330, g, 0, 0);
		g.setColor(Color.black);
		g.drawString(Recorder.getEnNum()+"", 110, 350);
		this.drawTank(130, 330, g, 0, 1);
		g.setColor(Color.black);
		g.drawString(Recorder.getMyLife()+"", 165, 350);
		
		//������ҵ��ܳɼ�
		g.setColor(Color.black);
		Font f=new Font("����",Font.BOLD,20);
		g.setFont(f);
		g.drawString("�����ܳɼ�", 420, 30);
		
		this.drawTank(420, 60, g, 0, 0);
		
		g.setColor(Color.black);
		g.drawString(Recorder.getAllEnNum()+"", 460, 80);
	}
	
	//����paint
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		
		//������ʾ��Ϣ
		this.showInfo(g);
		
		//�����Լ���̹��
		if(hero.isLive)
		{
			this.drawTank(hero.getX(), hero.getY(), g, this.hero.direct, 1);
		}
		//��ss,��ȡ��ÿ���ӵ���������
		for(int i=0;i<hero.ss.size();i++)
		{
			Shot myShot=hero.ss.get(i);
			
			//�����ӵ�,����һ���ӵ�
			if(myShot!=null&&myShot.isLive==true)
			{
				g.draw3DRect(myShot.x, myShot.y, 1, 1,false);
			}
			if(myShot.isLive==false)
			{
				//��ss��ɾ�������ӵ�
				hero.ss.remove(myShot);
			}
			
		}
		
		
		
		//����ը��
		for(int i=0;i<bombs.size();i++)
		{
			System.out.println("bombs.size()="+bombs.size());
			
			//ȡ��ը��
			Bomb b=bombs.get(i);
			
			if(b.life>6)
			{
				g.drawImage(image1, b.x, b.y, 30, 30, this);
			}else if(b.life>3)
			{
				g.drawImage(image2, b.x, b.y, 30, 30, this);
			}else{
				g.drawImage(image3, b.x, b.y, 30, 30, this);
			}
			
			//��b������ֵ��С
			b.lifeDown();
			//���ը������ֵΪ0,�ͰѸ�ը����bombs����ȥ��
			if(b.life==0)
			{
				bombs.remove(b);
			}
			
			
		}
		
		//�������˵�̹��
		for(int i=0;i<ets.size();i++)
		{
			EnemyTank et=ets.get(i);
			
			if(et.isLive)
			{
			
				this.drawTank(et.getX(), et.getY(), g, et.getDirect(), 0);
				//�ٻ������˵��ӵ�
				//System.out.println("̹���ӵ���:"+et.ss.size());
				for(int j=0;j<et.ss.size();j++)
				{
					//ȡ���ӵ�
					Shot enemyShot=et.ss.get(j);
					if(enemyShot.isLive)
					{
						//System.out.println("�� "+i+"̹�˵� "+j+"���ӵ�x="+enemyShot.x);
						g.draw3DRect(enemyShot.x, enemyShot.y, 1, 1,false);
					}else{
						//������˵�̹�������ʹ�Vectorȥ��
						et.ss.remove(enemyShot);
					}
				}
			}
		}
		
		
	}
	
	//���˵�̹���Ƿ������
	public void hitMe()
	{
		//ȡ��ÿһ�����˵�̹��
		for(int i=0;i<this.ets.size();i++)
		{
			//ȡ��̹��
			EnemyTank et=ets.get(i);
			
			//ȡ��ÿһ���ӵ�
			for(int j=0;j<et.ss.size();j++)
			{
				//ȡ���ӵ�
				Shot enemyShot=et.ss.get(j);
				if(hero.isLive)
				{
					if(this.hitTank(enemyShot, hero))
					{
						
					}
				}
			}
		}
	}
	
	
	//�ж��ҵ��ӵ��Ƿ���е��˵�̹��
	public void hitEnemyTank()
	{
		//�ж��Ƿ���е��˵�̹��
		for(int i=0;i<hero.ss.size();i++)
		{
			//ȡ���ӵ� 
			Shot myShot=hero.ss.get(i);
			//�ж��ӵ��Ƿ���Ч
			if(myShot.isLive)
			{
				//ȡ��ÿ��̹�ˣ������ж�
				for(int j=0;j<ets.size();j++)
				{
					//ȡ��̹��
					EnemyTank et=ets.get(j);
					
					if(et.isLive)
					{
						if(this.hitTank(myShot, et))
						{
							//���ٵ�������
							Recorder.reduceEnNum();
							//�����ҵļ�¼
							Recorder.addEnNumRec();
						}
					}
					
				}
			}
		}
	}
	
	//дһ������ר���ж��ӵ��Ƿ���е���̹��
	public boolean hitTank(Shot s,Tank et)
	{
		boolean b2=false;
		
		//�жϸ�̹�˵ķ���
		switch(et.direct)
		{
		//�������̹�˵ķ������ϻ�������
		case 0:
		case 2:
			if(s.x>et.x&&s.x<et.x+20&&s.y>et.y&&s.y<et.y+30)
			{
				//����
				//�ӵ�����
				s.isLive=false;
				//����̹������
				et.isLive=false;
				b2=true;
				//����һ��ը��,����Vector
				Bomb b=new Bomb(et.x,et.y);
				//����Vector
				bombs.add(b);
				
			}
			
			break;
		case 1:
		case 3:
			if(s.x>et.x&&s.x<et.x+30&&s.y>et.y&&s.y<et.y+20)
			{
				//����
				//�ӵ�����
				s.isLive=false;
				//����̹������
				et.isLive=false;
				b2=true;
				//����һ��ը��,����Vector
				Bomb b=new Bomb(et.x,et.y);
				//����Vector
				bombs.add(b);
				
			}
		}
		
		return b2;
		
	}
	
	//����̹�˵ĺ���(��չ)
	public void drawTank(int x,int y,Graphics g,int direct,int type)
	{
		//�ж���ʲô���͵�̹��
		switch(type)
		{
		case 0:
			g.setColor(Color.cyan);
			break;
		case 1:
			g.setColor(Color.yellow);
			break;
		}
		
		//�жϷ���
		switch(direct)
		{
		//����
		case 0:
			//�����ҵ�̹��(��ʱ�ٷ�װ��һ������)
			//1.������ߵľ���
			g.fill3DRect(x, y, 5, 30,false);
			//2.�����ұ߾���
			g.fill3DRect(x+15,y , 5, 30,false);
			//3.�����м����
			g.fill3DRect(x+5,y+5 , 10, 20,false);
			//4.����Բ��
			g.fillOval(x+5, y+10, 10, 10);
			//5.������
			g.drawLine(x+10, y+15, x+10, y);
			break;
		case 1:
			//��Ͳ����
			//�����������
			g.fill3DRect(x, y, 30, 5,false);
			//��������ľ���
			g.fill3DRect(x, y+15, 30, 5, false);
			//�����м�ľ���
			g.fill3DRect(x+5, y+5, 20, 10, false);
			//����Բ��
			g.fillOval(x+10, y+5, 10, 10);
			//������
			g.drawLine(x+15, y+10, x+30, y+10);
			break;
		case 2:
			//����
			//�����ҵ�̹��(��ʱ�ٷ�װ��һ������)
			//1.������ߵľ���
			g.fill3DRect(x, y, 5, 30,false);
			//2.�����ұ߾���
			g.fill3DRect(x+15,y , 5, 30,false);
			//3.�����м����
			g.fill3DRect(x+5,y+5 , 10, 20,false);
			//4.����Բ��
			g.fillOval(x+5, y+10, 10, 10);
			//5.������
			g.drawLine(x+10, y+15, x+10, y+30);
			break;
		case 3:
			//����
			
			//�����������
			g.fill3DRect(x, y, 30, 5,false);
			//��������ľ���
			g.fill3DRect(x, y+15, 30, 5, false);
			//�����м�ľ���
			g.fill3DRect(x+5, y+5, 20, 10, false);
			//����Բ��
			g.fillOval(x+10, y+5, 10, 10);
			//������
			g.drawLine(x+15, y+10, x, y+10);
			break;
			
		}
		
		
	}

	//�����´��� a ��ʾ���� s ��ʾ �� w ��ʾ����  d��ʾ��
	
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getKeyCode()==KeyEvent.VK_W)
		{
			//�����ҵ�̹�˵ķ���
			this.hero.setDirect(0);
			this.hero.moveUp();
			
		}else if(arg0.getKeyCode()==KeyEvent.VK_D)
		{
			//����
			this.hero.setDirect(1);
			this.hero.moveRight();
		}else if(arg0.getKeyCode()==KeyEvent.VK_S)
		{
			//����
			this.hero.setDirect(2);
			this.hero.moveDown();
		}else if(arg0.getKeyCode()==KeyEvent.VK_A)
		{
			//����
			this.hero.setDirect(3);
			this.hero.moveLeft();
		}
		
		if(arg0.getKeyCode()==KeyEvent.VK_J)
		{
			//�ж�����Ƿ���j
			
			//����
			//System.out.println("this.hero.ss.size()="+this.hero.ss.size());
			if(this.hero.ss.size()<=4)
			{
				this.hero.shotEnemy();
			}
			
		}
		
		
		
		
		//�������»���Panel
		this.repaint();
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void run() {
		// TODO Auto-generated method stub
		//ÿ��100����ȥ�ػ�
		while(true)
		{
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
			
			this.hitEnemyTank();
			//�������жϵ��˵��ӵ��Ƿ������
			this.hitMe();

			
			//�ػ�
			this.repaint();
		}
	}
}


