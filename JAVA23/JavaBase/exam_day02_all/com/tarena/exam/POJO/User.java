package com.tarena.exam.POJO;

/**
 *  User实体类
 *  设置属性及set和get方法
 */
public class User {
	private int id;
	private String name;
	private String password;
	private String email;
	private long phone;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", id=" + id + ", name=" + name
				+ ", password=" + password + ", phone=" + phone + "]";
	}
	
}
