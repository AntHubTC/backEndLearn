package com.tarena.day01;

import javax.swing.JFrame;

public class SwingDemo extends JFrame{
	//��һ�ַ�ʽ
	private static final long serialVersionUID = -5170808831188220505L;
	public SwingDemo() {
		setSize(600,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	public static void main(String[] args) {
		new SwingDemo().setVisible(true);
	}
	/*
	 * �ڶ��ַ�ʽ
	 
	JFrame frame = new JFrame();
	public SwingDemo() {
		frame.setSize(300, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	*/
	
	
}
