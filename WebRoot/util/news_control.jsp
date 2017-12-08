<%@page import="com.niu.news.service.NewsService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.niu.news.dao.*"%>
<%@ page import="com.niu.news.bean.*"%>
<%@ page import="com.niu.news.dao.impl.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'news_control.jsp' starting page</title>

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
		NewsDao newsDao = new NewsDaoImpl();
		List<News> list1 = newsDao.getLatestNewsByTID(1, 5);//国内新闻
		List<News> list2 = newsDao.getLatestNewsByTID(2, 5);//国际新闻
		List<News> list3 = newsDao.getLatestNewsByTID(3, 5);//娱乐新闻
		session.setAttribute("list1", list1);
		session.setAttribute("list2", list2);
		session.setAttribute("list3", list3);
		String indexPage = request.getParameter("indexPage");
		int index = 1;
		if (!(indexPage == null || indexPage.trim().equals(""))) {
			index = Integer.parseInt(indexPage);
		}
		Page page1 = new Page();
		page1.setPageSize(5);
		page1.setCurPageNo(index);
		int totleCount = newsDao.getToticCount();
		page1.setTotleCount(totleCount);
		page1.setTotalPageCoun(totleCount);
		NewsService ns = new NewsService();
		ns.findNews(page1);
		session.setAttribute("page", page1);
		request.getRequestDispatcher("../index.jsp").forward(request,
				response);
	%>
</body>

</html>
