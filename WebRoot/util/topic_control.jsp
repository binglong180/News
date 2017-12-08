<%@page import="javax.print.attribute.IntegerSyntax"%>
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
    
    <title>My JSP 'topic_control.jsp' starting page</title>
    
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
    String opr=request.getParameter("opr");
    if(opr.equals("list")){
		TopicDao td = new TopicDaoImpl();
		List<Topic> list = td.getAllTopics();
		if (list!=null) {
			request.setAttribute("list", list);
		}
		request.getRequestDispatcher("../newPages/topic_list.jsp")
					.forward(request, response);
    }else if(opr.equals("add")){
		String tName = request.getParameter("tName");
		if (!(tName == null || tName.trim().equals(""))) {
			TopicDao td = new TopicDaoImpl();
			Topic topic = td.findTopicByName(tName);
			if (topic == null) {
					td.addTopic(tName);
	%>
		<script type="text/javascript">
		alert("当前主题保存成功");
		location.href="../news/util/topic_control.jsp?opr=list";
	</script>
	<% 

				} else {
	%>
		<script type="text/javascript">
		alert("当前主题已存在！请输入不同的主题");
		location.href="../news/newPages/topic_add.jsp";
</script>
	<% 
	
	
				}
		} else {
	%>
		<script type="text/javascript">
		alert("当前无输入主题！请输入主题");
		location.href="../news/newPages/topic_add.jsp";
</script>
	<% 
		
		}
    }else if(opr.equals("del")){
    	NewsDao nd=new NewsDaoImpl();
    	String tidStr=request.getParameter("tid");
    	int tid=Integer.parseInt(tidStr);
    	int result=nd.getNewsCountByTID(tid);
    	if(result==0){
    		TopicDao td=new TopicDaoImpl();
    		result=td.deleteTopic(tid);
    		if(result>0){
    		%>
    		<script type="text/javascript">
    		alert("删除主题成功！");
    		location.href="util/topic_control.jsp?opr=list";
    		</script>
    		<%
    		}else{
    		%>
    		
    		<script type="text/javascript">
    		alert("未删除主题！请稍后重试！");
    		location.href="util/topic_control.jsp?opr=list";
    		</script>
    		<%
    		}
    	}else{
    	%>
    		<script type="text/javascript">
    		alert("该主题下有文章，未删除主题！");
    		location.href="util/topic_control.jsp?opr=list";
    		</script>
    		
    	<%
    	}
    
    }else if(opr.equals("update")){
		String tName = request.getParameter("tName");
		if (!(tName == null || tName.trim().equals(""))) {
			int result=0;
			TopicDao td = new TopicDaoImpl();
			Topic topic = td.findTopicByName(tName);
			if (topic == null) {
			String tidStr=request.getParameter("tid");
    		int tid=Integer.parseInt(tidStr);
    		tName=request.getParameter("tName");
    		topic=new Topic(tid,tName);
    		result=td.updateTopic(topic);
					if(result>0){
						%>
						<script type="text/javascript">
								alert("主题修改成功");
								location.href="../news/util/topic_control.jsp?opr=list";
						</script>
						<% 
					}else{
					%>
						<script type="text/javascript">
								alert("主题修改失敗");
								location.href="../news/util/topic_control.jsp?opr=list";
						</script>
						<% 
					}
				} else {
	%>
		<script type="text/javascript">
		alert("当前主题以存在！请输入不同的主题");
		location.href="../news/util/topic_control.jsp?opr=list";
</script>
	
<%
	
				}
		} 
		
}
%>   		
   
  </body>
</html>
