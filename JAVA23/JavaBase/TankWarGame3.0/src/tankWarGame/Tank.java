package tankWarGame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

/**
 * 
 * @author boringman
 *�����̹����
 *This is Tank class
 */

public class Tank {
	public int x;
	public int y;
	
	private int oldX;
	private int oldY;
	
	private static Random r = new Random();//�����������
	private static final int ROOT_STEP_RANDOM = 20;//��������ռ��ж�
	private static final int ROOT_STEP_LAST = 3;//���ٲ����ж�
	
	private int step = r.nextInt(ROOT_STEP_RANDOM) + 3;
	
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	//��̹��ͼƬ��
	private static Image[] badTankImages = null;
	private static Map<String,Image> badImgs = new HashMap<String, Image>();
	//��̹��ͼƬ��
	private static Image[] goodTankImages = null;
	private static Map<String,Image> goodImgs = new HashMap<String, Image>();
	static{
		badTankImages = new Image[] {
				tk.getImage(Tank.class.getClassLoader().getResource("images/TankL.Gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/TankLU.Gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/TankU.Gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/TankRU.Gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/TankR.Gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/TankRD.Gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/TankD.Gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/TankLD.Gif"))
			};
		badImgs.put("L", badTankImages[0]);
		badImgs.put("LU", badTankImages[1]);
		badImgs.put("U", badTankImages[2]);
		badImgs.put("RU", badTankImages[3]);
		badImgs.put("R", badTankImages[4]);
		badImgs.put("RD", badTankImages[5]);	
		badImgs.put("D", badTankImages[6]);
		badImgs.put("LD", badTankImages[7]);
		
		goodTankImages = new Image[] {
				tk.getImage(Explode.class.getClassLoader().getResource("images/GTankL.Gif")),
				tk.getImage(Explode.class.getClassLoader().getResource("images/GTankLU.Gif")),
				tk.getImage(Explode.class.getClassLoader().getResource("images/GTankU.Gif")),
				tk.getImage(Explode.class.getClassLoader().getResource("images/GTankRU.Gif")),
				tk.getImage(Explode.class.getClassLoader().getResource("images/GTankR.Gif")),
				tk.getImage(Explode.class.getClassLoader().getResource("images/GTankRD.Gif")),
				tk.getImage(Explode.class.getClassLoader().getResource("images/GTankD.Gif")),
				tk.getImage(Explode.class.getClassLoader().getResource("images/GTankLD.Gif"))
			};
		goodImgs.put("L", goodTankImages[0]);
		goodImgs.put("LU", goodTankImages[1]);
		goodImgs.put("U", goodTankImages[2]);
		goodImgs.put("RU", goodTankImages[3]);
		goodImgs.put("R", goodTankImages[4]);
		goodImgs.put("RD", goodTankImages[5]);	
		goodImgs.put("D", goodTankImages[6]);
		goodImgs.put("LD", goodTankImages[7]);
	}
	
	private static final int XSPEED = 5;
	private static final int YSPEED = 5;
	
	public static final int WIDTH = 30;//30
	public static final int HEIGHT = 30;//30
	
	private boolean live = true;//̹������
	private int life = 100;
	private BloodBar bb = new BloodBar();
	
	private TankWar tw = null;
	
	private Tank goodTank = null;

	private boolean good;//̹�˺û�

	private Boolean bL=false,bU=false,bR=false,bD=false;
	
	private Direction dir = Direction.STOP;//̹�˷���
	private Direction ptDir = Direction.D;//��Ͳ����
	
	private boolean isHitWall = false;
	
