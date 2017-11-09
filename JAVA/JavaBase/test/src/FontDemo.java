
import java.applet.*;
import java.awt.*;

public class FontDemo extends Applet{

	/**
	 * @param args
	 */
	String str = "»¶Ó­Äã£¡";
	Font f = new Font("ºÚÌå",Font.PLAIN+Font.BOLD,24);
	FontMetrics fm;
	int x,y;
	public void paint(Graphics g)
	{
		g.setFont(f);
		fm = getFontMetrics(f);
		x = (getHeight() - fm.stringWidth(str))/2;
		y = (getHeight() - fm.getHeight())/2;
		g.drawString(str, x, y);
		
	}

}
