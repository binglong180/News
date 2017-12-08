package com.niu.news.service;

import java.util.ArrayList;
import java.util.List;

import com.niu.news.bean.News;
import com.niu.news.bean.Page;
import com.niu.news.dao.NewsDao;
import com.niu.news.dao.impl.NewsDaoImpl;

public class NewsService {
	public void findNews(Page page) {
		NewsDao nd = new NewsDaoImpl();
		int pageNo = page.getCurPageNo();
		int pageSize = page.getPageSize();
		if (page.getTotleCount() > 0) {
			List<News> list = page.getCurPageNo() > page.getTotalPageCoun() ? nd
					.getAllNews() : nd.getPageNewsList(pageNo, pageSize);
			page.setNewsList(list);
		} else {
			page.setCurPageNo(0);
			page.setNewsList(new ArrayList<News>());
		}

	}
}
