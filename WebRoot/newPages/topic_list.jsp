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
	<div id="opt_area">
		<ul>

		</ul>
	</div>





</body>
<script type="text/javascript" src="<%=path%>/js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	initNews();
	function initNews() {
		alert(111);
		$.ajax({
			"url" : "<%=path%>/topic",
			"type" : "GET",
			"data" : "opr=list",
			"dataType" : "json",
			"success" : processNewsList
		});
		alert(2222);

	}
	function processNewsList(data) {
		var $topicList = $("#opt_area>ul").empty();
		$topicList.after("<li>1111111111</li>");
		for ( var i = 0; i < data.length; i++) {
			$topicList.append("<li>" + data[i].tName + "<a href='#'>修改</a>"
					+ "</li>");
		}
	}
	
</script>
</html>
