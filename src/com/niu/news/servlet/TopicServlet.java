package com.niu.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niu.news.bean.Topic;
import com.niu.news.dao.NewsDao;
import com.niu.news.dao.TopicDao;
import com.niu.news.dao.impl.NewsDaoImpl;
import com.niu.news.dao.impl.TopicDaoImpl;

public class TopicServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String contextPath = request.getContextPath();
		String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()+contextPath;
		String opr = request.getParameter("opr");
		if (opr.equals("list")) {
			TopicDao td = new TopicDaoImpl();
			List<Topic> list = td.getAllTopics();
			if (list != null) {
				request.setAttribute("list", list);
			}
			try {
				request.getRequestDispatcher(contextPath+"/newPages/topic_list.jsp")
						.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (opr.equals("add")) {
			String tName = request.getParameter("tName");
			if (!(tName == null || tName.trim().equals(""))) {
				TopicDao td = new TopicDaoImpl();
				Topic topic = td.findTopicByName(tName);
				if (topic == null) {
					td.addTopic(tName);

					out.print("<script type='text/javascript'>"
							+ "alert('修改成功');"
							+ "location.href=\""+contextPath+"/util/topic_control.jsp?opr=list\";</script>");
				} else {

					out.print("<script type='text/javascript'>"
							+ "alert('当前主题已存在！请输入不同的主题');"
							+ "location.href='"+ contextPath+"/newPages/topic_add.jsp';</script>");

				}
			} else {
				out.print("<script type='text/javascript'>"
						+ "alert('当前无输入主题！请输入主题');"
						+ "location.href='"+ contextPath+"/newPages/topic_add.jsp';</script>");

			}
		} else if (opr.equals("del")) {
			NewsDao nd = new NewsDaoImpl();
			String tidStr = request.getParameter("tid");
			int tid = Integer.parseInt(tidStr);
			int result = nd.getNewsCountByTID(tid);
			if (result == 0) {
				TopicDao td = new TopicDaoImpl();
				result = td.deleteTopic(tid);
				if (result > 0) {
					out.print("<script type='text/javascript'>"
							+ "alert('删除主题成功！');"
							+ "location.href='util/topic_control.jsp?opr=list';</script>");

				} else {
					out.print("<script type='text/javascript'>"
							+ "alert('未删除主题！请稍后重试！');"
							+ "location.href='util/topic_control.jsp?opr=list';</script>");

				}
			} else {

				out.print("<script type='text/javascript'>"
						+ "alert('该主题下有文章，未删除主题！');"
						+ "location.href='util/topic_control.jsp?opr=list';</script>");

			}

		} else if (opr.equals("update")) {
			String tName = request.getParameter("tName");
			if (!(tName == null || tName.trim().equals(""))) {
				int result = 0;
				TopicDao td = new TopicDaoImpl();
				Topic topic = td.findTopicByName(tName);
				if (topic == null) {
					String tidStr = request.getParameter("tid");
					int tid = Integer.parseInt(tidStr);
					tName = request.getParameter("tName");
					topic = new Topic(tid, tName);
					result = td.updateTopic(topic);
					if (result > 0) {
						out.print("<script type='text/javascript'>"
								+ "alert('主题修改成功！');"
								+ "location.href='../news/util/topic_control.jsp?opr=list';</script>");

					} else {
						out.print("<script type='text/javascript'>"
								+ "alert('主题修改失敗！');"
								+ "location.href='../news/util/topic_control.jsp?opr=list';</script>");
					}
				} else {

					out.print("<script type='text/javascript'>"
							+ "alert('当前主题以存在！请输入不同的主题');"
							+ "location.href='../news/util/topic_control.jsp?opr=list';</script>");

				}
			}

		}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			doGet(request, response);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
