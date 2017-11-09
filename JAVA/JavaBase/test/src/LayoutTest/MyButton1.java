package LayoutTest;

import java.awt.BorderLayout;

import javax.swing.*;

public class MyButton1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame w = new JFrame();
		w.setSize(300, 400);
		JButton b1 = new JButton("OK1");
		JButton b2 = new JButton("OK2");
		JButton b3 = new JButton("OK3");
		JButton b4 = new JButton("OK4");
		JButton b5 = new JButton("OK5");
		
		w.setLayout(new BorderLayout());
		w.add(b1,BorderLayout.NORTH);
		w.add(b2,BorderLayout.SOUTH);
		w.add(b3,BorderLayout.EAST);
		w.add(b4,BorderLayout.WEST);
		w.add(b5,BorderLayout.CENTER);
		
		
		w.setVisible(true);
	}

}
