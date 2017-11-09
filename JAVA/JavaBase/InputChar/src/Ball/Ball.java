package Ball;
import java.awt.*;
import java.awt.event.*;

public class Ball extends Panel implements KeyListener,MouseListener,MouseMotionListener{
	int x=0,y=0;
	Color c = Color.BLACK;
	public void paint(Graphics g)
	{
		g.setColor(c);
		g.fillRect(x, y, 100, 50);
	}
	public Ball()
	{
		this.setSize(100, 50);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == 37)//a
			x--;
		if(e.getKeyCode() == 38)//a
			y--;
		if(e.getKeyCode() == 39)//a
			x++;
		if(e.getKeyCode() == 40)//a
			y++;
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
		c = Color.red;
		repaint();
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		c = Color.BLACK;
		repaint();
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
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		x = arg0.getX();
		y = arg0.getY();
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
