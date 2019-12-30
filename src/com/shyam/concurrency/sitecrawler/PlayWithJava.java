package com.shyam.concurrency.sitecrawler;

public class PlayWithJava {

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			double randNum = Math.random();
			System.out.println(randNum*10);
			System.out.println((int)(Math.ceil(randNum*10)));
			System.out.println((int)(Math.floor(randNum*10)));
		}

	}

}
