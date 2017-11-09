import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Panel;

public class Ball123 {
	public static JFrame frame;
	public static void main(String[] args)
	{
		frame = new JFrame();
		frame.setSize(1024, 768);
		BallQ b1= new BallQ();
		//BallQ b2 = new BallQ(512,0,300,500);
		frame.add(b1);
		frame.show();
		Thread t1 = new Thread(b1);
		t1.start();
	}
}
class BallQ extends JPanel implements Runnable{
	int x=512,y=0;
	int boundx = 300;
	int boundy = 500;
	float i=90;
	int num = 0;
	public BallQ(int x,int y,int boundx,int boundy)
	{
		this.x = x;
		this.y = y;
		this.boundx = boundx;
		this.boundy = boundy;
	}
	public BallQ()
	{
		
	}
	public void paint(Graphics g)
	{
		if((num++)%900==0)
		{
			super.paint(g);
		}
		g.setColor(Color.RED);
		g.drawOval(x, y, 50, 50);
		g.setColor(Color.CYAN);
		g.drawLine(0, 0, x+10, y+5);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

		while(true)
		{

			y =(int)(Math.abs(Math.sin(i))*boundx);
			x =(int)(Math.abs(Math.cos(i))*boundy);
			i+=0.5;

			try 
			{
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repaint();
		}
	}
}