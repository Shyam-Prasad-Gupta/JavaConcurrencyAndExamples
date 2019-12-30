package com.shyam.concurrency.sitecrawler;

import java.util.concurrent.Callable;

public class SiteDataCreatorWithCallable implements Callable<String> {

	private SiteDataSet siteDataSet = SiteDataSet.getSiteDataSetInstance();

	@Override
	public String call() {

		for (int i = 0; i < 1000; i++) {
			double randNum = Math.random();

			int enumOrdinal = (int) Math.floor(randNum * 12);
			int randomNumber = (int) Math.floor((randNum * 100000));

			String newSite = TechGiantsSites.values()[enumOrdinal].getCompSite() + "/" + randomNumber;
			siteDataSet.addNewSite(newSite);
			
		}
		return Thread.currentThread().getName();
	}

}
