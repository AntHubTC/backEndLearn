import java.awt.*;
import java.applet.*;

public class JavaApplet extends Applet {
	public void paint(Graphics g)
	{
		g.setColor(Color.red);
		g.drawString("JavaApplet", 40, 80);
		g.setColor(Color.gray);
		g.drawOval(30, 40, 100, 100);
		g.drawLine(0, 0, 100, 100);
	
	}
}
