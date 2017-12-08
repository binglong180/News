<%@page import="java.text.SimpleDateFormat"%>
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

	<div style="float:left">
		<div class="sidebar">
			<h1>
				<img src="images/title_1.gif" alt="国内新闻" />
			</h1>
			<div class="side_list">
				<ul>
					<%
						List<News> list1 = (ArrayList<News>) session.getAttribute("list1");
						List<News> list2 = (ArrayList<News>) session.getAttribute("list2");
						List<News> list3 = (ArrayList<News>) session.getAttribute("list3");
						Page pageObj = (Page) session.getAttribute("page");
						if (list1 == null || list2 == null || list3 == null
								|| pageObj == null) {
							request.getRequestDispatcher("NewServlet").forward(request,
									response);
						} else {
							NewsDao newsDao = new NewsDaoImpl();
							int i = 0;
							for (News news : list1) {
								i++;
								if (i == 6)
									break;
					%>
					<li><a href='news_read.jsp?nid=<%=news.getnId()%>'><b>
								<%=news.getnTitle()%></b> </a></li>
					<%
						}
					%>
				</ul>
			</div>
			<h1>
				<img src="images/title_2.gif" alt="国际新闻" />
			</h1>
			<div class="side_list">
				<ul>
					<%
						i = 0;
							for (News news : list2) {
								i++;
								if (i == 6)
									break;
					%>

					<li><a href='news_read.jsp?nid=<%=news.getnId()%>'><b>
								<%=news.getnTitle()%></b> </a></li>
					<%
						}
					%>
				</ul>
			</div>
			<h1>
				<img src="images/title_3.gif" alt="娱乐新闻" />
			</h1>
			<div class="side_list">
				<ul>
					<%
						i = 0;
							for (News news : list3) {
								i++;
								if (i == 6)
									break;
					%>
					<li><a href='news_read.jsp?nid=<%=news.getnId()%>'><b>
								<%=news.getnTitle()%></b> </a></li>
					<%
						}
						}
					%>
				</ul>
			</div>
		</div>
	</div>
	<div style="float:left;margin-left:100px">
		<%
			List<News> lists = pageObj.getNewsList();
			for (News news : lists) {
				String ntitle = news.getnTitle();
				int nid = news.getnId();
		%>

		<ul>
			<li><%=ntitle%>&nbsp;&nbsp;</li>

		</ul>


		<%
			}
		%>
		<div>
			<%
				if (pageObj.getCurPageNo() != 1) {
			%>
			<!-- 在href 跳转servlet的时候要./到servlet的根目录 -->
			<a href="./NewServlet?indexPage=1">首页</a> <a
				href="./NewServlet?indexPage=<%=pageObj.getCurPageNo() - 1%>">上一页</a>
			<%
				} else {
			%>
			<a style="color:gray" href="javascript:void(0)">首页</a> <a
				style="color:gray" href="javascript:void(0)">上一页</a>
			<%
				}
				if (pageObj.getCurPageNo() < pageObj.getTotalPageCoun()) {
			%>
			<a href="./NewServlet?indexPage=<%=pageObj.getCurPageNo() + 1%>">下一页</a>
			<a href="./NewServlet?indexPage=<%=pageObj.getTotalPageCoun()%>">末页</a>
			<%
				} else {
			%>
			<a style="color:gray" href="javascript:void(0)">下一页</a> <a
				style="color:gray" href="javascript:void(0)%>">末页</a>

			<%
				}
			%>


		</div>
	</div>


</body>
</html>
