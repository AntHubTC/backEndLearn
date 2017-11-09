package com.tarena.exam.test;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<String> op = new ArrayList<String>();
		op.add("11111111");
		op.add("22222222");
		op.add("33333333");
		op.add("44444444");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			sb.append((char)(i+65)+"."+op.get(i)+"\n");
		}
//		sb.append(op.get(0)+"\n");
//		sb.append(op.get(1)+"\n");
//		sb.append(op.get(2)+"\n");
//		sb.append(op.get(3)+"\n");
		System.out.println(sb);
	}

}