	private static Sound shotSnd = null;
	private static Sound moveSnd = null;
	private static Sound eatSnd = null;
	static{
		//����String��new Sound(String arg0)
		shotSnd = new Sound(Explode.class.getClassLoader().getResource("sound/TankWarShotSound.wav").getFile());
		moveSnd = new Sound(Explode.class.getClassLoader().getResource("sound/TankWarMoveSound.wav").getFile(),true);
		eatSnd = new Sound(Explode.class.getClassLoader().getResource("sound/TankWarEatBloodSound.wav").getFile());
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public void setGoodTank(Tank goodTank) {
		this.goodTank = goodTank;
	}
	
	public boolean isGood() {
		return good;
	}
	
	public Tank(int x, int y,boolean good) {
		this.x = x;
		this.y = y;
		this.oldX = x;
		this.oldY = y;
		this.good = good;
	}
	
	public Tank(int x, int y,boolean good,Direction dir,TankWar tc) {
		this(x,y,good);
		this.tw = tc;
		this.dir = dir;
	}
	
	public void draw(Graphics g)
	{
		if(!live)
		{
			if(!good)//�����������Ƴ�
			{
				tw.tanks.remove(this);
			}
			return;
		}
		
		/*
		Color c = g.getColor();
		if(good)g.setColor(Color.RED);
		else g.setColor(Color.BLUE);
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(c);
		*/
		
		if(good)
		{
			bb.draw(g);
			switch(ptDir)
			{
			case L:
				g.drawImage(goodImgs.get("L"), x, y, null);
			break;
			case LU:
				g.drawImage(goodImgs.get("LU"), x, y, null);
			break;
			case U:
				g.drawImage(goodImgs.get("U"), x, y, null);
			break;
			case RU:
				g.drawImage(goodImgs.get("RU"), x, y, null);
			break;
			case R:
				g.drawImage(goodImgs.get("R"), x, y, null);
			break;
			case RD:
				g.drawImage(goodImgs.get("RD"), x, y, null);
			break;
			case D:
				g.drawImage(goodImgs.get("D"), x, y, null);
			break;
			case LD:
				g.drawImage(goodImgs.get("LD"), x, y, null);
			break;
			}
		}
		else
		{
			switch(ptDir)
			{
			case L:
				g.drawImage(badImgs.get("L"), x, y, null);
			break;
			case LU:
				g.drawImage(badImgs.get("LU"), x, y, null);
			break;
			case U:
				g.drawImage(badImgs.get("U"), x, y, null);
			break;
			case RU:
				g.drawImage(badImgs.get("RU"), x, y, null);
			break;
			case R:
				g.drawImage(badImgs.get("R"), x, y, null);
			break;
			case RD:
				g.drawImage(badImgs.get("RD"), x, y, null);
			break;
			case D:
				g.drawImage(badImgs.get("D"), x, y, null);
			break;
			case LD:
				g.drawImage(badImgs.get("LD"), x, y, null);
			break;
			}
		}
		
		move();
	}
	
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		switch(key)
		{
		case KeyEvent.VK_LEFT:
			bL = true;
			break;
		case KeyEvent.VK_RIGHT:
			bR = true;
			break;
		case KeyEvent.VK_UP:
			bU = true;
			break;
		case KeyEvent.VK_DOWN:
			bD = true;
			break;
		}
		locateDirection();
	}
	
	private Missile fire() {
		if(!live) return null;
		int fireX,fireY;
		fireX = x + Tank.WIDTH/2 - Missile.WIDTH/2;
		fireY =	y + Tank.HEIGHT/2 - Missile.HEIGHT/2; 
		Missile m = new Missile(fireX,fireY,good,ptDir,this.tw);
		tw.missiles.add(m);
		
		//shot sound
		shotSnd.play();
		
		return m;
	}
	
	private Missile fire(Direction dir) {//���ݷ��������ӵ�����
		if(!live) return null;
		int fireX,fireY;
		fireX = x + Tank.WIDTH/2 - Missile.WIDTH/2;
		fireY =	y + Tank.HEIGHT/2 - Missile.HEIGHT/2; 
		Missile m = new Missile(fireX,fireY,good,dir,this.tw);
		tw.missiles.add(m);
		
		//shot sound
		shotSnd.play();
		
		return m;
		
	}
	private Missile fire(Direction dir,int i) {//���ݷ��������ӵ�����
		if(!live) return null;
		int fireX,fireY;
		fireX = x + Tank.WIDTH/2 - Missile.WIDTH/2;
		fireY =	y + Tank.HEIGHT/2 - Missile.HEIGHT/2; 
		Missile m = new Missile(fireX,fireY,good,dir,this.tw);
		tw.missiles.add(m);
		
		//shot sound
		if(i == 0)//һ�δ���෢ʱֻ����һ��
		{
			shotSnd.play();
		}
		
		return m;
		
	}
	
	private void superFire()//��������
	{
		Direction[] dirs = Direction.values();
		for(int i=0; i<dirs.length-1; i++)//-1��ȥSTOP����
		{
			fire(dirs[i],i);
		}
	}
	
	private void locateDirection()
	{
		if(bL && !bR && !bU && !bD)	dir = Direction.L;
		else if(bL && !bR && bU && !bD) dir = Direction.LU;
		else if(bL && !bR && !bU && bD) dir = Direction.LD;
		else if(!bL && !bR && bU && !bD) dir = Direction.U;
		else if(!bL && bR && bU && !bD) dir = Direction.RU;
		else if(!bL && bR && !bU && !bD) dir = Direction.R;
		else if(!bL && bR && !bU && bD) dir = Direction.RD;
		else if(!bL && !bR && !bU && bD) dir = Direction.D;
		else if(!bL && !bR && !bU && !bD) dir = Direction.STOP;
	}
	
