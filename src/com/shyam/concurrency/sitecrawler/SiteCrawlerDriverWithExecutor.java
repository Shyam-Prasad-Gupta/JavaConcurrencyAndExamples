package com.shyam.concurrency.sitecrawler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SiteCrawlerDriverWithExecutor {

	// private SiteDataSet sites = SiteDataSet;
	public static void main(String[] args) throws InterruptedException {

		// System.out.println("This is just to hold you here.");
		long startTime = System.currentTimeMillis();
		ExecutorService executor = Executors.newFixedThreadPool(20);
		for (int i = 0; i < 100; i++) {
			if (i < 75) {
				//Thread thd = new Thread(new SiteDataReader());
				//thd.run();
				//thd.join();
				executor.execute(new SiteDataReader());
			}
			//Thread thd = new Thread(new SiteDataCreator());
			//thd.run();
			//thd.join();
			executor.execute(new SiteDataCreator());
		}
		//this will stop the executor from accepting further runnable task
		executor.shutdown();
		
		executor.awaitTermination(1000, TimeUnit.SECONDS);
		long endTime = System.currentTimeMillis();
		System.out.println("Total time taken for execution: " + (endTime-startTime));
	}
}
