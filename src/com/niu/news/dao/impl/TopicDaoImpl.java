package com.niu.news.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.niu.news.bean.Topic;
import com.niu.news.dao.BaseDao;
import com.niu.news.dao.TopicDao;

public class TopicDaoImpl extends BaseDao implements TopicDao {

	@Override
	public List<Topic> getAllTopics() {
		List<Topic> list = new ArrayList<Topic>();
		Topic topic = null;
		String sql = "SELECT tName,tid FROM topic;";
		ResultSet rs = null;
		rs = this.executeQuery(sql);
		try {
			while (rs.next()) {
				String tName = rs.getString("tName");
				Integer tid = rs.getInt("tid");
				topic = new Topic(tid, tName);
				list.add(topic);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public int updateTopic(Topic topic) {
		// TODO Auto-generated method stub
		int num = 0;
		int tId = topic.gettId();
		String tName = topic.gettName();
		String sql = "update topic set tName=? where tid=?;";
		num = this.executeUpdate(sql, tName, tId);
		return num;
	}

	@Override
	public Topic findTopicByName(String name) {
		List<Topic> list = new ArrayList<Topic>();
		list = this.getAllTopics();
		Topic topic = null;
		for (Topic topics : list) {
			if (topics.gettName().equals(name))

				return topics;
		}
		return topic;
	}

	@Override
	public int addTopic(String name) {
		int num = 0;
		String sql = "insert into topic(tName) values (?);";
		num = this.executeUpdate(sql, name);
		return num;
	}

	@Override
	public int deleteTopic(int tid) {
		int num = 0;
		String sql = "delete from topic where tid=?;";
		num = this.executeUpdate(sql, tid);
		return num;
	}

}
