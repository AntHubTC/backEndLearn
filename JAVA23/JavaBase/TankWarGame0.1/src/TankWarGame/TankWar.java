package TankWarGame;

import java.awt.*;
import javax.swing.*;

public class TankWar extends JFrame{

	/**
	 *ʵ����һ������
	 */
	
	public void lanuchFrame()
	{
		this.setLocation(400, 300);
		this.setSize(800, 600);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TankWar tc = new TankWar();
		tc.lanuchFrame();
	}

}
