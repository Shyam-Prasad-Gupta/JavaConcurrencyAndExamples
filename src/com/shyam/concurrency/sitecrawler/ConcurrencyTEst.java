package com.shyam.concurrency.sitecrawler;

public class ConcurrencyTEst {

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(() -> {
			System.out.println("Hi, I am in thread1.");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		Thread t2 = new Thread(() -> {
			System.out.println("Hi, I am in thread2.");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*
			 * try { t1.join(); } catch (InterruptedException e) { // TODO Auto-generated
			 * catch block e.printStackTrace(); }
			 */
		});

		Thread t3 = new Thread(() -> {
			System.out.println("Hi, I am in thread3.");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*
			 * try { t2.join(); } catch (InterruptedException e) { // TODO Auto-generated
			 * catch block e.printStackTrace(); }
			 */
		});

		t3.start();
		t3.join();
		t2.start();
		t2.join();
		t1.start();
		t1.join();
	}
}
