package com.niu.news.dao.impl;

import java.sql.ResultSet;

import com.niu.news.bean.User;
import com.niu.news.dao.BaseDao;
import com.niu.news.dao.UserDao;

public class UserDaoImpl extends BaseDao implements UserDao {
	@Override
	public int addUser(User user) {
		int num = 0;
		String uName = user.getuName();
		String uPassword = user.getuPassword();
		try {
			String sql = "insert into user(uName,uPassword) values(?,?);";
			num = this.executeUpdate(sql, uName, uPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int login(User user) {
		int num = 0;
		String uName = user.getuName();
		String uPassword = user.getuPassword();
		ResultSet rS = null;
		try {
			String sql = "select uName,uPassword from user;";
			rS = this.executeQuery(sql);
			if (rS != null) {
				while (rS.next()) {
					String dbuName = rS.getString("uName");
					String dbuPassword = rS.getString("uPassword");
					if (uName.equals(dbuName) && uPassword.equals(dbuPassword)) {
						num = 10;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(null, null, rS);
		}
		return num;
	}

}
