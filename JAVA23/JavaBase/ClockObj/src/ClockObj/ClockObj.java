package ClockObj;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.GregorianCalendar;
import java.util.Calendar;
import javax.swing.*;

public class ClockObj {

	/**
	 * @author boringman--无聊先生
	 * @Vsersion 1.0
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setSize(400, 400);
		frame.setBackground(Color.BLACK);
		
		Clock clock = new Clock();
		clock.setSize(400, 400);
		
		Thread t = new Thread(clock);
		t.start();
		
		frame.add(clock);
		frame.setVisible(true);
		
		frame.addWindowListener(//侦听窗口关闭事件
			new WindowAdapter(){

				@Override
				public void windowClosing(WindowEvent arg0) {
					// TODO Auto-generated method stub
					System.exit(0);
				}
				
			}
		);
	}
}

class Clock extends JPanel implements Runnable
{
	int baseX,baseY;
	
	int startX,startY;
	int endX,endY;
	
	GregorianCalendar gc;
	int hour,minute,second;
	
	public Clock()
	{
		
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		super.setBackground(Color.BLACK);
		//g.setColor(Color.YELLOW);
		//g.fillOval(baseX-80, baseY-80, 160, 160);//背景颜色
		g.setColor(Color.DARK_GRAY);
		for(int i=0;i<=360;i+=6)
		{
			/*****分秒刻表*****/
			startX = (int) (Math.cos(i*Math.PI/180)*80)+baseX;
			startY = (int) (Math.sin(i*Math.PI/180)*80)+baseY;
			endX = (int) (Math.cos(i*Math.PI/180)*70)+baseX;
			endY = (int) (Math.sin(i*Math.PI/180)*70)+baseY;
			g.drawLine(startX, startY, endX, endY);
			
			/*****时刻表*****/
			if(i%30 == 0)
			{
				startX = (int) (Math.cos((i-90)*Math.PI/180)*80)+baseX;
				startY = (int) (Math.sin((i-90)*Math.PI/180)*80)+baseY;
				endX = (int) (Math.cos((i-90)*Math.PI/180)*65)+baseX;
				endY = (int) (Math.sin((i-90)*Math.PI/180)*65)+baseY;
				g.drawLine(startX, startY, endX, endY);
				if(i!=0)
				{
					endX = (int) (Math.cos((i-90)*Math.PI/180)*60)+baseX;
					endY = (int) (Math.sin((i-90)*Math.PI/180)*60)+baseY;
					g.drawString(i/30+"", endX-4, endY+4);//-4字宽,+4字高
				}
			}
		}
		g.drawOval(baseX-80, baseY-80, 160, 160);
		
		/*****秒针*****/
		g.setColor(Color.RED);
		startX = (int) (Math.cos((second*6-90)*Math.PI/180)*62)+baseX;
		startY = (int) (Math.sin((second*6-90)*Math.PI/180)*62)+baseY;
		endX = (int) (Math.cos((second*6-90)*Math.PI/180))+baseX;
		endY = (int) (Math.sin((second*6-90)*Math.PI/180))+baseY;
		g.drawLine(startX, startY, endX, endY);
		
		/*****分针*****/
		g.setColor(Color.BLUE);
		startX = (int) (Math.cos((minute*6-90)*Math.PI/180)*52)+baseX;
		startY = (int) (Math.sin((minute*6-90)*Math.PI/180)*52)+baseY;
		endX = (int) (Math.cos((minute*6-90)*Math.PI/180))+baseX;
		endY = (int) (Math.sin((minute*6-90)*Math.PI/180))+baseY;
		g.drawLine(startX, startY, endX, endY);
		
		/*****时针*****/
		g.setColor(Color.GREEN);
		startX = (int) (Math.cos((hour*30-90)*Math.PI/180)*42)+baseX;
		startY = (int) (Math.sin((hour*30-90)*Math.PI/180)*42)+baseY;
		endX = (int) (Math.cos((hour*30-90)*Math.PI/180))+baseX;
		endY = (int) (Math.sin((hour*30-90)*Math.PI/180))+baseY;
		g.drawLine(startX, startY, endX, endY);
		
		/*****字幕显示*****/
		g.setColor(Color.WHITE);
		g.fillRect(baseX-40, baseY+100, 100, 20);
		g.setColor(Color.BLACK);
		
		g.drawString(hour+":"+minute+":"+second, baseX-20, baseY+115);
	}
	@Override
	public void run() {
		
		this.baseX = this.getSize().width/2;
		this.baseY = this.getSize().height/2;
		
		while(true)
		{
			gc = new GregorianCalendar();
			hour = gc.get(Calendar.HOUR);
			minute = gc.get(Calendar.MINUTE);
			second = gc.get(Calendar.SECOND);

			try {
				Thread.sleep(1000);//暂停1秒钟
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repaint();
		}
	}
	
}
