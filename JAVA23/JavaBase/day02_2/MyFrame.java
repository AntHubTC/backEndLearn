package com.tarena.day02_2;

import java.awt.Color;

import javax.swing.JFrame;

public class MyFrame extends JFrame{
	public MyFrame() {
		setBackground(Color.GRAY);
		setSize(700, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyPanel panel = new MyPanel();
		new Thread(panel).start();
		add(panel);
	}
	public static void main(String[] args) {
		new MyFrame().setVisible(true);
	}
}
