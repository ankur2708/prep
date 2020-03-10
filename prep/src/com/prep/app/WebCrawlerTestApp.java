package com.prep.app;

import com.prep.process.WebCrawler;

public class WebCrawlerTestApp {
	
	public static void main(String[] args) throws Exception {
		
		
		WebCrawler crawler = new WebCrawler("https://timesofindia.indiatimes.com/");
		crawler.crawl();
		
	}

}
