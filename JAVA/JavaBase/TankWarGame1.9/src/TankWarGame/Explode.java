package TankWarGame;

import java.awt.*;

public class Explode {
	int x, y;
	private boolean live = true;
	
	private TankWar tw = null;
	
	int[] diameter = {4,7,12,18,26,32,49,30,14,6};
	int step = 0;
	
	public Explode(int x, int y, TankWar tw)
	{
		this.x = x;
		this.y = y;
		this.tw = tw;
	}
	
	public void draw(Graphics g)
	{
		if(!live) 
		{
			this.tw.explodes.remove(this);
			return;
		}
		
		if(step == diameter.length)
		{
			live = false;
			step = 0;
			return;
		}
		
		Color c = g.getColor();
		g.setColor(Color.ORANGE);
		g.fillOval(x, y, diameter[step],diameter[step]);
		g.setColor(c);
		
		step++;
	}
}
