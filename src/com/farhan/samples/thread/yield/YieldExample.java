package com.farhan.samples.thread.yield;

public class YieldExample {

	public static void main(String[] args) {
		Thread thread = new Thread(() -> {
			System.out.println("Thread started");
			for(int i =0; i < 5; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(i);
			}
		});
		thread.setPriority(Thread.MIN_PRIORITY);
		Thread.yield();
		thread.start();
		/*thread.yield();*/
		
		for(int i=0; i<5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("Main thread: "+i);
		}
	}

}
