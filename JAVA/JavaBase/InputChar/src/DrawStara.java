import java.awt.*;
import java.awt.Desktop;
public class DrawStara {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame frame = new Frame();
		frame.setSize(1024, 768);
		Star s1 = new Star();
		frame.setBackground(Color.BLACK);
		frame.add(s1);
		frame.show();
		Thread t = new Thread(s1);
		t.start();
	}

}

class Star extends Panel implements Runnable
{
	public void paint(Graphics g)
	{
		g.setColor(Color.YELLOW);
		Font f = new Font("ËÎÌו",0, 10);
		g.setFont(f);
		g.fillOval(850, 30, 100, 100);
		g.setColor(Color.BLACK);
		g.fillOval(800, 30, 120, 120);
		g.setColor(Color.WHITE);
		for(int i = 0;i<300;i++)
		{
			g.drawString("*", (int)(Math.random()*1024), (int)(Math.random()*768));
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true)
			{
				Thread.sleep(500);
				repaint();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		repaint();
	}
	
}