package com.shyam.concurrency.sitecrawler;

public class RunImplementer implements Runnable {

	@Override
	public void run() {
		System.out.println("Just Check");
		try {
			Thread.sleep(1000);
			this.wait(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
