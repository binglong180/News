<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
		<c:forEach var="topic" items="${list }">
			<li>${topic.tName}&nbsp;&nbsp;<a
				href="newPages/topic_update.jsp?opr=update&tid=${topic.tId }&tName=${topic.tName}">修改</a>&nbsp;&nbsp;
				<a href="./topic?opr=del&tid=${topic.tId }">删除</a>
			</li>
		</c:forEach>
	</ul>




</body>
</html>
