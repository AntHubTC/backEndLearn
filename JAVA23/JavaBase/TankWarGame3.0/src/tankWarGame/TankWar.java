package tankWarGame;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author boringman
 *�����̹�˴�ս����
 *This is main class of Tank War
 */

public class TankWar extends Frame{

	/**
	 *����Ϸ����������
	 */
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 600;
	
	public static final Color WALLCOLOR = new Color(74,62,13);
	public int currentMap = 0;
	
	public Random r = new Random();
	public Tank myTank = new Tank(10,30,true,Direction.STOP,this);
	
	public List<Wall> walls = new ArrayList<Wall>();
	public List<Explode> explodes = new ArrayList<Explode>();
	public List<Missile> missiles = new ArrayList<Missile>();
	public List<Tank> tanks = new ArrayList<Tank>();
	
	private Image offScreenImage = null;

	private Blood b = null;
	
	private static final boolean ISPLAYBGSND = false;
	private static Sound bgSnd = null;
	static{
		bgSnd = new Sound(TankWar.class.getClassLoader().getResource("sound/TankWarBgSound.wav").getFile());
	}
	
	public void lanuchFrame()
	{
		this.setLocation(100, 100);
		this.setSize(GAME_WIDTH, GAME_HEIGHT);
		this.setTitle("Tank War");
		this.setBackground(Color.GREEN);
		this.addWindowListener(
			new WindowAdapter()
			{
				@Override
				public void windowClosing(WindowEvent e) {
					// TODO Auto-generated method stub
					System.exit(0);
				}
				
			}
		);//��Ӵ��ڹر��¼�
		this.setResizable(false);//������ı䴰�ڴ�С
		
		this.addKeyListener(new KeyMonitor());
		
		this.setVisible(true);
		
		new Thread(new PaintThread()).start();
	}
	
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		if(offScreenImage == null)
		{
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.GREEN);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		/*
		g.drawString("Missiles count:"+missiles.size(), 10, 50);
		g.drawString("explodes count:"+explodes.size(), 10, 70);
		g.drawString("tanks    count:"+tanks.size(), 10, 90);
		g.drawString("tank     life:"+myTank.getLife(), 10, 110);
		*/
		
		//draw walls
		for(int i=0; i<walls.size(); i++)
		{
			walls.get(i).draw(g);
		}
		
		//����̹�˶���
		if(tanks.size() <= 0)
		{
			if(bgSnd.isStop && ISPLAYBGSND)//�Ƿ�Ҫ���ű�������
			{
				bgSnd.play();
			}
			
			currentMap = (++currentMap)%4;
			myTank.x = myTank.y = 0;//̹�˻�ԭ����λ��
			missiles.removeAll(missiles);//�Ƴ���ͼ�����е��ӵ�
			explodes.removeAll(explodes);//�Ƴ���ͼ�ϵ����б�ըЧ��
			b = new Blood();
			addWallToStage(currentMap);
			
			for(int i=0;i<20;i++)//����̹������
			{
				//Tank t = new Tank(100+40*(i+1), 580, false,Direction.D, this);
				Tank t = new Tank(r.nextInt(TankWar.GAME_WIDTH),r.nextInt(TankWar.GAME_HEIGHT), false,Direction.D, this);
				
				/*
				for(int j=0,k = 0; j<tanks.size()-1 || k<walls.size()-1; j=j<tanks.size()-1?j+1:j,k=k<walls.size()?k+1:k)//�����̹���Ƿ���ײ,�����ײ���ڻ���Position
				{
					while(j !=0 && k != 0 && t.collidesWithTank(tanks.get(j)) || t.collideWithWal(walls.get(k)))//���
					{
						t.x = r.nextInt(TankWar.GAME_WIDTH);
						t.y = r.nextInt(TankWar.GAME_HEIGHT);
					}
				}
				*/
				
				/*
				//������㷨��ʱ�临�Ӷȸߣ�����û��ȫ�Ľ����ײ����
				for(int j=0; j<tanks.size(); j++)//�����̹���Ƿ���ײ,�����ײ���ڻ���Position
					for(int k = 0; k<walls.size(); k++)
						while(t.collidesWithTank(tanks.get(j)) || t.collideWithWal(walls.get(k)))//���
						{
							t.x = r.nextInt(TankWar.GAME_WIDTH);
							t.y = r.nextInt(TankWar.GAME_HEIGHT);
						}
				*/
				boolean isR = true;
				int num =0;
				while(isR)
				{
					isR = false;
					for(int j=0; j<tanks.size(); j++)//�����̹���Ƿ���ײ,�����ײ���ڻ���Position
					{
							while(t.collidesWithTank(tanks.get(j)))//���
							{
								isR = true;
							}
							if(isR) break;
					}
					if(!isR)
					{
						for(int k = 0; k<walls.size(); k++)
						{
							if(t.collideWithWal(walls.get(k)))
							{
								isR = true;
							}
							if(isR) break;
						}
					}
					
					if(isR)
					{	
						t.x = r.nextInt(TankWar.GAME_WIDTH-50)+1;
						t.y = r.nextInt(TankWar.GAME_HEIGHT-50)+1;
						System.out.println(isR+","+t.x+","+t.y+","+num);
						num++;
						//if(num == 3)
						///{
						//	t.x = 60;
						//	t.y = TankWar.GAME_HEIGHT-100;
						//	break;
						//}
					}
				}//end while
				t.setGoodTank(myTank);
				tanks.add(t);
			}
		}
		
