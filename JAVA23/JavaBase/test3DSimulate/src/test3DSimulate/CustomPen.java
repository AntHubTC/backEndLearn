package test3DSimulate;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class CustomPen extends JPanel implements MouseMotionListener{
	
	public double x = 10;
	public double y = 10;
	
	public CustomPen(double x,double y,int w,int h)
	{
		this.x = x;
		this.y = y;
		this.setSize( w, h);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillOval((int)(x), (int)(y), 50, 50);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		/*
		this.x = arg0.getX();
		this.y = arg0.getY();
		this.repaint();
		*/
	}
}
