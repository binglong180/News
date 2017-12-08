package com.niu.news.bean;

/**
 * 
 * 新闻主题
 * 
 * @author 牛牛牛！！！牛牛！！牛！
 * 
 * @date 2017-11-19
 * 
 * @version
 * 
 */
public class Topic {
	private int tId;// 主题编号
	private String tName;// 主题题目

	public Topic(int tid2, String tName) {
		super();
		this.tId = tid2;
		this.tName = tName;
	}

	public Topic() {
		super();
	}

	public Topic(String tName) {
		super();
		this.tName = tName;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	@Override
	public String toString() {
		return "Topic [tId=" + tId + ", tName=" + tName + "]";
	}

}
