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
	//�����û�����,��IDΪ�ؼ���
	Map<Integer,User> users = 
		new HashMap<Integer,User>();
	public POJOContext() {
		loadUser();
	}
	/**
	 * ���������û�,������users
	 */
	public void loadUser(){
		try {
			//������
			BufferedReader in = 
				new BufferedReader(
				 new InputStreamReader(
						new FileInputStream("user.txt") 
						 , "GBK")		
				);
			//����һ������,����ָ��in����ȡ������
			String str = null;
			while((str = in.readLine()) != null){
				if ("".equals(str)) {//����Ϊ��
					continue;
				}
				if (str.startsWith("#")) {//����Ϊע��
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
		1007:����:1234:13612345678:liuqi@tarena.com.cn
		������ȡ�������û���¼
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