	private void move()
	{
		
		this.oldX = x;
		this.oldY = y;
		
		switch(dir)
		{
		case L:
			x-=XSPEED;
		break;
		case LU:
			x-=XSPEED;
			y-=YSPEED;
		break;
		case U:
			y-=YSPEED;
		break;
		case RU:
			x+=XSPEED;
			y-=YSPEED;
		break;
		case R:
			x+=XSPEED;
		break;
		case RD:
			x+=XSPEED;
			y+=YSPEED;
		break;
		case D:
			y+=YSPEED;
		break;
		case LD:
			x-=XSPEED;
			y+=YSPEED;
		break;
		case STOP:
			;
		break;
		}
		if(this.dir != Direction.STOP)
		{
			this.ptDir = this.dir;
		}
		
		if(x < 0 )
		{
			x = 0;
			isHitWall = true;
		}
		if(y < 30)
		{
			y = 30;
			isHitWall = true;
		}
		if(x + Tank.WIDTH > TankWar.GAME_WIDTH)
		{
			x = TankWar.GAME_WIDTH - Tank.WIDTH;
			isHitWall = true;
		}
		if(y + Tank.HEIGHT > TankWar.GAME_HEIGHT)
		{
			y = TankWar.GAME_HEIGHT - Tank.HEIGHT;
			isHitWall = true;
		}
		
		if(!good)//�Եз�̹���������
		{
			Direction[] dirs = Direction.values();//��ö���ͱ任����������
			
			if(step == 0)
			{
				step = r.nextInt(ROOT_STEP_RANDOM) + ROOT_STEP_LAST;
				if(r.nextInt(40)>5)//�������������˶���������һ�����з�����˶�
				{
					int rn = r.nextInt(dirs.length);//����0��8�������
					dir = dirs[rn];
				}
				else
				{
					dir = this.getMainDirection(goodTank);
				}
			}

			step --;
			
			//�з�̹�˿���
			if(r.nextInt(40)>38)//��������򿪻�
			{
				if(r.nextInt(40)>20)//�����������з����Կ��𣬷���һ���������
				{
					this.fire(this.getMainDirection(goodTank));//38
				}
				else
				{
					this.fire();
				}
			}
		}
		else//���ҷ�̹�������Ϊ
		{
			/****��������****/
			if(Direction.STOP != dir && !isHitWall)
			{
					moveSnd.play();
			}
			else
			{
				moveSnd.stop();
				isHitWall = false;
			}
		}
	}

	public void keyRealease(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		switch(key)
		{
		case KeyEvent.VK_F2:
				if(!this.live)
				{
					this.live = true;
					this.life = 100;
				}
			break;
		case KeyEvent.VK_SPACE:
			fire();
			break;
		case KeyEvent.VK_LEFT:
			bL = false;
			break;
		case KeyEvent.VK_UP:
			bU = false;
			break;
		case KeyEvent.VK_RIGHT:
			bR = false;
			break;
		case KeyEvent.VK_DOWN:
			bD = false;
			break;
		case KeyEvent.VK_V:
			superFire();
			break;
		}
	}
	
	public Rectangle getRect()
	{
		//System.out.println(goodTankImages[1].getHeight(null));
		//System.out.println(goodTankImages[1].getWidth(null));
		return new Rectangle(x,y,WIDTH,HEIGHT);
	}
	
	public boolean collideWithWal(Wall w)
	{
		if(this.live && this.getRect().intersects(w.getRect()))
		{
			isHitWall = true;
			this.stay();
			return true;
		}
		return false;
	}
	
	public boolean collidesWithTank(Tank t)
	{
		if(this != t)//�����Լ�
		{
			if(this.live && t.live && this.getRect().intersects(t.getRect()))
			{
				isHitWall = true;
				this.stay();
				return true;
			}
		}
		return false;
	}
	
	public boolean collidesWithTanks(List<Tank> tanks)
	{
		for(int i=0; i<tanks.size(); i++)
		{
			Tank t = tanks.get(i);
			if(collidesWithTank(t))
			{
				return true;
			}
		}
		
		return false;
	}
	
	private void stay()
	{
		this.x = this.oldX;
		this.y = this.oldY;
	}

	public boolean eat(Blood b)
	{
		if(this.live && b.isLive() && this.getRect().intersects(b.getRect()))
		{
			eatSnd.play();
			this.life = 100;
			b.setLive(false);
			return true;
		}
		return false;
	}
	
	public Direction getMainDirection(Tank t)
	{
		//���ѿ�������ϵ��0,0�����ƶ���myTank��
		int oX = x - t.x;//oX,oY����ԭ���ƶ�
		int oY = y - t.y;
		float angle = 0;
		angle = (float) Math.acos(oX/Math.sqrt(oX*oX + oY*oY));
		//�õ�����//cot()//����-pi/2 �� pi/2 ֮��
		
		Direction[] dirs = Direction.values();
		Direction newDir = Direction.D;
		
		int i = (int) (Math.round(Math.toDegrees(angle)/45));
		if(oY<=0)
		{
			i+=3;
		}

		switch(i)
		{
		case 0:
		case 1:
		case 2:
		case 3:
			newDir = dirs[i];
			break;
		case 4:
			newDir = dirs[7];
			break;
		case 5:
			newDir = dirs[6];
			break;
		case 6:
			newDir = dirs[5];
			break;
		case 7:
			newDir = dirs[4];
			break;
		}
		ptDir = newDir;
		return newDir;
	}
	
	private class BloodBar{
		/***
		 * Ѫ����̹�˵�һ���֣����ⲿ���ֱȽ϶��������Զ�����һ���ڲ��� 
		 */
		public void draw(Graphics g)
		{
			Color c = g.getColor();
			
			g.setColor(Color.RED);
			int w = WIDTH * life/100;
			g.fillRect(x, y-15, w, 10);
			
			g.setColor(Color.WHITE);
			g.drawRect(x, y-15, WIDTH, 10);
			
			g.setColor(c);
		}
	}
	
}
