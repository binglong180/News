package com.niu.news.dao;

import com.niu.news.bean.User;

public interface UserDao {
	/**
	 * 
	 * 注册用户！
	 * 
	 * @author 牛牛
	 * 
	 * @date 2017-11-16
	 * 
	 * @param user
	 * @return
	 */
	public int addUser(User user);

	/**
	 * 
	 * 登录用户！
	 * 
	 * @author 牛牛
	 * 
	 * @date 2017-11-16
	 * 
	 * @param user
	 * @return
	 */
	public int login(User user);
}
