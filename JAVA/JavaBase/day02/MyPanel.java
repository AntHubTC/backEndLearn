package com.tarena.day02;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class MyPanel 
extends JPanel 
implements MouseListener,MouseMotionListener,Runnable
{
	int x = 250,y = 350;
	boolean fire = false;
	List<Bullet> bullets = new ArrayList<Bullet>();
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).paint(g);
		}
		g.setColor(Color.RED);
		g.fillArc(x, y, 40, 40, 0, 360);
	}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {
		fire = true;
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		fire = false;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		fire = true;
		x = e.getX() - 18;
		y = e.getY() - 40;
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX() - 18;
		y = e.getY() - 40;
	}
	int count = 0;
	@Override
	public void run() {
		while(true){
			count++;
			if(fire && count%5 == 0){
				Bullet b = new Bullet(x, y);
				bullets.add(b);
			}
			try {
				Thread.sleep(30);
				repaint();
				for (int i = 0; i < bullets.size(); i++) {
					int j = bullets.get(i).getY();
					if (j < -50) {
						bullets.remove(i);
					}else{
						j = j-1;
						bullets.get(i).setY(j);
					}
					
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(bullets.size());
		}
	}
}
class Bullet{
	private int x;
	private int y;
	public Bullet() {
	}
	public Bullet(int x,int y){
		this.x = x;
		this.y = y;
	}
	public void paint(Graphics g){
		g.setColor(Color.BLACK);
		g.fillArc(x, y, 15, 15, 0, 360);
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}






