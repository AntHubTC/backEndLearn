package com.tarena.day01_2;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class MyPanel extends JPanel {
	private static final long serialVersionUID = 8055211632009013025L;
	public void paint(Graphics g) {
		super.paint(g);
		//画一个字符串
		g.setColor(Color.RED);
		g.setFont(new Font("宋体", 3, 50));
		g.drawString("Welcome to Tarena", 
				100, 200);
		//画一张图片
		Image img = null;
		try {
			img = ImageIO.read(
					MyPanel.class
					.getResourceAsStream(
							"37d3d539b6003af365f612ef372ac65c1138b6f5.jpg" 
					)
			);
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(img, 100, 20, null);
		//画一些杂七杂八的图形
		g.setColor(Color.BLUE);
		g.drawArc(10, 10, 20, 50, 0, 360);
		
		g.fillArc(10, 100, 50, 50, 110, 160);
		
		
//		g.drawRect(500, 20, 50, 50);
		g.fillRect(500, 20, 50, 50);
		
		
		
		
		
		
		
		
	}
}



