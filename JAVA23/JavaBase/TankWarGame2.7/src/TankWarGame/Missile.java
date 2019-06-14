package TankWarGame;

import java.awt.*;
import java.util.List;

import TankWarGame.Tank.Direction;

public class Missile {
	public  static final int WIDTH=10,HEIGHT=10;
	
	private static final int XSPEED = 10;
	private static final int YSPEED = 10;
	
	private int x,y;
	
	private boolean good;
	
	private Tank.Direction dir;
	
	private boolean live = true;

	private TankWar tw;
	
	public boolean isLive() {
		return live;
	}

	public Missile(int x, int y, Direction dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	public Missile(int x, int y,boolean good, Direction dir,TankWar tw) {
		this(x,y,dir);
		this.good = good;
		this.tw = tw;
	}
	
	public void draw(Graphics g)
	{
		if(!live)
		{
			tw.missiles.remove(this);
			return;
		}
		Color c = g.getColor();
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(c);
		move();
		//System.out.println(this.dir);
	}
	
	public void move()
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

		if(x < 0 || y < 0 || x > TankWar.GAME_WIDTH + Missile.WIDTH || y > TankWar.GAME_HEIGHT + Missile.HEIGHT)
		{
			live = false;
		}
	}
	
	public Rectangle getRect()
	{
		return new Rectangle(x,y,WIDTH,HEIGHT);
	}
	
	public boolean hitTank(Tank t)//Åö×²¼ì²â
	{
		if(this.live && this.getRect().intersects(t.getRect()) && t.isLive() && this.good != t.isGood())//¼ì²âÊÇ·ñÏà×²
		{
			if(t.isGood())
			{
				t.setLife(t.getLife()-20);
				if(t.getLife() <= 0 )
				{
					t.setLive(false);
				}
				
			}
			else
			{
				t.setLive(false);
			}
			
			Explode e = new Explode(x, y, this.tw);
			this.tw.explodes.add(e);
			this.live = false;
			return true;
		}
		return false;
	}
	
	public boolean hitTanks(List<Tank> tanks)
	{
		for(int i = 0; i<tanks.size(); i++)
		{
			if(hitTank(tanks.get(i)))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean hitWall(Wall w)
	{
		if(this.live && this.getRect().intersects(w.getRect()))
		{
			this.live = false;
			return true;
		}
		return false;
	}
}
