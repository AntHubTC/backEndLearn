package RotateFlower;

import java.awt.*;
import java.awt.geom.*;
import java.applet.*;
import java.util.*;

public class RotateFlower extends Applet{

	private static final int STAGEWIDH = Toolkit.getDefaultToolkit().getScreenSize().width;
	private static final int STAGEHEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	private static final String TITLE = "JAVA";
	private static final String AUTHOR = "唐成";
	
	private FlowerOne flowerOne;
	private Thread flowerOneT;
	private Image doubleBufferImage = null;
	
	public void init()
	{
		this.setSize(STAGEWIDH, STAGEHEIGHT);
		flowerOne = new FlowerOne(80,10,10.0f,STAGEWIDH, STAGEHEIGHT);//80,10//80,25,0.0f
		flowerOneT = new Thread(flowerOne);
		flowerOneT.start();
	}
	
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		if(doubleBufferImage==null)
		{
			doubleBufferImage = this.createImage(STAGEWIDH, STAGEHEIGHT);
		}
		Graphics gd = doubleBufferImage.getGraphics();
		
		Color c = gd.getColor();
		gd.setColor(Color.GRAY);
		gd.fillRect(0, 0, STAGEWIDH, STAGEHEIGHT);
		
		gd.setColor(Color.BLUE);
		gd.setFont(new Font("Time New Roman",Font.BOLD,42));
		gd.drawString(TITLE, 180-(TITLE.length()*30/2), 190-10);
		gd.drawString(AUTHOR, 180-(AUTHOR.length()*45/2), 190+30);
		gd.setColor(c);
		
		flowerOne.draw(gd);
		paint(g);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(doubleBufferImage,0,0,null);
	}
	
	public class FlowerOne implements Runnable
	{
		private final float[] PAUSEPOSITION ={357.5f,357.5f}; 
		private int x = 80;
		private int y = 10;
		private float angle = 85.0f;
		/******
		 * 大的特效区有85.0f,100f,130.0f,165.0f,220.0f,340.0f
		 * 区间在  20.0f - 380.0f
		 */
		private int width;
		private int height;
		private boolean isPause= false;;
		
		public FlowerOne(int x, int y, float angle,int w,int h) {
			this.x = x;
			if(y>15)
			{
				this.y = y*20;
			}
			else
			{
				this.y = y;
			}
			this.angle = angle;
			this.width =w;
			this.height = h;
		}
		
		public void draw(Graphics g)
		{
			Graphics2D g2D = (Graphics2D)g;
			Ellipse2D ellipseOne = new Ellipse2D.Double(40,40,x,y);
			Ellipse2D ellipseTwo = new Ellipse2D.Double(40,40,y,x);
			AffineTransform trans = new AffineTransform();
			for(int i = 0;i<36;i++)
			{
				trans.rotate(angle*Math.PI/180,180,175);
				g2D.setTransform(trans);
				g2D.fill(ellipseOne);
				g2D.fill(ellipseTwo);
			}
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true)
			{
				op1();
				try {
					Thread.sleep(10);
					if(isPause)
					{
						Thread.sleep(1000);
						isPause = false;
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				repaint();
			}
			
		}
		private void op1()//效果1
		{
			if(x<width)
			{
				x+=2;
			}
			//y++;
			angle+=0.01;
			System.out.println(angle);
			checkClassic(angle);
		}
		
		private void checkClassic(float num)
		{
			//if((int)num == (int)350.0)
			//if(num == 350.0)//浮点数比较问题，老师曾经讲过浮点数不能这样比较
			for(int i = 0;i<PAUSEPOSITION.length;i++)
			{
				if((int)(num*100) == (int)(PAUSEPOSITION[i]*100))
				{
					isPause = true;
					break;
				}
			}
		}
	}
	
}
