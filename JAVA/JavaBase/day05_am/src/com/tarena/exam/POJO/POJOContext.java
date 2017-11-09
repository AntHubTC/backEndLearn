package com.tarena.exam.POJO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class POJOContext {
	//�����û�����,��IDΪ�ؼ���
	Map<Integer,User> users = 
		new HashMap<Integer,User>();
	Map<Integer,List<Question>> questions =
		new HashMap<Integer, List<Question>>();
	public POJOContext() {
		loadUser();
		loadQuestion();
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
	/**
	 * ���Ѷ�Ϊ��׼,������Ŀ
	 */
	public void loadQuestion(){
		try {
			//������
			BufferedReader in = 
				new BufferedReader(
				 new InputStreamReader(
					new FileInputStream("corejava.txt"), "GBK")		
				);
			String str = null;
			//ѭ����ȡ����
			while((str=in.readLine()) != null){
				if ("".equals(str) || str.startsWith("#")) {
					continue;
				}
				Question question = parseQuestion(str,in);
				addToQuestions(question);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	private void addToQuestions(Question question) {
		int level = question.getLevel();
		if (questions.containsKey(level)) {//����ͬ�Ѷȵ���Ŀ����
			List<Question> list = questions.get(level);
			list.add(question);
		}else{//���Ѷȵ���Ŀ,��һ�δ���
			List<Question> list = 
				new ArrayList<Question>();
			list.add(question);
			questions.put(level, list);
		}
	}
	private Question parseQuestion(String str, BufferedReader in) {
		Question q = new Question();
		//����str,�õ���׼��,����,�Ѷ�
		String[] arr = str.split("[@,][a-z]+=");
		String anw = arr[1];
		String[] arr1 = anw.split("/");
		List<Integer> answer = new ArrayList<Integer>();
		for (String a : arr1) {
			answer.add(Integer.parseInt(a));
		}
		int score = Integer.parseInt(arr[2]);
		int level = Integer.parseInt(arr[3]);
		try {
			//��һ�����
			String title = in.readLine();
			List<String> options = new ArrayList<String>();
			//�����ĸ� ѡ��
			options.add(in.readLine());
			options.add(in.readLine());
			options.add(in.readLine());
			options.add(in.readLine());
			//���õ�������,��ֵ��question����
			q.setAnswer(answer);
			q.setLevel(level);
			q.setOptions(options);
			q.setScore(score);
			q.setTitle(title);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return q;
	}
	/**
	 * @param level v
	 * @return Question
	 * �����Ѷȵ�Ҫ��,��������ĵõ�һ�����Ѷ��µ���
	 */
	public Question getQuestion(int level){
		Random ran = new Random();
		List<Question> list = questions.get(level);
		return list.get(ran.nextInt(list.size()));
	}
	/**
	 * @return �Ծ�(List<Question>)
	 * ���Ѷ�Ϊ��λ,ÿ���Ѷ�ȡ������,
	 * ���20����,�γ�һ���Ծ�
	 */
	public List<Question> createPaper() {
		List<Question> paper = new ArrayList<Question>();
		Set<Integer> set = questions.keySet();
		Iterator<Integer> it = set.iterator();
		Random ran = new Random();
		while(it.hasNext()){
			int key = it.next();
			List<Question> list = questions.get(key);
			Question q1 = 
				list.remove(ran.nextInt(list.size()));
			Question q2 = 
				list.remove(ran.nextInt(list.size()));
			paper.add(q1);
			paper.add(q2);
		}
		return paper;
	}
}









