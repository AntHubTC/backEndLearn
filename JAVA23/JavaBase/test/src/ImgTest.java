import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ImgTest extends Frame implements Runnable {
	Image img;
	boolean isLoad = false;

	public void paint(Graphics g) {
		// 技术妙用
		while (!isLoad) {
			System.out.print(img);
			isLoad = g.drawImage(img, 0, 0, null);
			System.out.println(isLoad);
		}
		isLoad = false;
	}

	void launchFrame() {
		img = Toolkit.getDefaultToolkit().getImage(
				ImgTest.class.getClassLoader().getResource("images/20.jpg"));
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setResizable(false);
		setSize(w, h);
		this.setAlwaysOnTop(true);// 让程序在任务栏之前
		// setLocation(500,500);
		setTitle("我的作品！");
		setVisible(true);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		ImgTest b1 = new ImgTest();
		b1.launchFrame();
		Thread t = new Thread(b1);
		t.start();
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			repaint();
		}

	}
}