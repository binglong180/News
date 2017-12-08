package com.niu.news.dao;

import java.sql.SQLException;
import java.util.List;

import com.niu.news.bean.News;

public interface NewsDao {
	/**
	 * 
	 * 通过Tid获得主题下的新闻数量！
	 * 
	 * @author 牛牛
	 * 
	 * @date 2017-11-22
	 * 
	 * @param tid
	 *            主题编号
	 * @return >0 说明有新闻，=0说明没有新闻
	 */
	public int getNewsCountByTID(int tid);

	/**
	 * 
	 * 获取某主题下的最新新闻！
	 * 
	 * @author 牛牛
	 * 
	 * @date 2017-11-22
	 * 
	 * @param tid
	 *            主题编号
	 * @param limit
	 *            显示的行数
	 * @return 返回新闻集合
	 */
	public List<News> getLatestNewsByTID(int tid, int limit);

	/**
	 * 
	 * 获得全部新闻！
	 * 
	 * @author 牛牛
	 * 
	 * @date 2017-11-25
	 * 
	 * @return 返回新闻
	 */
	public List<News> getAllNews();

	/**
	 * 
	 * 查询新闻总数！
	 * 
	 * @author 牛牛
	 * 
	 * @date 2017-11-26
	 * 
	 * @return 返回新闻总数
	 * @throws SQLException
	 */
	public int getToticCount() throws SQLException;

	/**
	 * 
	 * 获得当前页面的新闻！
	 * 
	 * @author 牛牛
	 * 
	 * @date 2017-11-26
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<News> getPageNewsList(int pageNo, int pageSize);
}
