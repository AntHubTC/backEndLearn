package com.tarena.day02_2;

import java.awt.Color;
import java.awt.Graphics;

public class Bubble {
	//����������
	public static final int RIGHT_UP 	= 0;
	public static final int RIGHT_DOWN 	= 1;
	public static final int LEFT_DOWN 	= 2;
	public static final int LEFT_UP 	= 3;

	private int x;
	private int y;
	private int orientation;
	private Color color;
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillArc(x, y, 30, 30, 0, 360);
	}

	/**
	 * ���ݷ���,�ƶ�С��켣
	 */
	public void move() {
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
	public void touched() {
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

	public int getOrientation() {
		return orientation;
	}

	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Color getColor() {
		return color;
	}
}
