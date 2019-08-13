package com.farhan.samples.thread.volatilesample;

public class VolatileDate {
	private volatile static int counter = 0;
	
	public void incrementCount(String threadName) {
		counter = counter + 1;
		System.out.println("Thread: " + threadName + " value is: " + counter);
	}
}
