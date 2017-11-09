package TankWarGame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class Tank {
	public int x;
	public int y;
	
	private int oldX;
	private int oldY;
	
	private static Random r = new Random();//�����������
	private static final int ROOT_STEP_RANDOM = 20;//��������ռ��ж�
	private static final int ROOT_STEP_LAST = 3;//���ٲ����ж�
	
	private int step = r.nextInt(ROOT_STEP_RANDOM) + 3;
	
	private static final int XSPEED = 5;
	private static final int YSPEED = 5;
	
	public static final int WIDTH = 30;
	public static final int HEIGHT =30;
	
	private boolean live = true;//̹������
	private int life = 100;
	private BloodBar bb = new BloodBar();
	
	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	private TankWar tw = null;
	
	private Tank goodTank = null;
	
	public void setGoodTank(Tank goodTank) {
		this.goodTank = goodTank;
	}

	private boolean good;//̹�˺û�
	
	public boolean isGood() {
		return good;
	}

	private Boolean bL=false,bU=false,bR=false,bD=false;
	
	private Direction dir = Direction.STOP;//̹�˷���
	private Direction ptDir = Direction.D;//��Ͳ����
	
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
		
		Color c = g.getColor();
		if(good)g.setColor(Color.RED);
		else g.setColor(Color.BLUE);
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(c);
		
		if(good) bb.draw(g);
		
		switch(ptDir)
		{
		case L:
			g.drawLine(x+Tank.WIDTH/2, y+Tank.HEIGHT/2, x, y+Tank.HEIGHT/2);
		break;
		case LU:
			g.drawLine(x+Tank.WIDTH/2, y+Tank.HEIGHT/2, x, y);
		break;
		case U:
			g.drawLine(x+Tank.WIDTH/2, y+Tank.HEIGHT/2, x+Tank.WIDTH/2, y);
		break;
		case RU:
			g.drawLine(x+Tank.WIDTH/2, y+Tank.HEIGHT/2, x+Tank.WIDTH, y);
		break;
		case R:
			g.drawLine(x+Tank.WIDTH/2, y+Tank.HEIGHT/2, x+Tank.WIDTH, y+Tank.HEIGHT/2);
		break;
		case RD:
			g.drawLine(x+Tank.WIDTH/2, y+Tank.HEIGHT/2, x+Tank.WIDTH, y+Tank.HEIGHT);
		break;
		case D:
			g.drawLine(x+Tank.WIDTH/2, y+Tank.HEIGHT/2, x+Tank.WIDTH/2, y+Tank.HEIGHT);
		break;
		case LD:
			g.drawLine(x+Tank.WIDTH/2, y+Tank.HEIGHT/2, x, y+Tank.HEIGHT);
		break;
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
		return m;
	}
	
	private Missile fire(Direction dir) {//���ݷ��������ӵ�����
		if(!live) return null;
		int fireX,fireY;
		fireX = x + Tank.WIDTH/2 - Missile.WIDTH/2;
		fireY =	y + Tank.HEIGHT/2 - Missile.HEIGHT/2; 
		Missile m = new Missile(fireX,fireY,good,dir,this.tw);
		tw.missiles.add(m);
		return m;
		
	}
	
	private void superFire()//��������
	{
		Direction[] dirs = Direction.values();
		for(int i=0; i<dirs.length-1; i++)//-1��ȥSTOP����
		{
			fire(dirs[i]);
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
		
		if(x < 0 ) x = 0;
		if(y < 30) y = 30;
		if(x + Tank.WIDTH > TankWar.GAME_WIDTH) x = TankWar.GAME_WIDTH - Tank.WIDTH;
		if(y + Tank.HEIGHT > TankWar.GAME_HEIGHT) y = TankWar.GAME_HEIGHT - Tank.HEIGHT;
		
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
		return new Rectangle(x,y,WIDTH,HEIGHT);
	}
	
	public boolean collideWithWal(Wall w)
	{
		if(this.live && this.getRect().intersects(w.getRect()))
		{
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
