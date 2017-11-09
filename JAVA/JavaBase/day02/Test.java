package com.tarena.day02;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Test 
	implements MouseListener,MouseMotionListener
{
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(300,300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Test t = new Test();
		f.addMouseListener(t);
		f.addMouseMotionListener(t);
		f.setVisible(true);
	}
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked");
	}
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered");
	}
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited");
	}
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed");
	}
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased");
	}
	public void mouseDragged(MouseEvent e) {
		System.out.println("mouseDragged");
	}
	public void mouseMoved(MouseEvent e) {
		System.out.println("mouseMoved");
	}
}
