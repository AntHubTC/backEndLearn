package com.tarena.day01_2;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;
/**
 *����������,���λ��
 */
public class MyPanel2 extends JPanel {
	int[] xx;
	int[] yy;
	Random ran = new Random();
	public MyPanel2() {
		xx = new int[100];
		yy = new int[100];
		for (int i = 0; i < 100; i++) {
			xx[i] = ran.nextInt(750);
			yy[i] = ran.nextInt(600);
		}
	}
	public void paint(Graphics g) {
		super.paint(g);
		setBackground(Color.BLACK);
		g.setColor(Color.WHITE);
		g.setFont(new Font("����",3,15));
		for (int i = 0; i < 100; i++) {
			g.drawString("*", xx[i], yy[i]);
		}
	}
}