		for(int i = 0;i<missiles.size();i++)
		{
			Missile m = missiles.get(i);
			m.hitTanks(tanks);
			m.hitTank(myTank);
			for(int j=0; j<walls.size(); j++)
			{
				m.hitWall(walls.get(j));
			}
			//if(!m.isLive())
			//{
				// //System.out.println(m.isLive());
				//missiles.remove(m);//û��������ȥ��
			//}
			//else 
			m.draw(g);
		}
		
		for(int i=0; i<tanks.size();i++)
		{
			Tank t = tanks.get(i);
			for(int j=0; j<walls.size(); j++)
			{
				t.collideWithWal(walls.get(j));
			}
			t.collidesWithTank(myTank);
			t.collidesWithTanks(tanks);
			t.draw(g);
		}
		
		myTank.draw(g);
		
		for(int i=0; i<explodes.size(); i++)
		{
			Explode e = explodes.get(i);
			e.draw(g);
		}
		
		myTank.collidesWithTanks(tanks);
		for(int j=0; j<walls.size(); j++)
		{
			myTank.collideWithWal(walls.get(j));
		}
		
		if(myTank.eat(b))
		{
			b = new Blood();
		}
		b.daw(g);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TankWar tc = new TankWar();
		tc.lanuchFrame();
	}
	
	public class PaintThread implements Runnable
	{

		@Override
		public void run() {
			while(true)
			{
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public class KeyMonitor extends KeyAdapter
	{

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			myTank.keyRealease(e);
		}

		@Override
		public void keyPressed(KeyEvent e) {
			myTank.keyPressed(e);
		}
		
	}
	

	private void addWallToWalls(Wall[] w)
	{
		walls.removeAll(walls);
		
		for(int i = 0; i<w.length; i++)
		{
			walls.add(w[i]);
		}
	}
	
	public void addWallToStage(int wallClass)
	{
		switch(wallClass)
		{
		case 1:
			{
				Wall[] w = {
						new Wall(400,100,this.GAME_WIDTH,this.GAME_HEIGHT, WALLCOLOR,this),
						new Wall(100,0,20,80,WALLCOLOR,this),
						new Wall(0,60,60,20,WALLCOLOR,this),
				};
				addWallToWalls(w);
				for(int i=100; i<TankWar.GAME_WIDTH; i+=260)
				{
					for(int j= 60;j<TankWar.GAME_HEIGHT; j+=160)
					{
						walls.add(new Wall(i, j, 200, 20,WALLCOLOR, this));
					}
				}
				break;
			}
		case 2:
			{
				Wall[] w = {
						new Wall(100,0,20,80,WALLCOLOR,this),
						new Wall(0,60,60,20,WALLCOLOR,this),
						new Wall(300,60,20,400,WALLCOLOR,this),
						new Wall(700,60,20,500,WALLCOLOR,this)
				};
				addWallToWalls(w);
				for(int i=100; i<TankWar.GAME_WIDTH; i+=260)
				{
					for(int j= 60;j<TankWar.GAME_HEIGHT; j+=160)
					{
						walls.add(new Wall(i, j, 20, 100, WALLCOLOR, this));
						walls.add(new Wall(i, j, 100, 20, WALLCOLOR, this));
					}
				}
			}
			break;
		case 3:
		{
			Wall[] w = {
					new Wall(100,0,20,80, WALLCOLOR,this),
					new Wall(0,60,60,20, WALLCOLOR,this),
			};
			addWallToWalls(w);
			for(int k = 0; k<TankWar.GAME_HEIGHT; k+=80)
			{
				for(int i=100,j= 120; i<TankWar.GAME_WIDTH; i+=100,j+=20)
				{
					//walls.add(new Wall(i, j, 20, 100, WALLCOLOR, this));
					walls.add(new Wall(i, k+j, 100, 20, WALLCOLOR, this));
				}
			}
		}
		break;
		case 4:
		{
			Wall[] w = {
					new Wall(100,0,20,400, WALLCOLOR,this),
					new Wall(0,60,60,20, WALLCOLOR,this),
					new Wall(0,120,60,20, WALLCOLOR,this),
					new Wall(0,180,60,20, WALLCOLOR,this),
					new Wall(0,240,60,20, WALLCOLOR,this),
					new Wall(0,300,60,20, WALLCOLOR,this),
					new Wall(0,360,60,20, WALLCOLOR,this),
					new Wall(0,420,60,20, WALLCOLOR,this),
					new Wall(150,300,20,300, WALLCOLOR,this),
					new Wall(210,520,200,20, WALLCOLOR,this),
					new Wall(160,100,300,20, WALLCOLOR,this),
					new Wall(160,200,300,20, WALLCOLOR,this),
					new Wall(160,300,300,20, WALLCOLOR,this),
					new Wall(160,400,300,20, WALLCOLOR,this),
					new Wall(310,60,20,200, WALLCOLOR,this),
					new Wall(490,0,20,300, WALLCOLOR,this),
					new Wall(550,0,20,300, WALLCOLOR,this),
					new Wall(610,0,20,300, WALLCOLOR,this),
					new Wall(670,0,20,300, WALLCOLOR,this),
					new Wall(730,0,20,300, WALLCOLOR,this),
					new Wall(530,400,20,30, WALLCOLOR,this),
					new Wall(590,400,20,30, WALLCOLOR,this),
					new Wall(650,400,20,30, WALLCOLOR,this),
					new Wall(710,400,20,30, WALLCOLOR,this),
					new Wall(530,460,20,30, WALLCOLOR,this),
					new Wall(590,460,20,30, WALLCOLOR,this),
					new Wall(650,460,20,30, WALLCOLOR,this),
					new Wall(710,460,20,30, WALLCOLOR,this),
					new Wall(530,520,20,30, WALLCOLOR,this),
					new Wall(590,520,20,30, WALLCOLOR,this),
					new Wall(650,520,20,30, WALLCOLOR,this),
					new Wall(710,520,20,30, WALLCOLOR,this),
					new Wall(530,580,20,30, WALLCOLOR,this),
					new Wall(590,580,20,30, WALLCOLOR,this),
					new Wall(650,580,20,30, WALLCOLOR,this),
					new Wall(710,580,20,30, WALLCOLOR,this),
			};
			addWallToWalls(w);
		}
		break;
		}
	}
	
}
