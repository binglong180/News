package com.niu.news.dao;

import java.util.List;

import com.niu.news.bean.Topic;

/**
 * 
 * z主题接口！
 * 
 * @author 牛牛牛！！！牛牛！！牛！
 * 
 * @date 2017-11-19
 * 
 * @version
 * 
 */
public interface TopicDao {
	/**
	 * 
	 * 获得所有主题！
	 * 
	 * @author 牛牛
	 * 
	 * @date 2017-11-19
	 * 
	 * @return
	 */
	public List<Topic> getAllTopics();

	/**
	 * 
	 * 更新主题！
	 * 
	 * @author 牛牛
	 * 
	 * @date 2017-11-19
	 * 
	 * @param topic
	 * @return 返回值>0说明更新主题成功
	 */
	public int updateTopic(Topic topic);

	/**
	 * 
	 * 根据名字查找主题！
	 * 
	 * @author 牛牛
	 * 
	 * @date 2017-11-19
	 * 
	 * @param name
	 * @return
	 */
	public Topic findTopicByName(String name);

	/**
	 * 
	 * 自知者英，自胜者雄！
	 * 
	 * @author 牛牛
	 * 
	 * @date 2017-11-19
	 * 
	 * @param name
	 * @return 返回值>0说明添加成功
	 */
	public int addTopic(String name);

	/**
	 * 
	 * 根据tid删除主题！
	 * 
	 * @author 牛牛
	 * 
	 * @date 2017-11-19
	 * 
	 * @param tid
	 * @return 返回值>0说明删除成功
	 */
	public int deleteTopic(int tid);

}
