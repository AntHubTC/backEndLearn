package jBall;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class jBall extends JPanel implements KeyListener,MouseListener,Runnable{
	int x=150,y=0;
	double rnd=0.01;
	int boundy = 300;
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.green);
		g.fillOval(x, y, 50, 50);

		g.setColor(new Color(0,77,0));
		g.fillOval(x+2, y+2, 22, 22);
	}
	public jBall()
	{ 
		this.setSize(100, 50);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_LEFT)//keyCode:37
			x-=2;
		if(e.getKeyCode() == KeyEvent.VK_UP)
			y-=2;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			x+=2;
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
			y+=2;
		repaint();
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			y=500-(int)Math.abs(Math.sin(rnd)*boundy)-50;
			boundy -= 1;
				rnd = rnd*1.002+0.01;

			
			try
			{
				Thread.sleep(30);
			}
			catch(Exception e)
			{
			}
			repaint();
			
		}
	}
	
}
