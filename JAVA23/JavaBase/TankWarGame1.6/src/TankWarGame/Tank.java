package TankWarGame;

import java.awt.*;
import java.awt.event.*;


public class Tank {
	private int x;
	private int y;
	
	private static final int XSPEED = 5;
	private static final int YSPEED = 5;
	
	public static final int WIDTH = 30;
	public static final int HEIGHT =30;
	
	private boolean live = true;//坦克生死
	
	private TankWar tw = null;
	
	private boolean good;//坦克好坏
	
	private Boolean bL=false,bU=false,bR=false,bD=false;
	public enum Direction {L,LU,U,RU,R,RD,D,LD,STOP};
	
	private Direction dir = Direction.STOP;//坦克方向
	private Direction ptDir = Direction.D;//炮筒方向
	
	public Tank(int x, int y,boolean good) {
		this.x = x;
		this.y = y;
		this.good = good;
	}
	
	public Tank(int x, int y,boolean good,TankWar tc) {
		this(x,y,good);
		this.tw = tc;
	}
	
	public void draw(Graphics g)
	{
		if(!live) return;
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
		int fireX,fireY;
		fireX = x + Tank.WIDTH/2 - Missile.WIDTH/2;
		fireY =	y + Tank.HEIGHT/2 - Missile.HEIGHT/2; 
		Missile m = new Missile(fireX,fireY,ptDir,this.tw);
		tw.missiles.add(m);
		return m;
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
		}
	}
	
	public Rectangle getRect()
	{
		return new Rectangle(x,y,WIDTH,HEIGHT);
	}
}
