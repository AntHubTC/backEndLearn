package test3DSimulate;

import java.awt.*;

import javax.swing.*;

public class Test3DSimulate {
	
	public static int w,h;
	public static void main(String[] args)
	{
		w = Toolkit.getDefaultToolkit().getScreenSize().width;
		h = Toolkit.getDefaultToolkit().getScreenSize().height;
		JFrame  frame = new JFrame();
		frame.setSize(w, h);
		frame.setBackground(Color.BLUE);
		
		Test3D test3d = new Test3D(w,h);
		test3d.setSize(frame.getSize().width, frame.getSize().height);
		frame.add(test3d);
		
		Thread t = new Thread(test3d);
		t.start();
		
		frame.setVisible(true);
	}
}

class Test3D extends JPanel implements Runnable
{
	int startX=0,startY=0;
	int endX=0,endY=0;
	int baseLen = 100;
	int num=0;
	float angle = 0.01f;
	
	public Test3D(int w, int h) {
		// TODO Auto-generated constructor stub
		startX = w/2;
		startY = h/2;
	}
	
	public void paint(Graphics g)
	{
		super.setBackground(Color.BLUE);
		if(num++%2500==0)	
		{
			num = 1;
			super.paint(g);
		}
		g.setColor(Color.RED);
		g.drawLine(startX, startY, endX, endY);
		g.setColor(Color.GREEN);
		//g.drawOval(endX-15, endY-15, 30, 30);
		g.drawRect(endX-15, endY-15, 30, 30);
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			/*
			   endX = (int) (Math.sin(angle+90)*300)+startX;
			   endY = (int) (Math.sin(angle)*300)+startY;
			*/
			endX = (int) (Math.sin(angle)*300)+startX;
			endY = (int) (Math.cos(angle)*300)+startY;
			angle+=0.05;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repaint();
		}
	}
	
}
