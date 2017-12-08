<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.niu.news.dao.*"%>
<%@ page import="com.niu.news.bean.*"%>
<%@ page import="com.niu.news.dao.impl.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>新闻首页</title>

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
	<c:if test="${empty list1||empty list2||empty list3||empty page}">
		<%
			request.getRequestDispatcher("NewServlet").forward(request,
						response);
		%>
	</c:if>
	<a href="newPages/login.jsp">登录</a>
	<a href="newPages/register.jsp">注册</a>
	<div style="float:left;width=100px">
		<div class="sidebar">
			<h1>
				<img src="images/title_1.gif" alt="国内新闻" />
			</h1>
			<div class="side_list">
				<ul>
					<c:forEach var="list1" items="${list1}">
						<li><a href='news_read.jsp?nid=${list1.nId}'><b>${list1.nTitle}</b>

						</a>
						</li>
					</c:forEach>
				</ul>
			</div>

			<h1>
				<img src="images/title_1.gif" alt="国外新闻" />
			</h1>
			<div class="side_list">
				<ul>
					<c:forEach var="list2" items="${list2}">
						<li><a href='news_read.jsp?nid=${list2.nId}'><b>${list2.nTitle}</b>

						</a>
						</li>
					</c:forEach>
				</ul>
			</div>

			<h1>
				<img src="images/title_1.gif" alt="娱乐新闻" />
			</h1>
			<div class="side_list">
				<ul>
					<c:forEach var="list3" items="${list3}">
						<li><a href='news_read.jsp?nid=${list3.nId}'><b>${list3.nTitle}</b>

						</a>
						</li>
					</c:forEach>
				</ul>
			</div>



		</div>

	</div>
	<div style="float:left;margin-left:100px;width:200px">
		<c:set var="pageObj" value="${page}"></c:set>
		${pageObj.curPageNo} ${pageObj.totalPageCoun}
		<c:forEach var="news" items="${pageObj.newsList}">
			<ul>
				<li>${news.nTitle}</li>
			</ul>
		</c:forEach>
		<c:choose>
			<c:when test="${ pageObj.curPageNo eq 1}">
				<a style="color:gray" href="javascript:void(0)">首页</a>
				<a style="color:gray" href="javascript:void(0)">上一页</a>
			</c:when>
			<c:otherwise>
				<a href="./NewServlet?indexPage=1">首页</a>
				<a href="./NewServlet?indexPage=${pageObj.curPageNo - 1}">上一页</a>

			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${pageObj.curPageNo lt pageObj.totalPageCoun}">
				<a href="./NewServlet?indexPage=${pageObj.curPageNo + 1}">下一页</a>
				<a href="./NewServlet?indexPage=${pageObj.totalPageCoun}">末页</a>
			</c:when>
			<c:otherwise>
				<a style="color:gray" href="javascript:void(0)">下一页</a>
				<a style="color:gray" href="javascript:void(0)">末页</a>

			</c:otherwise>
		</c:choose>

	</div>

</body>
</html>
