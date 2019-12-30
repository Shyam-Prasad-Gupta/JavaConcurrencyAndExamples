package com.shyam.concurrency.sitecrawler;

public class SiteDataReader implements Runnable {

	private SiteDataSet siteData = SiteDataSet.getSiteDataSetInstance();

	@Override
	public void run() {
		while(siteData.crawlSite()) {}
	}
}
