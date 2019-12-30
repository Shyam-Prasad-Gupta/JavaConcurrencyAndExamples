package com.shyam.concurrency.sitecrawler;

import java.util.ArrayList;
import java.util.List;

public enum TechGiantsSites {

	GOOGLE(0, "Google", "www.google.com"), MICROSOFT(1, "Microsoft", "www.microsoft.com"),
	FACEBOOK(2, "Facebook", "www.facebook.com"), ORACLE(3, "Oracle", "www.oracle.com"),
	TWITTER(4, "Twitter", "www.twitter.com"), REDMI(5, "Redmi", "www.mi.com"), ADOBE(6, "Adobe", "www.adobe.com"),
	IBM(7, "IBM", "www.ibm.com"), HCL(8, "HCL", "www.hindustancomputersltd.com"), WIPRO(9, "Wipro", "www.wipro.com"),
	TCH(10, "TCS", "www.tataconsultancy.com"), INFOSYS(11, "Infosys", "www.infosys.com");

	private final int siteCode;
	private final String compName;
	private final String compSite;

	private TechGiantsSites(int siteCode, String compName, String compSite) {
		this.siteCode = siteCode;
		this.compName = compName;
		this.compSite = compSite;
	}

	public int getSiteCode() {
		return this.siteCode;
	}

	public String getCompName() {
		return this.compName;
	}

	public String getCompSite() {
		return this.compSite;
	}

	public List<String> getCompSites() {

		TechGiantsSites[] techArr = TechGiantsSites.values();
		List<String> siteList = new ArrayList<>();
		for (int i = 0; i < techArr.length; i++) {
			siteList.add(techArr[i].compSite);
		}
		return siteList;
	}
}
