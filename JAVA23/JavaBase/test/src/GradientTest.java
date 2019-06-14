import java.applet.Applet;
import java.awt.*;
import java.awt.geom.Rectangle2D;


public class GradientTest extends Applet{

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2D = (Graphics2D)g;
		Rectangle2D r =new Rectangle2D.Double(25,20,150,150);
		GradientPaint p = new GradientPaint(25,20,Color.GREEN,70,70,Color.YELLOW,true);//true支持周期型渐变
		g2D.setPaint(p);
		g2D.fill(r);
		g2D.setPaint(Color.BLUE);
		g2D.setStroke(new BasicStroke(5,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER));
		g2D.draw(r);
	}
	
}
