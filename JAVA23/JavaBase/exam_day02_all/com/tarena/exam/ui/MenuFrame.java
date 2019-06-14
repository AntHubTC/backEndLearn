package com.tarena.exam.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.tarena.exam.POJO.User;

/**
 * ������
 */
public class MenuFrame extends JFrame {
	private static final long serialVersionUID = 4912132724512378069L;
	public MenuFrame() {
		init();
	}
	private void init() {
		setSize(660, 450);
		setTitle("���߿���ϵͳ--������");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		add(createPane());
	}
	private Component createPane() {
		JPanel pane = new JPanel(new BorderLayout());
		ImageIcon image = 
			new ImageIcon(getClass().getResource("title.png"));
		JLabel top = new JLabel(image);
		JLabel buttom = 
			new JLabel("��Ȩ����,����ؾ�       ",JLabel.RIGHT);
		pane.add(top,BorderLayout.NORTH);
		pane.add(buttom,BorderLayout.SOUTH);
		pane.add(createCenter(),BorderLayout.CENTER);
		return pane;
	}
	JLabel loginInfo;
	private Component createCenter() {
		JPanel pane = new JPanel(new BorderLayout());
		loginInfo = new JLabel("��ӭXXX�μӿ���",JLabel.CENTER);
		pane.add(loginInfo,BorderLayout.NORTH);
		pane.add(createButtonPane(),BorderLayout.CENTER);
		return pane;
	}
	private Component createButtonPane() {
		JPanel pane = new JPanel(new FlowLayout());
		JButton start = 
			createButton("��ʼ", "exam.png");
		JButton result = 
			createButton("���Գɼ�", "result.png");
		JButton rule = 
			createButton("���Թ���", "message.png");
		JButton exit = 
			createButton("�뿪", "exit.png");
		pane.add(start);
		pane.add(result);
		pane.add(rule);
		pane.add(exit);
		return pane;
	}
	private JButton createButton(String name,String url){
		JButton button = 
			new JButton(name, 
					new ImageIcon(
							getClass().getResource(url)));
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		return button;
		
	}
	public void updateInfo(User user){
		loginInfo.setText("��ӭ"+user.getName()+"ͬѧ�μӿ���");
	}
	
}










