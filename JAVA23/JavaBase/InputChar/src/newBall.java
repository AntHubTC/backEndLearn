import java.awt.*;

public class newBall {
	public static void main(String[] args)
	{
		Ball2 b = new Ball2();
		Frame f = new Frame();
		f.setBackground(Color.BLACK);
		f.setSize(1024,768);
		f.add(b);
		f.show();
		Thread t = new Thread(b);
		t.start();
		
	}
}
class Ball2 extends Panel implements Runnable
{
	int x=0,y=0;
	int cx=1,cy=1;
	public void paint(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillOval(x, y, 20, 20);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			x += cx;
			y += cy;
			if(x>1024-40)
			{
				x=1024-40;
				cx = -1;
			}
			if(x<0)
			{
				x = 0;
				cx = 1;
			}
			if(y>768-40)
			{
				y = 768-40;
				cy = -1;
			}
			if(y<0)
			{
				y = 0;
				cy = 1;
			}
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
