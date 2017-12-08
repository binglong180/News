<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.niu.news.dao.*"%>
<%@ page import="com.niu.news.bean.*"%>
<%@ page import="com.niu.news.dao.impl.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'topic_update.jsp' starting page</title>
    
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
  	String tid =request.getParameter("tid");
 	String tName=request.getParameter("tName");
   %>
  <form method="post" action="/../news/util/topic_control.jsp?opr=update&tid=<%=tid%>">
  	<p>
  	<lable>请输入要修改后的主题名</lable>
  	<input type="text" name="tName"/>
  	</p>
  	<input type="submit" id="submit"/>
  </form>
  </body>
  
  <script type="text/javascript" src="<%=path %>/js/jquery-1.12.4.js"></script>
  <script>
  		$(function(){
  			$("#submit").click(function(){
  				var val=$("input[name='tName']").val();
  				var tName="<%=tName%>";
  				if(tName==val){
  					alert("主题名相同请重新输入");
  					return false;
  				}else{
  					
  					return true;
  				}
  			})
  		});
  </script>
</html>
