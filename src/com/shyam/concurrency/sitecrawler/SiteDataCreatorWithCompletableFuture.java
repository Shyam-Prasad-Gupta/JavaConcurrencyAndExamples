package com.shyam.concurrency.sitecrawler;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

public class SiteDataCreatorWithCompletableFuture /* implements Callable<String> */ {

	private SiteDataSet siteDataSet = SiteDataSet.getSiteDataSetInstance();

	public CompletableFuture<String> getCompletableFuture() {

		CompletableFuture<String> result = CompletableFuture.supplyAsync(() -> {
			for (int i = 0; i < 1000; i++) {
				double randNum = Math.random();

				int enumOrdinal = (int) Math.floor(randNum * 12);
				int randomNumber = (int) Math.floor((randNum * 100000));

				String newSite = TechGiantsSites.values()[enumOrdinal].getCompSite() + "/" + randomNumber;
				siteDataSet.addNewSite(newSite);
				try {
					Thread.currentThread().sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			return Thread.currentThread().getName();
		});
		return result;
	}

}
