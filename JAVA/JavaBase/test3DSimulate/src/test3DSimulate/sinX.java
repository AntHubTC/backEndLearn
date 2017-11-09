package test3DSimulate;

import java.awt.*;
import javax.swing.*;

public class sinX {

	/**
	 * @param args
	 */
	private static int w = Toolkit.getDefaultToolkit().getScreenSize().width;
	private static int h = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setSize(w,h);
		
		PaintSin Ps = new PaintSin();
		Thread t = new Thread(Ps);
		t.start();
		
		/*
		CustomPen  cP = new CustomPen(10,10,w,h);
		frame.addMouseMotionListener(cP);
		cP.addMouseMotionListener(cP);
		frame.add(cP);
		*/
		
		frame.add(Ps);
		
		frame.setVisible(true);
	}

}

class PaintSin extends JPanel implements Runnable
{
	private static double w = Toolkit.getDefaultToolkit().getScreenSize().width;
	private static double h = Toolkit.getDefaultToolkit().getScreenSize().height;
	private double x,y;
	private static double baseX=0;
	private static double baseY=h/2.0;
	private double t=0;
	
	
	public PaintSin()
	{
		
	}
	
	public void paint(Graphics g)
	{
		g.drawLine(0, (int)(h/2), (int) w, (int)(h/2));
		g.fillOval((int)(x),(int)(y), 2, 2);
		g.fillOval((int)(x)-100,(int)(y), 2, 2);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			t+=0.0005;
			x = 300*t;
			y = 200*Math.sin(t*2*Math.PI)+baseY;
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
