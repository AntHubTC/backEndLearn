package TankWarGame;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TankWar extends JFrame{

	/**
	 * 实现了坦克的移动//太闪
	 */
	public int x;
	public int y=10;
	
	public void lanuchFrame()
	{
		this.setLocation(100, 100);
		this.setSize(800, 600);
		this.setTitle("Tank War");
		this.setBackground(Color.GREEN);
		this.addWindowListener(
			new WindowAdapter()
			{
				@Override
				public void windowClosing(WindowEvent e) {
					// TODO Auto-generated method stub
					System.exit(0);
				}
				
			}
		);//添加窗口关闭事件
		this.setResizable(false);//不允许改变窗口大小
		this.setVisible(true);
		new Thread(new PaintThread()).start();
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		//super.setBackground(Color.GREEN);
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(30, y, 30, 30);
		g.setColor(c);
		
		y+=5;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TankWar tc = new TankWar();
		tc.lanuchFrame();
	}
	
	public class PaintThread implements Runnable
	{

		@Override
		public void run() {
			while(true)
			{
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
