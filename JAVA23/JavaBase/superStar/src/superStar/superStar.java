package superStar;

import java.awt.*;
import javax.swing.*;

public class superStar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		JFrame frame = new JFrame();
		frame.setSize( w, h);
		frame.setBackground(Color.BLACK);
		
		star st = new star();
		st.setSize(w, h);
		
		Thread t = new Thread(st);
		t.start();
		
		frame.add(st);
		frame.setVisible(true);
	}
}

class star extends JPanel implements Runnable
{
	int num = 0;
	int x=0;
	int y=0;
	int fSize = 24;
	public void paint(Graphics g)
	{
		if(++num%100==0)
		{
			super.paint(g);
		}
		super.setBackground(Color.BLACK);
		Font f = new Font("Times New Roman",fSize,fSize);
		g.setFont(f);
		g.setColor(Color.WHITE);
		g.drawString("*", x, y);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			x = (int) (Math.random()*this.getSize().width);
			y = (int) (Math.random()*this.getSize().height);
			fSize = (int) (Math.random()*15+15);
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