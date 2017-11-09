package TankWarGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Blood {
	int x,y,w,h;
	
	TankWar tc;
	
	int step = 0;
	private boolean live = true;
	
	public void setLive(boolean live) {
		this.live = live;
	}

	public boolean isLive() {
		return live;
	}

	private int[][] pos= {
			{350,300}, {360,100}, 
			{375,275}, {400,200}, 
			{360,270}, {365,290}, 
			{340,280}
					};
	
	public Blood()
	{
		x = pos[0][0];
		y = pos[0][1];
		w = h = 15;
	}
	
	public void daw(Graphics g)
	{
		if(!live) return;
		Color c = g.getColor();
		g.setColor(Color.MAGENTA);
		g.fillOval(x, y, w, h);
		g.setColor(c);
		
		move();
	}

	private void move() {
		// TODO Auto-generated method stub
		step = ++step%pos.length;
		x = pos[step][0];
		y = pos[step][1];
	}
	
	public Rectangle getRect()
	{
		return new Rectangle(x,y,w,h);
	}
}
