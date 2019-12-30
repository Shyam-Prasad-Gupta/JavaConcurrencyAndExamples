package com.shyam.concurrency.sitecrawler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SiteCrawlerDriverWithExecutorAndCompletableFuture {

	// private SiteDataSet sites = SiteDataSet;
	public static void main(String[] args) throws InterruptedException {

		// System.out.println("This is just to hold you here.");
		long startTime = System.currentTimeMillis();
		// ExecutorService executor = Executors.newFixedThreadPool(20);
		List<CompletableFuture<String>> siteCreator = new ArrayList<CompletableFuture<String>>();
		List<CompletableFuture<String>> siteReader = new ArrayList<CompletableFuture<String>>();
		for (int i = 0; i < 100; i++) {
			if (i < 75) {
				siteReader.add(new SiteDataReaderWithCompletableFuture().getCompletableFutureSiteReader()
						.thenApply((String threadName) -> {
							return "Thread name is: " + threadName;
						}));
			}
			siteCreator.add(
					new SiteDataCreatorWithCompletableFuture().getCompletableFuture().thenApply((String threadName) -> {
						return "Thread name is: " + threadName;
					}));
		}
		// this will stop the executor from accepting further runnable task
		// executor.shutdown();
		siteCreator.forEach((obj) -> {
			try {
				System.out.println(obj.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		siteReader.forEach((obj) -> {
			try {
				System.out.println(obj.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		// executor.awaitTermination(1000, TimeUnit.SECONDS);
		long endTime = System.currentTimeMillis();
		System.out.println("Total time taken for execution: " + (endTime - startTime));
	}
}
