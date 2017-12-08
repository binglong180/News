package com.niu.news.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.niu.news.bean.News;
import com.niu.news.bean.Page;
import com.niu.news.dao.NewsDao;

public class Mytest {

	@Test
	public void testGetToticCount() throws SQLException {
		NewsDao nd = new NewsDaoImpl();
		Page page = new Page();
		int num = nd.getToticCount();
		System.out.println(num);
		page.setTotleCount(num);
		page.setPageSize(5);
		page.setCurPageNo(3);
		page.setTotalPageCoun(num);
		System.out.println("共有》》》》》" + page.getTotleCount() + "新闻");
		System.out.println("共有》》》》》" + page.getTotalPageCoun() + "页");
		List<News> list = nd.getPageNewsList(page.getCurPageNo(),
				page.getPageSize());
		for (News news : list) {
			System.out.println(news.getnTitle() + "\t");
			;
		}

	}

}
