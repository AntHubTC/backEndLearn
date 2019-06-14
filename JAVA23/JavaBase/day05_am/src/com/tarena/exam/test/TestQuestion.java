package com.tarena.exam.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestQuestion {
	public static void main(String[] args) {
		String str = "2/3";
		String[] arr1 = str.split("/");
		System.out.println(Arrays.toString(arr1));
		List<Integer> list = new ArrayList<Integer>();
		for (String a : arr1) {
			list.add(Integer.parseInt(a));
		}
		System.out.println(list);
	}
}
