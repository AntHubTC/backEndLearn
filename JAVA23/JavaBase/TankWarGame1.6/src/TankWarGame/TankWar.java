package TankWarGame;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;;

public class TankWar extends Frame{

	/**
	 *引入炮筒方向
	 */
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 600;
	
	public Tank myTank = new Tank(30,30,true,this);
	
	public Tank enemyTank  = new Tank(100,100,false,this);
	
	public List<Missile> missiles = new ArrayList();
	
	private Image offScreenImage = null;

	public void lanuchFrame()
	{
		this.setLocation(100, 100);
		this.setSize(GAME_WIDTH, GAME_HEIGHT);
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
		
		this.addKeyListener(new KeyMonitor());
		
		this.setVisible(true);
		
		new Thread(new PaintThread()).start();
	}
	
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		if(offScreenImage == null)
		{
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.GREEN);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawString("Missiles count:"+missiles.size(), 10, 50);
		
		for(int i = 0;i<missiles.size();i++)
		{
			Missile m = missiles.get(i);
			//if(!m.isLive())
			//{
				// //System.out.println(m.isLive());
				//missiles.remove(m);//没有生存则去除
			//}
			//else 
			m.hitTank(enemyTank);
			m.draw(g);
		}
		
		myTank.draw(g);
		enemyTank.draw(g);
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
	
	public class KeyMonitor extends KeyAdapter
	{

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			myTank.keyRealease(e);
		}

		@Override
		public void keyPressed(KeyEvent e) {
			myTank.keyPressed(e);
		}
		
	}
}
