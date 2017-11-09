
import java.awt.*;
import java.awt.geom.*;
import java.applet.*;

public class Rotate extends Applet{

	@Override
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D)g;
		Ellipse2D ellipse = new Ellipse2D.Double(20,50,100,60);
		AffineTransform trans = new AffineTransform();
		for(int i = 1;i<36;i++)
		{
			trans.rotate(10.0*Math.PI/180,80,75);
			g2D.setTransform(trans);
			g2D.draw(ellipse);
		}
	}

	
}
