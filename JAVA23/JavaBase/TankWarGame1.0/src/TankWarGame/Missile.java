package TankWarGame;

import java.awt.*;

import TankWarGame.Tank.Direction;

public class Missile {
	private static final int w=10,h=10;
	private static final int XSPEED = 10;
	private static final int YSPEED = 10;
	int x,y;
	Tank.Direction dir;
	public Missile(int x, int y, Direction dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	public void draw(Graphics g)
	{
		Color c = g.getColor();
		g.fillOval(x, y, w, h);
		g.setColor(c);
		move();
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
	}
}
