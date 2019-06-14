package TankWarGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Blood {
	public int x,y;
	public int centerX,centerY;
	public static final int W,H;
	
	TankWar tc;
	
	int step = 0;
	boolean bP = true;
	
	private boolean live = true;
	
	private int angle = 0;
	
	private Random r = new Random();
	
	public void setLive(boolean live) {
		this.live = live;
	}

	public boolean isLive() {
		return live;
	}
	
	static{
		W = H = 15;
	}
	
	public Blood()
	{
		x = r.nextInt(TankWar.GAME_WIDTH);
		y = r.nextInt(TankWar.GAME_HEIGHT);
		centerX = x;
		centerY = y;
	}
	
	public void daw(Graphics g)
	{
		if(!live) return;
		Color c = g.getColor();
		g.setColor(Color.MAGENTA);
		if(step%25 == 0)
		{
			bP = true;
		}
		else if(step%12 == 0)
		{
			bP = false;
		}
		
		step++;
		
		if(bP)
		{
			g.fillOval(x, y, W, H);
		}
		else
		{
			g.fillRect(x, y, W, H);
		}
		g.setColor(c);
		
		move();
	}

	private void move() {
		// TODO Auto-generated method stub
		x = (int) (centerX + Math.sin(angle*Math.PI/180)*W/2);
		angle += 10;
		angle = (angle)%360;
	}
	
	public Rectangle getRect()
	{
		return new Rectangle(x,y,W,H);
	}
}
