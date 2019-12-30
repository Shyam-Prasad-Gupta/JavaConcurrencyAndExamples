package com.shyam.concurrency.sitecrawler;

import java.util.ArrayList;
import java.util.List;

public class SiteDataSet {

	private int siteCount = 0;
	private List<String> crawledSites = new ArrayList<String>();
	private List<String> linkedSites = new ArrayList<String>();

	private static volatile SiteDataSet siteDataSetSingleton = new SiteDataSet();

	private SiteDataSet() {
	}

	public static SiteDataSet getSiteDataSetInstance() {
		return siteDataSetSingleton;
	}

	public void addNewSite(String newSite) {
		synchronized (this) {
			// check if this site is already in the linkedSites or not
			if (!linkedSites.contains(newSite)) {
				linkedSites.add(newSite);
				siteCount++;
			}
		}
	}

	public boolean crawlSite() {

		synchronized (this) {
			// if the linkedSite list is empty do nothing
			if (linkedSites.size() > 0) {
				crawledSites.add(linkedSites.get(0));
				System.out.println("Crawled site: " + linkedSites.remove(0));
				System.out.println("Sites left to crawl: " + linkedSites.size());
				System.out.println("Sites crawled till now: " + crawledSites.size());
			}else {
				System.out.println("Sites created till now: " + siteCount);
			}
			return linkedSites.size() > 0 ? true : false;
		}
	}
}
