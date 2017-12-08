package com.niu.news.bean;

/**
 * 
 * 用户实体类！
 * 
 * @author 牛牛牛！！！牛牛！！牛！
 * 
 * @date 2017-11-15
 * 
 * @version
 * 
 */
public class User {
	private int uId;
	private String uName;
	private String uPassword;

	public User() {
		super();
	}

	public User(String uName, String uPassword) {
		super();
		this.uName = uName;
		this.uPassword = uPassword;
	}

	public User(int uId, String uName, String uPassword) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uPassword = uPassword;
	}

	@Override
	public String toString() {
		return "User [getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

}
