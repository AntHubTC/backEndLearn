package tc;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

import javax.swing.JFrame;

public class Game2048 extends JFrame implements Runnable, KeyListener {

	private static final int Height = 460;
	private static final int Width = 440;
	private static final int colsCount = 4;
	private static final int lineCount = 4;
	private int[][] gameArray = new int[lineCount][colsCount];

	public Game2048() {
		super("2048");
		this.setSize(Width, Height);
		this.setVisible(true);
		/*
		 * this.addWindowListener(new WindowAdapter() {
		 * 
		 * @Override public void windowClosing(WindowEvent arg0) {
		 * System.exit(0); } });
		 */
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(this);

		init();
	}

	private void init() {
		next();
	}

	public void up() {
		for (int i = 0; i < gameArray.length; i++) {
			for (int j = 0, index = 0; j < gameArray[i].length; j++) {
				if (gameArray[i][j] != 0 && j != index) {
					gameArray[i][index++] = gameArray[i][j];
					gameArray[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < gameArray.length; i++) {
			System.out.println(Arrays.toString(gameArray[i]));
		}
	}

	public boolean next() {
		/*
		 * 统计0的个数,用随机数，随机数是几，就在第几个0出生成个2或4；
		 */
		int tempCount = 0;
		for (int i = 0; i < gameArray.length; i++) {
			for (int j = 0; j < gameArray[i].length; j++) {
				if (0 == gameArray[i][j]) {
					tempCount++;
				}
			}
		}
		if (0 == tempCount)
			return false;
		int rndPos = (int) (Math.random() * tempCount) + 1;
		tempCount = 0;
		for (int i = 0; i < gameArray.length; i++) {
			for (int j = 0; j < gameArray[i].length; j++) {
				if (0 == gameArray[i][j]) {
					if (rndPos == ++tempCount) {// 到达随机位置
						gameArray[i][j] = (1 == (int) (Math.random() * 2)) ? 2
								: 4;
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Game2048 gameWork = new Game2048();
		Thread t = new Thread(gameWork);
		t.start();
	}

	@Override
	public void paint(java.awt.Graphics g) {
		Color color = g.getColor();
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, Width, Height);
		g.setColor(color);

		for (int i = 0; i < gameArray.length; i++) {
			for (int j = 0; j < gameArray[i].length; j++) {
				g.drawRect(i * 100 + 20, j * 100 + 40, 100, 100);
				if (gameArray[i][j] != 0)
					g.drawString(gameArray[i][j] + "", i * 100 + 20 + 100 / 2,
							j * 100 + 40 + 100 / 2);
			}
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				repaint();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println(e.getKeyCode());
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left();
			next();
			repaint();
			break;
		case KeyEvent.VK_RIGHT:
			break;
		case KeyEvent.VK_UP:
			up();
			next();
			repaint();
			break;
		case KeyEvent.VK_DOWN:
			break;
		}
	}

	private void left() {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}
