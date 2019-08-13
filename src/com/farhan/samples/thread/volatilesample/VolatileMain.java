package com.farhan.samples.thread.volatilesample;

public class VolatileMain {

	public static void main(String[] args) {
		VolatileDate date = new VolatileDate();
		Thread t1 = new Thread(() ->   {
			for (int i=0; i<10; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			date.incrementCount("thread1");
			}
		});
		
		Thread t2 = new Thread(() ->   {
			for (int i=0; i<10; i++) {
			date.incrementCount("thread2");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		});
		
		t1.start();
		t2.start();
	}

}
