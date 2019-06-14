package jBall;

import java.awt.Color;

import javax.swing.*;
import jBall.jBall;

public class jBallTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jf = new JFrame();
		//jf.setBackground(Color.WHITE);
		jf.setSize(600, 768);
		
		jBall jt = new jBall();
		jf.addKeyListener(jt);
		jt.addKeyListener(jt);
		
		Thread t = new Thread(jt);
		t.start();
		
		jf.add(jt);
		
		jf.setVisible(true);
	}

}
