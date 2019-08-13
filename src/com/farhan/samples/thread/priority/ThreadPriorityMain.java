package com.farhan.samples.thread.priority;

public class ThreadPriorityMain {
	static int count = 0;
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(() -> {
			for(int i=0; i< 10; i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("T1");
			}
		});
		
		Thread thread2 = new Thread(() -> {
			for(int i =0; i < 10; i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("T2");
			}
		});
		
		thread.setPriority(Thread.MAX_PRIORITY);
		thread2.setPriority(Thread.MIN_PRIORITY);
		
		thread.start();
		thread2.start();
		System.out.println("before join");
		thread2.join();
		System.out.println("after join");
		
	}

}
