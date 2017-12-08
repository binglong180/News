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

<title>My JSP 'topic_list.jsp' starting page</title>

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
	<div>
		<%@include file="element/topic_left.html"%>
	</div>
	<ul>
		<%
			request.setCharacterEncoding("utf-8");
			List<Topic> list = (ArrayList<Topic>) request.getAttribute("list");

			for (Topic topic : list) {
				int tid = topic.gettId();
		%>
		<li><%=topic.gettName()%>&nbsp;&nbsp;<a
			href="newPages/topic_update.jsp?opr=update&tid=<%=tid%>&tName=<%=topic.gettName()%>">修改</a>&nbsp;&nbsp;
			<a href="./topic?opr=del&tid=<%=tid%>">删除</a>
		</li>
		<%
			}
		%>
	</ul>



</body>
</html>
