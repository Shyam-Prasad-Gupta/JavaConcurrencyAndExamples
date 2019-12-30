package com.shyam.concurrency.sitecrawler;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class SiteDataReaderWithCallable implements Callable<String> {

	private SiteDataSet siteData = SiteDataSet.getSiteDataSetInstance();

	@Override
	public String call() {
		while (siteData.crawlSite()) {
		}
		return Thread.currentThread().getName();
	}
}
