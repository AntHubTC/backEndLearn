package com.tarena.day01_2;
import javax.swing.JFrame;
public class MyFrame extends JFrame {
	public MyFrame() {
		setSize(750,600);
		setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		MyPanel2 panel = new MyPanel2();
		add(panel);
	}
	public static void main(String[] args) {
		new MyFrame().setVisible(true);
	}
}