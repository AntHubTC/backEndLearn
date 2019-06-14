package com.tarena.exam.test;

import com.tarena.exam.POJO.POJOContext;

public class TestPOJOContextLoadQuestion {
	public static void main(String[] args) {
		POJOContext pc = new POJOContext();
		System.out.println(pc.getQuestion(5));
	}

}
