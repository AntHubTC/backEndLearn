package com.tarena.day02_2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class MyPanel extends JPanel 
implements Runnable
{
	Random ran = new Random();
	Bubble[] bubbles = new Bubble[15];
	public MyPanel() {
		for (int i = 0; i < bubbles.length; i++) {
			Bubble b = new Bubble();
			b.setX(ran.nextInt(700));
			b.setY(ran.nextInt(500));
			b.setOrientation(ran.nextInt(4));
			Color color = new Color(
					ran.nextInt(256), 
					ran.nextInt(256), 
					ran.nextInt(256) 
					);
			b.setColor(color);
			bubbles[i] = b;
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (Bubble b : bubbles) {
			b.paint(g);
		}
	}
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(3);
				for (Bubble b : bubbles) {
					b.move();
				}
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}