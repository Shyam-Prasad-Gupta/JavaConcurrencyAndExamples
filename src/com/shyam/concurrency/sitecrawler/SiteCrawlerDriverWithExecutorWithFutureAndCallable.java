package com.shyam.concurrency.sitecrawler;

import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SiteCrawlerDriverWithExecutorWithFutureAndCallable {

	// private SiteDataSet sites = SiteDataSet;
	public static void main(String[] args) throws InterruptedException {

		// System.out.println("This is just to hold you here.");
		long startTime = System.currentTimeMillis();
		List<Future<String>> readerThreads = new ArrayList<Future<String>>();
		List<Future<String>> creatorThreads = new ArrayList<Future<String>>();
		ExecutorService executor = Executors.newFixedThreadPool(20);
		for (int i = 0; i < 100; i++) {
			if (i < 75) {
				// Thread thd = new Thread(new SiteDataReader());
				// thd.run();
				// thd.join();
				readerThreads.add(executor.submit(new SiteDataReaderWithCallable()));// executor.execute(new
																						// SiteDataReader());
			}
			// Thread thd = new Thread(new SiteDataCreator());
			// thd.run();
			// thd.join();
			creatorThreads.add(executor.submit(new SiteDataCreatorWithCallable()));// executor.execute(new
																					// SiteDataCreator());
		}
		// this will stop the executor from accepting further runnable task
		executor.shutdown();

		executor.awaitTermination(1000, TimeUnit.SECONDS);
		long endTime = System.currentTimeMillis();
		System.out.println("Total time taken for execution: " + (endTime - startTime));
		System.out.println("Creator Thread Names: \n");
		creatorThreads.forEach((future) -> {
			try {
				System.out.println(future.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		System.out.println("Reader Thread Names: \n");
		readerThreads.forEach((future) -> {
			try {
				System.out.println(future.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
}
