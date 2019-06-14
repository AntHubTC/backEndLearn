package RotateFlower;

import java.awt.*;
import java.awt.geom.*;
import java.applet.*;
import java.util.*;

public class RotateFlower extends Applet{

	private static final int STAGEWIDH = Toolkit.getDefaultToolkit().getScreenSize().width;
	private static final int STAGEHEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	private FlowerOne flowerOne;
	private Thread flowerOneT;
	private Image doubleBufferImage = null;
	
	public void init()
	{
		this.setSize(STAGEWIDH, STAGEHEIGHT);
		flowerOne = new FlowerOne(180,190,80,17,0.0f,STAGEWIDH, STAGEHEIGHT);//80,10//80,25,0.0f
		flowerOneT = new Thread(flowerOne);
		flowerOneT.start();
	}
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		if(doubleBufferImage==null)
		{
			doubleBufferImage = this.createImage(STAGEWIDH, STAGEHEIGHT);
		}
		Graphics gd = doubleBufferImage.getGraphics();
		
		flowerOne.draw(gd);
		paint(g);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(doubleBufferImage,0,0,null);
	}
	
	public class FlowerOne implements Runnable
	{
		private static final int OFFX = 180;
		private static final int OFFY = 175;
		
		private static final String TITLE = "JAVA";
		private static final String AUTHOR = "唐成";
		
		private boolean isPause= false;
		private final float[] pausePosition = {89.85f,119.71f,177.74f,179.92f,239.44f}; 
		private final String[] pauseInfo = {"JAVA真神奇！无聊先生，QQ：1096648786","憧憬未来,呵护梦想！","求知若饥，虚心若愚！","为梦想加油！~","残酷,我以青春作为赌注，赢得属于我的梦想."};
		private final Point[] pauseInfoPos = {new Point(400,400),new Point(300,300),new Point(200,900),new Point(500,300),new Point(400,500)};
		private int pauseCount = -1;
		
		private int w = 80;
		private int h = 10;
		private int baseX = 0;
		private int baseY = 0;
		private float angle = 85.0f;
		/******
		 * 大的特效区有85.0f,100f,130.0f,165.0f,220.0f,340.0f
		 * 区间在  20.0f - 380.0f
		 */
		
		private int width;
		private int height;
		
		private Font f = new Font("宋体",Font.BOLD,25);
		private Rectangle2D bgRect = null;
		private GradientPaint bgGradient = null;
		private GradientPaint foreGradient = null;
		
		public FlowerOne(int x0, int y0, int x1, int y1, float angle,int w,int h) {
			this.baseX = x0 - OFFX;
			this.baseY = y0 - OFFY;
			this.w = x1;
			/******
			if(y1>15)
			{
				this.h = y1*30;
			}
			else
			{
				this.h = y1;
			}
			*******/
			this.h = y1>15 ? y1*30 : y1;
			this.angle = angle;
			this.width =w;
			this.height = h;
			bgRect = new Rectangle2D.Float(0, 0,w, h);
			bgGradient = new GradientPaint(0, 0, Color.GREEN, width, height, Color.YELLOW,true);
			foreGradient = new GradientPaint(0, 0, Color.MAGENTA, width/2, height/2, Color.BLUE,true);
		}
		
		public void draw(Graphics g)
		{
			Graphics2D g2D = (Graphics2D)g;
			Paint p = g2D.getPaint();
			g2D.setPaint(bgGradient);
			g2D.fill(bgRect);
			g2D.setPaint(p);
			Color c = g2D.getColor();
			
			g2D.setColor(Color.BLUE);
			g2D.setFont(new Font("Time New Roman",Font.BOLD,42));
			g2D.drawString(TITLE, 180-(TITLE.length()*30/2), 190-10);
			g2D.drawString(AUTHOR, 180-(AUTHOR.length()*45/2), 190+30);
			g2D.setColor(c);
			
			p = g2D.getPaint();
			if((int)(h*100) <= (int)(2000))//20*100
			{
				g2D.setPaint(foreGradient);
			}
			else
			{
				g2D.setPaint(Color.BLUE);
			}
			
			Ellipse2D ellipseOne = new Ellipse2D.Double(this.baseX+80,this.baseY+80,w,h);
			Ellipse2D ellipseTwo = new Ellipse2D.Double(this.baseX+80,this.baseY+80,h,w);
			AffineTransform trans = new AffineTransform();

			for(int i = 0;i<36;i++)
			{
				trans.rotate(angle*Math.PI/180,this.baseX+180,this.baseY+175);//180,175
				g2D.setTransform(trans);
				g2D.fill(ellipseOne);
				g2D.fill(ellipseTwo);
			}
			g2D.setPaint(p);
			
			if(isPause)
			{
				drawString(g,pauseInfo[pauseCount],pauseInfoPos[pauseCount].x,pauseInfoPos[pauseCount].y);
			}
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true)
			{
				op2();
				op1();
				
				repaint();
				
				try {
					Thread.sleep(20);
					if(isPause)
					{	
						Thread.sleep(10000);
						isPause = false;
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		private void op1()//效果1
		{
			if(w<width)
			{
				w+=4;
			}
			//y++;
			angle+=0.02;
			if(angle>360)
				angle = 0.0f;
			//System.out.println(angle);
			checkClassic(angle);
		}
		
		private void op2()//开始效果2
		{
			if((int)(h*100) > (int)(2000))//20*100
			{
				h-=0.01;
			}
		}
		
		private void checkClassic(float num)
		{
			//if((int)num == (int)350.0)
			//if(num == 350.0)//浮点数比较问题，老师曾经讲过浮点数不能这样比较
			for(int i = 0;i<pausePosition.length;i++)
			{
				if((int)(num*100) == (int)(pausePosition[i]*100))
				{
					pauseCount = (++pauseCount)%pauseInfo.length;
					isPause = true;
					break;
				}
			}
		}
		
		private void drawString(Graphics g,String str,int posX,int posY)
		{
			Color c = g.getColor();
			g.setColor(Color.BLUE);
			g.setFont(f);
			g.drawString(str, posX, posY);
			g.setColor(c);
		}
	}
	
}
