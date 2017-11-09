package TankWarGame;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TankWar extends JFrame{

	/**
	 * 实现了窗口关闭和窗口禁止改变大小
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
		);//添加窗口关闭事件
		this.setResizable(false);//不允许改变窗口大小
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TankWar tc = new TankWar();
		tc.lanuchFrame();
	}

}
