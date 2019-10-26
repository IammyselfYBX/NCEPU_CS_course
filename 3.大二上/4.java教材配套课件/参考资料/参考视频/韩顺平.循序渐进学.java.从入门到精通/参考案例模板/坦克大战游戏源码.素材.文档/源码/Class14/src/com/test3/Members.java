package com.test3;

import java.util.*;
import java.io.*;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

//播放声音的类
class AePlayWave extends Thread {

	private String filename;
	public AePlayWave(String wavfile) {
		filename = wavfile;

	}

	public void run() {

		File soundFile = new File(filename);

		AudioInputStream audioInputStream = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		} catch (Exception e1) {
			e1.printStackTrace();
			return;
		}

		AudioFormat format = audioInputStream.getFormat();
		SourceDataLine auline = null;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

		try {
			auline = (SourceDataLine) AudioSystem.getLine(info);
			auline.open(format);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		auline.start();
		int nBytesRead = 0;
		//这是缓冲
		byte[] abData = new byte[512];

		try {
			while (nBytesRead != -1) {
				nBytesRead = audioInputStream.read(abData, 0, abData.length);
				if (nBytesRead >= 0)
					auline.write(abData, 0, nBytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} finally {
			auline.drain();
			auline.close();
		}

	}

	
}

class Node{
	int x;
	int y;
	int direct;
	public Node(int x,int y,int direct)
	{
		this.x=x;
		this.y=y;
		this.direct=direct;
	}
}


//记录类,同时也可以保存玩家的设置
class Recorder
{
	//记录每关有多少敌人
	private static int enNum=20;
	//设置我有多少可以用的人
	private static int myLife=3;
	//记录总共消灭了多少敌人
	private static int allEnNum=0;
	//从文件中恢复记录点
	static Vector<Node>  nodes=new Vector<Node>();
	
	private static FileWriter fw=null;
	private static BufferedWriter bw=null;
	private static FileReader fr=null;
	private static BufferedReader br=null;
	
	private  Vector<EnemyTank> ets=new Vector<EnemyTank>();
	
	
	
	//完成读取认为
	public Vector<Node> getNodesAndEnNums()
	{
		try {
			fr=new FileReader("d:\\myRecording.txt");
			br=new BufferedReader(fr);
			String n="";
			//先读取第一行
			n=br.readLine();
			allEnNum=Integer.parseInt(n);
			while((n=br.readLine())!=null)
			{
				String []xyz=n.split(" "); 
				
				Node node=new Node(Integer.parseInt(xyz[0]),Integer.parseInt(xyz[1]),Integer.parseInt(xyz[2]));
				nodes.add(node);
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			try {
				//后打开则先关闭
				br.close();
				fr.close();
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		
		return nodes;
		
	}
	
	
	//保存击毁敌人的数量和敌人坦克坐标,方向
	
	public  void keepRecAndEnemyTank()
	{
		try {
			
			//创建
			fw=new FileWriter("d:\\myRecording.txt");
			bw=new BufferedWriter(fw);
			
			bw.write(allEnNum+"\r\n");
			
			System.out.println("size="+ets.size());
			//保存当前活的敌人坦克的坐标和方向
			for(int i=0;i<ets.size();i++)
			{
				//取出第一个坦克
				EnemyTank et=ets.get(i);
				
				if(et.isLive)
				{
					//活的就保存
					String recode=et.x+" "+et.y+" "+et.direct;
					
					//写入
					bw.write(recode+"\r\n");
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
		
			//关闭流
			try {
				//后开先关闭
				bw.close();
				fw.close();
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	}
	
	
	//从文件中读取，记录
	public static void getRecoring()
	{
		try {
			fr=new FileReader("d:\\myRecording.txt");
			br=new BufferedReader(fr);
			String n=br.readLine();
			allEnNum=Integer.parseInt(n);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			try {
				//后打开则先关闭
				br.close();
				fr.close();
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	}
	
	//把玩家击毁敌人坦克数量保存到文件中
	public static void keepRecording()
	{
		try {
			
			//创建
			fw=new FileWriter("d:\\myRecording.txt");
			bw=new BufferedWriter(fw);
			
			bw.write(allEnNum+"\r\n");
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
		
			//关闭流
			try {
				//后开先关闭
				bw.close();
				fw.close();
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	}
	
	public static int getEnNum() {
		return enNum;
	}
	public static void setEnNum(int enNum) {
		Recorder.enNum = enNum;
	}
	public static int getMyLife() {
		return myLife;
	}
	public static void setMyLife(int myLife) {
		Recorder.myLife = myLife;
	}
	
	//减少敌人数
	public static void reduceEnNum()
	{
		enNum--;
	}
	//消灭敌人
	public static void addEnNumRec()
	{
		allEnNum++;
	}
	public static int getAllEnNum() {
		return allEnNum;
	}
	public static void setAllEnNum(int allEnNum) {
		Recorder.allEnNum = allEnNum;
	}


	public  Vector<EnemyTank> getEts() {
		return ets;
	}


	public  void setEts(Vector<EnemyTank> ets1) {
		
		this.ets = ets1;
		System.out.println("ok");
	}
}

//炸弹类
class Bomb 
{
	//定义炸弹的坐标
	int x,y;
	//炸弹的生命
	int life=9;
	boolean isLive=true;
	public Bomb(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	//减少生命值
	public void lifeDown()
	{
		if(life>0)
		{
			life--;
		}else{
			this.isLive=false;
		}
		
	}
	
	
	
}

//子弹类
class Shot implements Runnable  {
	int x;
	int y;
	int direct;
	int speed=1;
	//是否还活着
	boolean isLive=true;
	public Shot(int x,int y,int direct)
	{
		this.x=x;
		this.y=y;
		this.direct=direct;
	}
	public void run() {
		
		while(true)
		{
			
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			switch(direct)
			{
			case 0:
				//上
				y-=speed;
				break;
			case 1:
				x+=speed;
				break;
			case 2:
				y+=speed;
				break;
			case 3:
				x-=speed;
				break;
			}
			
		//	System.out.println("子弹坐标x="+x+" y="+y);
			//子弹何时死亡???
			
			//判断该子弹是否碰到边缘.
			if(x<0||x>400||y<0||y>300)
			{
				this.isLive=false;
				break;
			}
		}
	}
}


//坦克类
class Tank
{
	//表示坦克的横坐标
	int x=0;
	//坦克纵坐标
	int y=0;
	
	//坦克方向
	//0表示上 1表示 右 2表示下  3表示左
	int direct=0;
	int color;
	
	boolean isLive=true;
	
	//坦克的速度
	int speed=1;
	public Tank(int x,int y)
	{
		this.x=x;
		this.y=y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
}

//敌人的坦克,把敌人做成线程类
class EnemyTank extends Tank implements Runnable
{
	
	int times=0;
	
	//定义一个向量，可以访问到MyPanel上所有敌人的坦克
	Vector<EnemyTank> ets=new Vector<EnemyTank>();
	
	//定义一个向量，可以存放敌人的子弹
	Vector<Shot> ss=new Vector<Shot>();
	//敌人添加子弹，应当在刚刚创建坦克和敌人的坦克子弹死亡后
	public EnemyTank(int x,int y)
	{
		super(x,y);	
	}
	
	//得到MyPanel的敌人坦克向量
	public void setEts(Vector<EnemyTank> vv)
	{
		this.ets=vv;
	}

	//判断是否碰到了别的敌人坦克
	public boolean isTouchOtherEnemy()
	{
		boolean b=false;
		
		
		switch(this.direct)
		{
		case 0:
			//我的坦克向上
			//取出所有的敌人坦克
			for(int i=0;i<ets.size();i++)
			{
				//取出第一个坦克
				EnemyTank et=ets.get(i);
				//如果不是自己
				if(et!=this)
				{
					//如果敌人的方向是向下或者向上
					if(et.direct==0||et.direct==2)
					{
						//左点
						if(this.x>=et.x&&this.x<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
						{
							return true;
						}
						if(this.x+20>=et.x&&this.x+20<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
						{
							return true;
						}
					}
					if(et.direct==3||et.direct==1)
					{
						if(this.x>=et.x&&this.x<=et.x+30&&this.y>=et.y&&this.y<=et.y+20)
						{
							return true;
						}
						if(this.x+20>=et.x&&this.x+20<=et.x+30&&this.y>=et.y&&this.y<=et.y+20)
						{
							return true;
						}
					}
				}
			}
			break;
		case 1:
			//坦克向右
			//取出所有的敌人坦克
			for(int i=0;i<ets.size();i++)
			{
				//取出第一个坦克
				EnemyTank et=ets.get(i);
				//如果不是自己
				if(et!=this)
				{
					//如果敌人的方向是向下或者向上
					if(et.direct==0||et.direct==2)
					{
						//上点
						if(this.x+30>=et.x&&this.x+30<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
						{
							return true;
						}
						//下点 
						if(this.x+30>=et.x&&this.x+30<=et.x+20&&this.y+20>=et.y&&this.y+20<=et.y+30)
						{
							return true;
						}
					}
					if(et.direct==3||et.direct==1)
					{
						if(this.x+30>=et.x&&this.x+30<=et.x+30&&this.y>=et.y&&this.y<=et.y+20)
						{
							return true;
						}
						if(this.x+30>=et.x&&this.x+30<=et.x+30&&this.y+20>=et.y&&this.y+20<=et.y+20)
						{
							return true;
						}
					}
				}
			}
			break;
		case 2:
			//坦克向下
			//取出所有的敌人坦克
			for(int i=0;i<ets.size();i++)
			{
				//取出第一个坦克
				EnemyTank et=ets.get(i);
				//如果不是自己
				if(et!=this)
				{
					//如果敌人的方向是向下或者向上
					if(et.direct==0||et.direct==2)
					{
						//我的左点
						if(this.x>=et.x&&this.x<=et.x+20&&this.y+30>=et.y&&this.y+30<=et.y+30)
						{
							return true;
						}
						//我的右点
						if(this.x+20>=et.x&&this.x+20<=et.x+20&&this.y+30>=et.y&&this.y+30<=et.y+30)
						{
							return true;
						}
					}
					if(et.direct==3||et.direct==1)
					{
						if(this.x>=et.x&&this.x<=et.x+30&&this.y+30>=et.y&&this.y+30<=et.y+20)
						{
							return true;
						}
						
						if(this.x+20>=et.x&&this.x+20<=et.x+30&&this.y+30>=et.y&&this.y+30<=et.y+20)
						{
							return true;
						}
					}
				}
			}
			break;
		case 3:
			//向左
			//取出所有的敌人坦克
			for(int i=0;i<ets.size();i++)
			{
				//取出第一个坦克
				EnemyTank et=ets.get(i);
				//如果不是自己
				if(et!=this)
				{
					//如果敌人的方向是向下或者向上
					if(et.direct==0||et.direct==2)
					{
						//我的上一点
						if(this.x>=et.x&&this.x<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
						{
							return true;
						}
						//下一点
						if(this.x>=et.x&&this.x<=et.x+20&&this.y+20>=et.y&&this.y+20<=et.y+30)
						{
							return true;
						}
					}
					if(et.direct==3||et.direct==1)
					{
						//上一点
						if(this.x>=et.x&&this.x<=et.x+30&&this.y>=et.y&&this.y<=et.y+20)
						{
							return true;
						}
						if(this.x>=et.x&&this.x<=et.x+30&&this.y+20>=et.y&&this.y+20<=et.y+20)
						{
							return true;
						}
					}
				}
			}
			break;
		}
		
		
		return b;
	}
	
	
	
	public void run() {
		// TODO Auto-generated method stub
		
		while(true)
		{
			
		
			switch(this.direct)
			{
			case 0:
				//说明坦克正在向上
				for(int i=0;i<30;i++)
				{
					if(y>0&&!this.isTouchOtherEnemy())
					{
						y-=speed;
					}
					try {
						Thread.sleep(50);
					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
				}
				break;
			case 1:
				//向右
				for(int i=0;i<30;i++)
				{
					//保证坦克不出边界
					if(x<400&&!this.isTouchOtherEnemy())
					{
						x+=speed;
					}
					try {
						Thread.sleep(50);
					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
				}
				break;
			case 2:
				//向下
				for(int i=0;i<30;i++)
				{
					if(y<300&&!this.isTouchOtherEnemy())
					{
						y+=speed;
					}
					try {
						Thread.sleep(50);
					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
				}
				break;
			case 3:
				//向左
				for(int i=0;i<30;i++)
				{
					if(x>0&&!this.isTouchOtherEnemy())
					{
						x-=speed;
					}
					try {
						Thread.sleep(50);
					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
				}
				break;
			
			}
			
			this.times++;
			
			if(times%2==0)
			{
				if(isLive)
				{
					if(ss.size()<5)
					{
						//System.out.println("et.ss.size()<5="+et.ss.size());
						Shot s=null;
						//没有子弹
						//添加
						switch(direct)
						{
						case 0:
							//创建一颗子弹
							 s=new Shot(x+10,y,0);
							//把子弹加入向量
							ss.add(s);
							break;
						case 1:
							s=new Shot(x+30,y+10,1);
							ss.add(s);
							break;
						case 2:
							 s=new Shot(x+10,y+30,2);
							ss.add(s);
							break;
						case 3:
							s=new Shot(x,y+10,3);
							ss.add(s);
							break;
						}
						
						//启动子弹
						Thread t=new Thread(s);
						t.start();
					}
				}
			}
			
			
			//让坦克随机产生一个新的方向
			this.direct=(int)(Math.random()*4);
			
			//判断敌人坦克是否死亡
			if(this.isLive==false)
			{
				//让坦克死亡后，退出线程.
				break;
			}
			
			
			
			
			
		}
		
	}
}

//我的坦克
class Hero extends Tank
{
	
	//子弹
	
	//Shot s=null;
	Vector<Shot> ss=new Vector<Shot>();
	Shot s=null;
	public Hero(int x,int y)
	{
		super(x,y);
		
		
	}
	
	//开火
	public void shotEnemy()
	{
		
		
		switch(this.direct)
		{
		case 0:
			//创建一颗子弹
			 s=new Shot(x+10,y,0);
			//把子弹加入向量
			ss.add(s);
			break;
		case 1:
			s=new Shot(x+30,y+10,1);
			ss.add(s);
			break;
		case 2:
			 s=new Shot(x+10,y+30,2);
			ss.add(s);
			break;
		case 3:
			s=new Shot(x,y+10,3);
			ss.add(s);
			break;
			
		}
		//启动子弹线程
		Thread t=new Thread(s);
		t.start();
		
	}
	
	
	//坦克向上移动
	public void moveUp()
	{
		y-=speed;
	}
	//坦克向右移动
	public void moveRight()
	{
		x+=speed;
	}
	
	//坦克向下移动
	public void moveDown()
	{
		y+=speed;
	}
	
	//向左
	public void moveLeft()
	{
		x-=speed;
	}
}