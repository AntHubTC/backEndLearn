package TankWarGame;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TankWar extends JFrame{

	/**
	 * ʵ���˴��ڹرպʹ��ڽ�ֹ�ı��С
	 */
	
	public void lanuchFrame()
	{
		this.setLocation(400, 300);
		this.setSize(800, 600);
		this.setTitle("Tank War");
		this.addWindowListener(
			new WindowAdapter()
			{
				@Override
				public void windowClosing(WindowEvent e) {
					// TODO Auto-generated method stub
					System.exit(0);
				}
				
			}
		);//��Ӵ��ڹر��¼�
		this.setResizable(false);//������ı䴰�ڴ�С
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TankWar tc = new TankWar();
		tc.lanuchFrame();
	}

}
