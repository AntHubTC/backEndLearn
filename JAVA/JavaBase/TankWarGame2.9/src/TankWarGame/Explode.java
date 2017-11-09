package TankWarGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Explode {
	int x, y;
	private boolean live = true;
	
	private TankWar tw = null;
	
	private static boolean init = false;
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	private static Image[] images = {
		tk.getImage(Explode.class.getClassLoader().getResource("images/0.Gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/1.Gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/2.Gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/3.Gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/4.Gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/5.Gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/6.Gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/7.Gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/8.Gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/9.Gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/10.Gif")),
	};

	int step = 0;
	
	public Explode(int x, int y, TankWar tw)
	{
		this.x = x;
		this.y = y;
		this.tw = tw;
	}
	
	public void draw(Graphics g)
	{
		if(false == init)//!init将变量放在后面可以避免犯错
		{
			for (int j = 0; j < images.length; j++) {
				g.drawImage(images[j], -100, -100, null);
			}
			init = true;
		}
		
		if(!live) 
		{
			this.tw.explodes.remove(this);
			return;
		}
		
		if(step == images.length)
		{
			live = false;
			step = 0;
			return;
		}
		
		g.drawImage(images[step], x, y, null);
		
		step++;
	}
}
