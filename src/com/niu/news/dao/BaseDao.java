package com.niu.news.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * 数据库操作接口！
 * 
 * @author 牛牛牛！！！牛牛！！牛！
 * 
 * @date 2017-11-15
 * 
 * @version
 * 
 */
public class BaseDao {

	private static String driver = "com.mysql.jdbc.Driver";// 数据库驱动字符串
	private static String url = "jdbc:mysql://localhost:3306/news";// 连接URL字符串
	private static String user = "root"; // 数据库用户名
	private static String password = "1992121niu"; // 用户密码
	Connection conn = null;

	/**
	 * 
	 * 加载数据库配置信息！
	 * 
	 * @author 牛牛
	 * 
	 * @date 2017-11-15
	 * 
	 */

	// public Connection getConnection() {
	// Context params = null;
	// try {
	// params = new InitialContext();
	// } catch (NamingException e1) {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// }
	//
	// try {
	// DataSource ds=(DataSource) params.lookup("java:comp/env/jdbc/news");
	// try {
	// conn=ds.getConnection();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// } catch (NamingException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return conn;
	//
	//
	//
	// }
	// public static void init() {
	// Properties params = new Properties();
	// String configFile = "datebase.properties";
	// InputStream inStream = BaseDao.class.getClassLoader()
	// .getResourceAsStream(configFile);
	// try {
	// params.load(inStream);
	// driver = params.getProperty("driver");
	// url = params.getProperty("url");
	// user = params.getProperty("user");
	// password = params.getProperty("password");
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	/**
	 * 获取连接
	 * 
	 * @author 牛牛
	 * 
	 * @date 2017-11-15
	 * 
	 * @return 返回连接Connection对象
	 */

	public Connection getConnection() {
		// 加载驱动
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 建立连接
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}

	/**
	 * 
	 * 关闭所有资源！
	 * 
	 * @author 牛牛
	 * 
	 * @date 2017-11-15
	 * 
	 * @param conn
	 *            连接对象资源
	 * @param ps
	 *            发送对象资源
	 * @param rs
	 *            查询对象资源
	 */
	public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 增删改通用方法
	 * 
	 * @author 牛牛
	 * 
	 * @date 2017-11-15
	 * 
	 * @param sql
	 *            数据库操作语句
	 * @param params
	 *            操作字段
	 * @return >0为操作成功
	 */
	public int executeUpdate(String sql, Object... params) {
		int num = 0;
		conn = this.getConnection();
		PreparedStatement pS = null;
		try {
			pS = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pS.setObject(i + 1, params[i]);
			}
			num = pS.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, null, null);
		}
		return num;
	}

	/**
	 * 查询方法 自知者英，自胜者雄！
	 * 
	 * @author 牛牛
	 * 
	 * @date 2017-11-15
	 * 
	 * @param sql
	 *            数据库操作语句
	 * @param params
	 *            操作字段
	 * @return >0为操作成功
	 */
	public ResultSet executeQuery(String sql, Object... params) {
		ResultSet rS = null;
		PreparedStatement pS = null;
		conn = this.getConnection();
		try {
			pS = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pS.setObject(i + 1, params[i]);
			}
			rS = pS.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rS;
	}

}
