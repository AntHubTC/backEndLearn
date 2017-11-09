import java.awt.*;

import javax.swing.JFrame;

public class test extends JFrame implements Runnable {

	public static Toolkit kt = Toolkit.getDefaultToolkit();
	public Image img;
	public Image imgBuffer;
	public final int IMG_WIDTH=600,IMG_HEIGHT=300;
	public int x, y;
	private Point screenP;

	public test() {
		// kt.beep();
		screenP = new Point(kt.getScreenSize().width, kt.getScreenSize().height);
		System.out.println("Screen size:\nw:" +screenP.x + "\th:" + screenP.y);
		// System.out.println(test.class.getClassLoader().getResource("images/20.jpg"));
		img = kt.getImage(test.class.getClassLoader().getResource(
				"images/20.jpg"));
		this.setVisible(true);
		this.setSize(screenP.x, screenP.y);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		x = 0;
		y = screenP.y/2 - this.IMG_HEIGHT/2;

	}

	@Override
	public void update(Graphics arg0) {
		super.update(arg0);
	}

	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, screenP.x, screenP.y);
		boolean isFish = false;
		while(!isFish)
			isFish = g.drawImage(img, x, y, this.IMG_WIDTH, this.IMG_HEIGHT, null);
	}

	public static void main(String[] args) {
		test t =new test();
		Thread  thread = new Thread(t);
		thread.start();
	}

	@Override
	public void run() {
		while (true) {
			if(x>screenP.x-this.IMG_WIDTH)
				x -= screenP.x;
			else
				x +=5;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
		}
	}

}
