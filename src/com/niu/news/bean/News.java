package com.niu.news.bean;

import java.util.Date;
import java.util.List;

/**
 * 
 * 新闻类！
 * 
 * @author 牛牛牛！！！牛牛！！牛！
 * 
 * @date 2017-11-19
 * 
 * @version
 * 
 */
public class News {
	private int nId;// 新闻编号
	private int ntId;// 主题编号
	private String ntName;// 新闻主题名
	private List<Comment> comments;// 评论内容
	private String nTitle;// 新闻题目
	private String nAuthor;// 作者
	private String nCreatedate;// 日期
	private String nPicpath;// 图片路径
	private String nContent;// 内容
	private String nModifydate;// 修改日期
	private String nSummary;// 摘要

	public News(int nId, int ntId, String ntName, List<Comment> comments,
			String nTitle, String nAuthor, String nCreatedate, String nPicpath,
			String nContent, String nModifydate, String nSummary) {
		super();
		this.nId = nId;
		this.ntId = ntId;
		this.ntName = ntName;
		this.comments = comments;
		this.nTitle = nTitle;
		this.nAuthor = nAuthor;
		this.nCreatedate = nCreatedate;
		this.nPicpath = nPicpath;
		this.nContent = nContent;
		this.nModifydate = nModifydate;
		this.nSummary = nSummary;
	}

	public News(int ntId, String ntName, List<Comment> comments, String nTitle,
			String nAuthor, String nCreatedate, String nPicpath, String nContent,
			String nModifydate, String nSummary) {
		super();
		this.ntId = ntId;
		this.ntName = ntName;
		this.comments = comments;
		this.nTitle = nTitle;
		this.nAuthor = nAuthor;
		this.nCreatedate = nCreatedate;
		this.nPicpath = nPicpath;
		this.nContent = nContent;
		this.nModifydate = nModifydate;
		this.nSummary = nSummary;
	}

	public News(String ntName, List<Comment> comments, String nTitle,
			String nAuthor, String nCreatedate, String nPicpath, String nContent,
			String nModifydate, String nSummary) {
		super();
		this.ntName = ntName;
		this.comments = comments;
		this.nTitle = nTitle;
		this.nAuthor = nAuthor;
		this.nCreatedate = nCreatedate;
		this.nPicpath = nPicpath;
		this.nContent = nContent;
		this.nModifydate = nModifydate;
		this.nSummary = nSummary;
	}

	public News() {
		super();
	}

	public int getnId() {
		return nId;
	}

	public void setnId(int i) {
		this.nId = i;
	}

	public int getNtId() {
		return ntId;
	}

	public void setNtId(int i) {
		this.ntId = i;
	}

	public String getNtName() {
		return ntName;
	}

	public void setNtName(String ntName) {
		this.ntName = ntName;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getnAuthor() {
		return nAuthor;
	}

	public void setnAuthor(String nAuthor) {
		this.nAuthor = nAuthor;
	}

	public String getnCreatedate() {
		return nCreatedate;
	}

	public void setnCreatedate(String nCreatedate) {
		this.nCreatedate = nCreatedate;
	}

	public String getnPicpath() {
		return nPicpath;
	}

	public void setnPicpath(String nPicpath) {
		this.nPicpath = nPicpath;
	}

	public String getnContent() {
		return nContent;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}

	public String getnModifydate() {
		return nModifydate;
	}

	public void setnModifydate(String nModifydate) {
		this.nModifydate = nModifydate;
	}

	public String getnSummary() {
		return nSummary;
	}

	public void setnSummary(String nSummary) {
		this.nSummary = nSummary;
	}

}
