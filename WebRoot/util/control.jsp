<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.niu.news.bean.User"%>
<%@ page import="com.niu.news.dao.impl.UserDaoImpl"%>
<%@ page import="com.niu.news.dao.UserDao"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'control.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<%
		request.setCharacterEncoding("utf-8");
		int result = 0;
		String uName = request.getParameter("uName");
		request.setAttribute("uName", uName);
		String uPassword = request.getParameter("uPassword");
		String verifyPassword = request.getParameter("verifyPassword");
		if (uName == null || uName.trim().equals("")) {
			request.setAttribute("text", "用户名不能为空！");
		} else if (uPassword == null || uPassword.trim().equals("")) {
			request.setAttribute("text", "密码不能为空");
		} else if (!uPassword.equals(verifyPassword)) {
			request.setAttribute("text", "两次密码不一致");
		} else {
			User user = new User(uName, uPassword);
			UserDao userDao = new UserDaoImpl();
			result = userDao.addUser(user);
		}
		if (result >0) {
			response.sendRedirect(""+path+"/index.jsp");
		} else {
			request.getRequestDispatcher("register.jsp").forward(request,
					response);
		}
	%>
</body>
</html>
