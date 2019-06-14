package TankWarGame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class Tank {
	private int x;
	private int y;
	
	private int oldX;
	private int oldY;
	
	private static Random r = new Random();//随机数产生器
	
	private int step = r.nextInt(12) + 3;
	
	private static final int XSPEED = 5;
	private static final int YSPEED = 5;
	
	public static final int WIDTH = 30;
	public static final int HEIGHT =30;
	
	private boolean live = true;//坦克生死
	
	private TankWar tw = null;
	
	private boolean good;//坦克好坏
	
	public boolean isGood() {
		return good;
	}

	private Boolean bL=false,bU=false,bR=false,bD=false;
	public enum Direction {L,LU,U,RU,R,RD,D,LD,STOP};
	
	private Direction dir = Direction.STOP;//坦克方向
	private Direction ptDir = Direction.D;//炮筒方向
	
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
			if(!good)//坏蛋被打死移除
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
	
	private Missile fire(Direction dir) {//根据方向生成子弹对象
		if(!live) return null;
		int fireX,fireY;
		fireX = x + Tank.WIDTH/2 - Missile.WIDTH/2;
		fireY =	y + Tank.HEIGHT/2 - Missile.HEIGHT/2; 
		Missile m = new Missile(fireX,fireY,good,dir,this.tw);
		tw.missiles.add(m);
		return m;
		
	}
	
	private void superFire()//超级攻击
	{
		Direction[] dirs = Direction.values();
		for(int i=0; i<dirs.length-1; i++)//-1除去STOP方向
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
		//this.ptDir = Direction.LU;
		
		if(x < 0 ) x = 0;
		if(y < 30) y = 30;
		if(x + Tank.WIDTH > TankWar.GAME_WIDTH) x = TankWar.GAME_WIDTH - Tank.WIDTH;
		if(y + Tank.HEIGHT > TankWar.GAME_HEIGHT) y = TankWar.GAME_HEIGHT - Tank.HEIGHT;
		
		if(!good)
		{
			Direction[] dirs = Direction.values();//将枚举型变换成数组来用
			
			if(step == 0)
			{
				step = r.nextInt(12) + 3;
				int rn = r.nextInt(dirs.length);//产生0到8的随机数
				dir = dirs[rn];
			}

			step --;
			if(r.nextInt(40)>38)this.fire();
		}
	}

	public void keyRealease(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		switch(key)
		{
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
	
	public boolean collidesWithWal(Wall w)
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
		if(this != t)//不是自己
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
}
