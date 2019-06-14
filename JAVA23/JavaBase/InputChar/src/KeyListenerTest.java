import java.awt.Frame;

import Ball.Ball;;

public class KeyListenerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame();
		f.setSize(200,200);
		Ball b1 = new Ball();
		
		f.addKeyListener(b1);
		b1.addKeyListener(b1);
		
		f.addMouseListener(b1);
		b1.addMouseListener(b1);
		
		f.add(b1);
		f.show();

	}

}
