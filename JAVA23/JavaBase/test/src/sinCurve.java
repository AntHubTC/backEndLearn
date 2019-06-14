
import java.awt.*;
import java.awt.geom.*;
import java.applet.*;

public class sinCurve extends Applet{
	
	public void init()
	{
		this.setSize(450, 200);
	}
	
	public void paint(Graphics g)
	{
		Graphics2D  g2D= (Graphics2D)g;
		int offx = 40;
		int offy = 80;
	
		
		/*****绘制笛卡尔坐标系轴******/
		g2D.setPaint(Color.BLUE);
		g2D.setStroke(new BasicStroke(2));
		g2D.draw(new Line2D.Float(offx+0,offy-60,offx+0,offy+60));
		g2D.draw(new Line2D.Float(offx-5,offy-57,offx+0,offy-60));
		g2D.draw(new Line2D.Float(offx+5,offy-57,offx+0,offy-60));
		g2D.draw(new Line2D.Float(offx+0,offy+0,offx+380,offy+0));
		g2D.draw(new Line2D.Float(offx+376,offy-5,offx+380,offy+0));
		g2D.draw(new Line2D.Float(offx+376,offy+5,offx+380,offy+0));
		g2D.drawString("x", offx+385, offy);
		g2D.drawString("y", offx, offy-66);
		
		
		/***********利用多边形描绘曲线************/
		GeneralPath polly = new GeneralPath();
		polly.moveTo(offx, offy);
		for(int jd=0;jd<=360;jd++)
		{
			float x = jd;
			float y = (float) (50*Math.sin(jd*Math.PI/180));
			//float y = (float) (50*Math.cos(jd*Math.PI/180));
			//float y = Math.abs((float) (50*Math.sin(jd*Math.PI/180)));
			polly.lineTo(offx+x, offy-y);
			if(jd%45 == 0)
			{
				g2D.drawLine(offx+(int)x, 73, offx+(int)x, 73+5);
				g2D.drawString(jd+"", offx+(int)x, 73+5+15);
			}
		}
		g2D.setPaint(Color.RED);
		g2D.draw(polly);
	}
}
