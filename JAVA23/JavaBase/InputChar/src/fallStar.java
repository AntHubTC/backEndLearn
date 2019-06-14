import java.awt.*;

public class fallStar{
	public static void main(String[] args)
	{
		Frame f = new Frame();
		f.setSize(1024,768);
		StarE s = new StarE();
		f.add(s);
		f.show();
		Thread t = new Thread(s);
		t.start();
	}
}

class StarE extends Panel implements Runnable
{
	public int[] x = new int[300];
	public int[] y = new int[300];
	
	public StarE()
	{
		for(int i = 0;i<300;i++)
		{
			x[i] = (int)(Math.random()*1024);
			y[i] = (int)(Math.random()*768);
		}
	}
	
	public void paint(Graphics g)
	{
		Font f = new Font("ËÎÌו",0,20);
		g.setFont(f);
		for(int i = 0;i<300;i++)
		{
			g.drawString("*", x[i], y[i]);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i = 0;i<300;i++)
			{
				y[i]++;
				if(y[i]>768)
				y[i] = 0;
				if((int)(Math.random()*100)>50)
				{
					if((int)(Math.random()*100)>30)
					{
						x[i]+=2;
					}
					else
					{
						x[i]-=2;
					}
					if(x[i]>1024)
						x[i] = 0;
					if(x[i]<0)
						x[i] = 1024;
				}
			}
			repaint();
		}
	}
}