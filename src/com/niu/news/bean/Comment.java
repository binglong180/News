package com.niu.news.bean;

/**
 * 
 * 评论类！
 * 
 * @author 牛牛牛！！！牛牛！！牛！
 * 
 * @date 2017-11-19
 * 
 * @version
 * 
 */
public class Comment {
	private String cId;// 评论编号
	private String cnId;// 新闻编号
	private String cContent;// 评论内容
	private String cDate;// 评论日期
	private String cIp;// ip地址
	private String cAuthor;// 评论者

	public Comment(String cId, String cnId, String cContent, String cDate,
			String cIp, String cAuthor) {
		super();
		this.cId = cId;
		this.cnId = cnId;
		this.cContent = cContent;
		this.cDate = cDate;
		this.cIp = cIp;
		this.cAuthor = cAuthor;
	}

	public Comment(String cnId, String cContent, String cDate, String cIp,
			String cAuthor) {
		super();
		this.cnId = cnId;
		this.cContent = cContent;
		this.cDate = cDate;
		this.cIp = cIp;
		this.cAuthor = cAuthor;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String getCnId() {
		return cnId;
	}

	public void setCnId(String cnId) {
		this.cnId = cnId;
	}

	public String getcContent() {
		return cContent;
	}

	public void setcContent(String cContent) {
		this.cContent = cContent;
	}

	public String getcDate() {
		return cDate;
	}

	public void setcDate(String cDate) {
		this.cDate = cDate;
	}

	public String getcIp() {
		return cIp;
	}

	public void setcIp(String cIp) {
		this.cIp = cIp;
	}

	public String getcAuthor() {
		return cAuthor;
	}

	public void setcAuthor(String cAuthor) {
		this.cAuthor = cAuthor;
	}

	@Override
	public String toString() {
		return "Comment [cId=" + cId + ", cnId=" + cnId + ", cContent="
				+ cContent + ", cDate=" + cDate + ", cIp=" + cIp + ", cAuthor="
				+ cAuthor + "]";
	}

}
