package test3DSimulate;

import java.awt.*;
import javax.swing.*;

public class jiankaixian {

	/**
	 * @param args
	 */
	private static int w = Toolkit.getDefaultToolkit().getScreenSize().width;
	private static int h = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setSize(w,h);
		
		Paintjiankaixian Ps = new Paintjiankaixian();
		Thread t = new Thread(Ps);
		t.start();
		
		frame.add(Ps);
		
		frame.setVisible(true);
	}

}

class Paintjiankaixian extends JPanel implements Runnable
{
	private static double w = Toolkit.getDefaultToolkit().getScreenSize().width;
	private static double h = Toolkit.getDefaultToolkit().getScreenSize().height;
	private double x,y,z=0;
	private double x0,y0;
	private double r;
	private double ang;
	private double s;
	private static double baseX=w/2.0;
	private static double baseY=h/2.0;
	private double t=0;
	
	
	public Paintjiankaixian()
	{
		r = 1;
		ang = t*360*Math.PI/180.0;
		s = 2*Math.PI*r*t;
		x0 = s*Math.cos(ang);
		y0 = s*Math.sin(ang);
		x = x0+s*Math.sin(ang);
		y = y0+s*Math.cos(ang);
	}
	
	public void paint(Graphics g)
	{
		g.fillOval((int)(x),(int)(y), 2, 2);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			t+=0.005;
			ang = t*360*Math.PI/180.0;
			s = 2*Math.PI*r*t;
			x0 = s*Math.cos(ang);
			y0 = s*Math.sin(ang);
			x = x0+s*Math.sin(ang)+baseX;
			y = y0+s*Math.cos(ang)+baseY;
			try {
				Thread.sleep(8);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(y<w)
			{
				repaint();
			}
		}
	}
}
