package TypeCharGame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TypeCharGame {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		JFrame jf = new JFrame();
		jf.setAlwaysOnTop(true);
		jf.setBackground(Color.GREEN);
		jf.setSize(w, h);
		
		jf.addWindowListener(
			new WindowAdapter()
			{

				@Override
				public void windowClosing(WindowEvent arg0) {
					// TODO Auto-generated method stub
					System.exit(0);
				}
				
			}
		);
		
		TypeChar gameObj = new TypeChar(10,w,h);
		Thread gameRun = new Thread(gameObj);
		gameRun.start();
		jf.add(gameObj);
		
		jf.addKeyListener(gameObj);
		gameObj.addKeyListener(gameObj);
		
		jf.setVisible(true);
	}

}
