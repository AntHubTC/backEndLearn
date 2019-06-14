package com.tarena.exam.POJO;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {
	private static final long serialVersionUID = -4469328887713220894L;
	//��׼��
	private List<Integer> answer;
	//����ķ�ֵ
	private int score;
	//�Ѷȵȼ�
	private int level;
	//���
	private String title;
	//ѡ��
	private List<String> options;
	
	
	public List<Integer> getAnswer() {
		return answer;
	}
	public void setAnswer(List<Integer> answer) {
		this.answer = answer;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	@Override
	public String toString() {
		return "Question [answer=" + answer + ", level=" + level + ", options="
				+ options + ", score=" + score + ", title=" + title + "]";
	}
	
}





