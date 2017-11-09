package com.tarena.exam.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class ExamFrame extends JFrame {
	public ExamFrame() {
		init();
	}
	private void init() {
		setSize(650, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		add(createPane());
	}
	private Component createPane() {
		JPanel pane = new JPanel(new BorderLayout());
		pane.setBorder(new EmptyBorder(8, 8, 8, 8));
		JLabel label = new JLabel(
				new ImageIcon(getClass().getResource("exam_title.png")));
		pane.add(label,BorderLayout.NORTH);
		pane.add(createCenter(),BorderLayout.CENTER);
		pane.add(createSouth(),BorderLayout.SOUTH);
		return pane;
	}
	private Component createSouth() {
		JPanel pane = new JPanel(new BorderLayout());
		pane.setBorder(new EmptyBorder(8, 8, 8, 8));
		JLabel questionNum = new JLabel("题目：20题的第1题");
		JLabel timeInfo = new JLabel("剩余时间：5分");
		pane.add(questionNum,BorderLayout.WEST);
		pane.add(timeInfo,BorderLayout.EAST);
		pane.add(createButton(),BorderLayout.CENTER);
		return pane;
	}
	private Component createButton() {
		JPanel pane = new JPanel(new FlowLayout());
		JButton prev = new JButton("<<上一题");
		JButton next = new JButton("下一题>>");
		JButton send = new JButton("交 卷");
		pane.add(prev);
		pane.add(next);
		pane.add(send);
		return pane;
	}
	private Component createCenter() {
		JPanel pane = new JPanel(new BorderLayout());
		pane.setBorder(new EmptyBorder(8, 25, 8, 25));
		JLabel examInfo = new JLabel("姓名：张三 编号：1001 考试时间：40分钟 考试科目：驾照理论知识测试 题目数量：20",JLabel.CENTER);
		JTextArea question = new JTextArea("题干\n A.XXX\nB.XXXX");
		pane.add(examInfo,BorderLayout.NORTH);
		pane.add(question,BorderLayout.CENTER);
		pane.add(createOptionsPane(),BorderLayout.SOUTH);
		return pane;
	}
	private Component createOptionsPane() {
		JPanel pane = new JPanel(new FlowLayout());
		JCheckBox a = new Option(0,"A");
		JCheckBox b = new Option(1,"B");
		JCheckBox c = new Option(2,"C");
		JCheckBox d = new Option(3,"D");
		pane.add(a);
		pane.add(b);
		pane.add(c);
		pane.add(d);
		return pane;
	}
	class Option extends JCheckBox{
		private static final long serialVersionUID = -7166345943044322928L;
		int val;
		public Option(int val, String string) {
			super(string);
			this.val = val;
		}
	}
}











