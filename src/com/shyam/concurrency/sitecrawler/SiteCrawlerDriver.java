package com.shyam.concurrency.sitecrawler;

public class SiteCrawlerDriver {

	// private SiteDataSet sites = SiteDataSet;
	public static void main(String[] args) throws InterruptedException {

		// System.out.println("This is just to hold you here.");
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			if (i < 75) {
				Thread thd = new Thread(new SiteDataReader());
				thd.run();
				thd.join();
			}
			Thread thd = new Thread(new SiteDataCreator());
			thd.run();
			thd.join();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Total time taken for execution: " + (endTime-startTime));
	}
}
