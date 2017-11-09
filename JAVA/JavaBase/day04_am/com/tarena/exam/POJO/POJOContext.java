package com.tarena.exam.POJO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class POJOContext {
	//创建用户集合,以ID为关键字
	Map<Integer,User> users = 
		new HashMap<Integer,User>();
	public POJOContext() {
		loadUser();
	}
	/**
	 * 加载所有用户,保存至users
	 */
	public void loadUser(){
		try {
			//创建流
			BufferedReader in = 
				new BufferedReader(
				 new InputStreamReader(
						new FileInputStream("user.txt") 
						 , "GBK")		
				);
			//创建一个引用,用来指向in所读取的内容
			String str = null;
			while((str = in.readLine()) != null){
				if ("".equals(str)) {//内容为空
					continue;
				}
				if (str.startsWith("#")) {//内容为注释
					continue;
				}
				User user = parseUser(str);
				users.put(user.getId(), user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
		1007:刘七:1234:13612345678:liuqi@tarena.com.cn
		解析读取出来的用户记录
	*/
	private User parseUser(String str) {
		User user = new User();
		String[] arr = str.split(":");
		int id = Integer.parseInt(arr[0]);
		String name = arr[1];
		String password = arr[2];
		long phone = Long.parseLong(arr[3]);
		String email = arr[4];
		user.setId(id);
		user.setEmail(email);
		user.setName(name);
		user.setPassword(password);
		user.setPhone(phone);
		return user;
	}
	public User getUser(int id){
		return users.get(id);
	}
}









