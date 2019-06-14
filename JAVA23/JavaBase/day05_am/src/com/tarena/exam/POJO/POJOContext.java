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
	//创建用户集合,以ID为关键字
	Map<Integer,User> users = 
		new HashMap<Integer,User>();
	Map<Integer,List<Question>> questions =
		new HashMap<Integer, List<Question>>();
	public POJOContext() {
		loadUser();
		loadQuestion();
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
	/**
	 * 以难度为标准,储存题目
	 */
	public void loadQuestion(){
		try {
			//创建流
			BufferedReader in = 
				new BufferedReader(
				 new InputStreamReader(
					new FileInputStream("corejava.txt"), "GBK")		
				);
			String str = null;
			//循环读取内容
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
		if (questions.containsKey(level)) {//已有同难度的题目存入
			List<Question> list = questions.get(level);
			list.add(question);
		}else{//该难度的题目,第一次存入
			List<Question> list = 
				new ArrayList<Question>();
			list.add(question);
			questions.put(level, list);
		}
	}
	private Question parseQuestion(String str, BufferedReader in) {
		Question q = new Question();
		//解析str,得到标准答案,分数,难度
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
			//下一行题干
			String title = in.readLine();
			List<String> options = new ArrayList<String>();
			//连续四个 选项
			options.add(in.readLine());
			options.add(in.readLine());
			options.add(in.readLine());
			options.add(in.readLine());
			//将得到的内容,赋值到question对象
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
	 * 根据难度的要求,我们随机的得到一个该难度下的题
	 */
	public Question getQuestion(int level){
		Random ran = new Random();
		List<Question> list = questions.get(level);
		return list.get(ran.nextInt(list.size()));
	}
	/**
	 * @return 试卷(List<Question>)
	 * 以难度为单位,每个难度取两个题,
	 * 组成20个题,形成一张试卷
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









