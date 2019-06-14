package com.tarena.exam.POJO;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {
	private static final long serialVersionUID = -4469328887713220894L;
	//标准答案
	private List<Integer> answer;
	//该题的分值
	private int score;
	//难度等级
	private int level;
	//题干
	private String title;
	//选项
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





