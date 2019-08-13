package com.farhan.samples.thread.pingpong;

public class DingDong {

	private static Object mutex = new Object();
	
	public void printDing() throws InterruptedException {
		while(true) {
			synchronized (mutex) {
				Thread.sleep(1000);
				mutex.notify();
				System.out.println("Ding");
				mutex.wait();
			}
		}
	}
	
	public void printDong() throws InterruptedException {
		while(true) {
			synchronized (mutex) {
				Thread.sleep(1000);
				mutex.notify();
				System.out.println("Dong");
				mutex.wait();
			}
		}
	}
}
