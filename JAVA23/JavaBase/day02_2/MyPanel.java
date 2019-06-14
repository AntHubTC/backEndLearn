package com.tarena.day02_2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class MyPanel extends JPanel 
implements Runnable
{
	//����������
	public static final int RIGHT_UP 	= 0;
	public static final int RIGHT_DOWN 	= 1;
	public static final int LEFT_DOWN 	= 2;
	public static final int LEFT_UP 	= 3;

	int x = 300,y = 200;
	int orientation;
	Random ran = new Random();
	public MyPanel() {
		orientation = ran.nextInt(4);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.RED);
		g.fillArc(x, y, 30, 30, 0, 360);
	}
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(3);
				move();
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * ���ݷ���,�ƶ�С��켣
	 */
	private void move() {
		touched();
		switch (orientation) {
		case RIGHT_UP:
			x++;
			y--;
			break;
		case RIGHT_DOWN:
			x++;
			y++;
			break;
		case LEFT_DOWN:
			x--;
			y++;
			break;
		case LEFT_UP:
			x--;
			y--;
			break;
		default:
			break;
		}
	}
	/**
	 * ����������,�ж��Ƿ�ײǽ
	 * ���ײ��,���ݷ����ײǽ��λ��,�ж�ײ���ķ���
	 */
	private void touched() {
		switch (orientation) {
		case RIGHT_UP:
			if ( y <= 0) {
				orientation = RIGHT_DOWN;
				break;
			}
			if (x >= 660) {
				orientation = LEFT_UP;
				break;
			}
		case RIGHT_DOWN:
			if (x >= 660) {
				orientation = LEFT_DOWN;
				break;
			}
			if (y >= 440) {
				orientation = RIGHT_UP;
				break;
			}
		case LEFT_DOWN:
			if (y >= 440) {
				orientation = LEFT_UP;
				break;
			}
			if (x <= 0) {
				orientation = RIGHT_DOWN;
				break;
			}
		case LEFT_UP:
			if (y <= 0) {
				orientation = LEFT_DOWN;
				break;
			}
			if (x <= 0) {
				orientation = RIGHT_UP;
				break;
			}
		default:
			break;
		}
	}

}
