package com.shyam.concurrency.sitecrawler;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class SiteDataReaderWithCompletableFuture /* implements Callable<String> */ {

	private SiteDataSet siteData = SiteDataSet.getSiteDataSetInstance();

	public CompletableFuture<String> getCompletableFutureSiteReader() {
		CompletableFuture<String> siteReader = CompletableFuture.supplyAsync(() -> {
			while (siteData.crawlSite()) {
				
			};
			return Thread.currentThread().getName();
		});
		
		return siteReader;
	}
}
