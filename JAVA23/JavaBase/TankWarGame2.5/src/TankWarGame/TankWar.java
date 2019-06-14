package TankWarGame;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

import TankWarGame.Tank.Direction;

public class TankWar extends Frame{

	/**
	 *引入血瓶，吃了可以加血
	 */
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 600;
	
	public Tank myTank = new Tank(30,30,true,Direction.STOP,this);
	
	Wall w1 = new Wall(100,200,20,150,this),w2 = new Wall(300,100,300,20,this);
	
	public List<Explode> explodes = new ArrayList<Explode>();
	public List<Missile> missiles = new ArrayList<Missile>();
	public List<Tank> tanks = new ArrayList<Tank>();
	
	private Image offScreenImage = null;

	Blood b = new Blood();
	
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
		
		for(int i=0;i<10;i++)
		{
			tanks.add(new Tank(100+40*(i+1), 580, false,Direction.D, this));
		}
		
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
		g.drawString("explodes count:"+explodes.size(), 10, 70);
		g.drawString("tanks    count:"+tanks.size(), 10, 90);
		g.drawString("tank     life:"+myTank.getLife(), 10, 110);
		
		for(int i = 0;i<missiles.size();i++)
		{
			Missile m = missiles.get(i);
			m.hitTanks(tanks);
			m.hitTank(myTank);
			m.hitWall(w1);
			m.hitWall(w2);
			//if(!m.isLive())
			//{
				// //System.out.println(m.isLive());
				//missiles.remove(m);//没有生存则去除
			//}
			//else 
			m.draw(g);
		}
		
		for(int i=0; i<explodes.size(); i++)
		{
			Explode e = explodes.get(i);
			e.draw(g);
		}
		
		for(int i=0; i<tanks.size();i++)
		{
			Tank t = tanks.get(i);
			t.collidesWithWal(w1);
			t.collidesWithWal(w2);
			t.collidesWithTanks(tanks);
			t.draw(g);
		}
		
		myTank.collidesWithTanks(tanks);
		myTank.collidesWithWal(w1);
		myTank.collidesWithWal(w2);
		
		myTank.draw(g);
		myTank.eat(b);
		w1.draw(g);
		w2.draw(g);
		b.daw(g);
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
