<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>My JSP 'register.jsp' starting page</title>

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
		String text = (String) request.getAttribute("text");
	%>
	<div id="text" style="color:red">
		<%
			if (text != null) {
				out.print(text);
			}
		%>
	</div>
	<form method="post" action="control.jsp"
		id="regiterForm">
		<p>
			用户名：<input type="text" name="uName" id="uName" value='<%=(request.getAttribute("uName")==null ? "":request.getAttribute("uName")) %>'	`/>
		<p />
		<p>
			密码：<input type="password" name="uPassword" id="uPassword"/>
		<p />
		<p>
			确认密码：<input type="password" name="verifyPassword" id="verifyPassword"/>
		<p />
		<p>
			<input type="submit" name="submit" value="注册" />
			<%=request.getContextPath()%>
		<p />
	</form>

</body>
	<script type="text/javascript" src="<%=path%>/chapter03/news/js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="<%=path%>/chapter03/news/js/register.js"></script>
</html>
