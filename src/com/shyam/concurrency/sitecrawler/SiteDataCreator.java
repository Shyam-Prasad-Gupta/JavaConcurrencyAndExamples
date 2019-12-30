package com.shyam.concurrency.sitecrawler;

public class SiteDataCreator implements Runnable {

	private SiteDataSet siteDataSet = SiteDataSet.getSiteDataSetInstance();

	@Override
	public void run() {

		for (int i = 0; i < 1000; i++) {
			double randNum = Math.random();

			int enumOrdinal = (int) Math.floor(randNum * 12);
			int randomNumber = (int) Math.floor((randNum * 100000));

			String newSite = TechGiantsSites.values()[enumOrdinal].getCompSite() + "/" + randomNumber;
			siteDataSet.addNewSite(newSite);
		}

	}

}
