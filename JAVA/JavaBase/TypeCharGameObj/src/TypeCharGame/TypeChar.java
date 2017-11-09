package TypeCharGame;

import sun.audio.*;

import java.io.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class TypeChar extends JPanel implements Runnable,KeyListener{
	
	int x[];
	int y[];
	char ch[];
	Font chF;
	int chFS[];
	int score = 100;//分数，100为起始分数
	Font scoreF;
	boolean isMark = false;
	boolean isEnd = false;
	
	String gameBackground;//游戏背景音乐
	String gameOverAu;//游戏结束音乐
	String keyFailAu;//按错音乐
	String keySuccAu;//按对音乐
	String lostAu;//字母到达最下方失去音乐
	
	//ContinuousAudioDataStream gg; 
	public void init()
	{
		
	}
	
	public TypeChar(int chNum,int w,int h)
	{
		x = new int[chNum];
		y = new int[chNum];
		ch = new char[chNum];
		chFS = new int[chNum];
		this.setSize(w, h);
		for(int i = 0;i < ch.length;i++)
		{
			x[i] = (int)(Math.random()*this.getSize().width);
			y[i] = -(int)(Math.random()*this.getSize().height);
			ch[i] = (char)(Math.random()*26+97);
			chFS[i] = (int)(Math.random()*50+20);
		}
		chF = new Font("Times New Roman",40,40);
		scoreF = new Font("宋体",40,40);

		gameBackground = new String("Eye Of The Tiger.wav");
		gameOverAu = new String("gameOverAu.wav");
		keyFailAu = new String("keyFailAu.wav");
		keySuccAu = new String("keySuccAu.wav");
		lostAu = new String("lostAu.wav");
		
		//playSound(gameBackground);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		this.setBackground(Color.BLACK);
		if(!isEnd)
		{
			g.setFont(chF);
			g.setColor(Color.WHITE);
			for(int i=0;i < ch.length;i++)
			{
				chF = new Font("Times New Roman",chFS[i],chFS[i]);//问题：new导致内存不断的消耗，有什么解决办法呢？
				//System.gc();
				//Runtime.getRuntime().freeMemory();
				g.setFont(chF);
				g.drawString(ch[i]+"",x[i],y[i]);
			}
		}
		else
		{
			g.setFont(scoreF);
			g.setColor(Color.RED);
			String showStr = "你失败了!";
			g.drawString(showStr, (this.getSize().width-showStr.length()*40)/2 , (this.getSize().height-40)/2);
		}
		g.setColor(Color.RED);
		g.setFont(scoreF);
		g.drawString("你的得分是："+score+"分", 40, 40);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			for(int i=0;i < ch.length;i++)
			{
				
				y[i]+=2;
				if(y[i]>this.getSize().height)
				{
					y[i] = 0;
					x[i] = (int)(Math.random()*this.getSize().width);
					ch[i] = (char)(Math.random()*26+97);
					chFS[i] = (int)(Math.random()*50+20);
					score -= 10;
					playSound(lostAu);
					checkEnd();
				}
			}
			
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
			if(isEnd)
			{
				playSound(gameOverAu);
				break;
			}
		}
	}
	
	public void checkEnd()
	{
		if(score<=0)
		{
			score = 0;
			isEnd = true;
		}
	}
	
	public void playSound(String url)//播放声音
	{
		FileInputStream f;
		AudioStream curSound;
		try {
			f = new FileInputStream(url);
			curSound = new AudioStream(f);
			AudioPlayer.player.start(curSound);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<ch.length;i++)
		{
			if(ch[i] == e.getKeyChar())
			{
				isMark = true;
				x[i] = (int)(Math.random()*this.getSize().width);
				y[i] = -(int)(Math.random()*this.getSize().height);
				ch[i] = (char)(Math.random()*26+97);
				chFS[i] = (int)(Math.random()*50+20);
				break;
			}
		}
		
		if(isMark)
		{
			playSound(keySuccAu);
			score +=1;
			isMark = false;
		}
		else
		{	
			playSound(keyFailAu);
			score -=10;
			if(score<=0)
			{
				score = 0;
			}
		}
		checkEnd();
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
