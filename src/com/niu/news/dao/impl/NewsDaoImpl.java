package com.niu.news.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.niu.news.bean.News;
import com.niu.news.dao.BaseDao;
import com.niu.news.dao.NewsDao;

public class NewsDaoImpl extends BaseDao implements NewsDao {

	@Override
	public int getNewsCountByTID(int tid) {
		int result = 0;
		String sql = "select count(ntid) from news where ntid=?";
		ResultSet rs = this.executeQuery(sql, tid);
		try {
			rs.next();
			result = rs.getInt(1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(null, null, rs);
		}
		return result;
	}

	@Override
	public List<News> getLatestNewsByTID(int tid, int limit) {

		String sql = "SELECT ntid,nid,nTitle FROM news where ntid=? order by nCreatedate desc LIMIT ?";
		ResultSet rs = this.executeQuery(sql, tid, limit);
		List<News> list = new ArrayList<News>();
		try {
			while (rs.next()) {
				News news = new News();
				news.setNtId(rs.getInt("ntid"));
				news.setnId(rs.getInt("nid"));
				news.setnTitle(rs.getString("nTitle"));
				list.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(null, null, rs);
		}
		return list;
	}

	@Override
	public List<News> getAllNews() {
		// 获得全部新闻
		List<News> list = new ArrayList<News>();
		String sql = "SELECT nid,ntid,ntitle,nauthor,nCreatedate,nContent,nModifydate FROM news;";
		ResultSet rs = this.executeQuery(sql);

		try {
			while (rs.next()) {
				News news = new News();
				news.setnId(rs.getInt("nid"));
				news.setNtId(rs.getInt("ntid"));
				news.setnTitle(rs.getString("ntitle"));
				news.setnAuthor(rs.getString("nauthor"));
				news.setnAuthor(rs.getString("nCreatedate"));
				news.setnContent(rs.getString("nContent"));
				news.setnModifydate(rs.getString("nModifydate"));
				list.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(null, null, rs);

		}
		return list;
	}

	@Override
	public int getToticCount() {
		int num = 0;
		String sql = "SELECT COUNT(nid) FROM news;";
		ResultSet rs = this.executeQuery(sql);
		try {
			rs.next();
			num = rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public List<News> getPageNewsList(int pageNo, int pageSize) {
		List<News> list = new ArrayList<News>();
		String sql = "SELECT nid,ntid,ntitle,nauthor,nCreatedate,nContent,nModifydate FROM news LIMIT ?,?;";
		BaseDao bd = new BaseDao();
		int index = (pageNo - 1) * pageSize;

		ResultSet rs = bd.executeQuery(sql, index, pageSize);

		try {
			while (rs.next()) {
				News news = new News();
				news.setnId(rs.getInt("nid"));
				news.setNtId(rs.getInt("ntid"));
				news.setnTitle(rs.getString("ntitle"));
				news.setnAuthor(rs.getString("nauthor"));
				news.setnCreatedate(rs.getString("nCreatedate"));
				news.setnContent(rs.getString("nContent"));
				news.setnModifydate(rs.getString("nModifydate"));
				list.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(null, null, rs);

		}
		return list;
	}

}
