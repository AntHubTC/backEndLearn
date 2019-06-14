import java.awt.*;
import java.applet.Applet;
public class hello extends Applet{
	public void paint(Graphics g)
	{
		g.drawString("my java!",40,80);
		g.setColor(Color.blue);
		g.drawLine(0,0,100,100);
		g.drawOval(30,40,70,80);
		g.drawRect(0,50,10,60);
	}
}
