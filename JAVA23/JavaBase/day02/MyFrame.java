package com.tarena.day02;

import java.awt.Color;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	public MyFrame() {
		setSize(500,700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
		setBackground(Color.gray);
		MyPanel panel = new MyPanel();
		addMouseListener(panel);
		addMouseMotionListener(panel);
		Thread thread = new Thread(panel);
		thread.start();
		add(panel);
	}
	public static void main(String[] args) {
		new MyFrame().setVisible(true);
	}
}
