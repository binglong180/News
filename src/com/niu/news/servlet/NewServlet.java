package com.niu.news.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niu.news.bean.News;
import com.niu.news.bean.Page;
import com.niu.news.dao.NewsDao;
import com.niu.news.dao.impl.NewsDaoImpl;
import com.niu.news.service.NewsService;

public class NewServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NewsDao newsDao = new NewsDaoImpl();
		List<News> list1 = newsDao.getLatestNewsByTID(1, 5);//国内新闻
		List<News> list2 = newsDao.getLatestNewsByTID(2, 5);//国际新闻
		List<News> list3 = newsDao.getLatestNewsByTID(3, 5);//娱乐新闻
		request.getSession().setAttribute("list1", list1);
		request.getSession().setAttribute("list2", list2);
		request.getSession().setAttribute("list3", list3);
		String indexPage = request.getParameter("indexPage");
		int index = 1;
		if (!(indexPage == null || indexPage.trim().equals(""))) {
			index = Integer.parseInt(indexPage);
		}
		Page page1 = new Page();
		page1.setPageSize(5);
		page1.setCurPageNo(index);
		int totleCount=0;
		try {
			totleCount = newsDao.getToticCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		page1.setTotleCount(totleCount);
		page1.setTotalPageCoun(totleCount);
		NewsService ns = new NewsService();
		ns.findNews(page1);
		request.getSession().setAttribute("page", page1);
		request.getRequestDispatcher("index.jsp").forward(request,
				response);
		
	}
}
