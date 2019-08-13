package com.farhan.samples.thread.sleep;

public class ThreadSleepMain {

	public static void main(String[] args) {
		Thread thread = new Thread(() -> {
			for(int i=0; i< 5; i++) {
				if(i==3) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("thread1: "+i);
			}
		});
		
		Thread thread2 = new Thread(() -> {
			for(int i =0; i < 20; i++)
				System.out.println("Thread2:"+i);
		});
		
		thread.start();
		thread2.start();
	}

}
