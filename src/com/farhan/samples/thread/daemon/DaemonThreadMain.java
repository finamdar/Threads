package com.farhan.samples.thread.daemon;

public class DaemonThreadMain {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(() -> {
			for(int i=0; i< 10; i++) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("T1");
			}
		});
		
		Thread thread2 = new Thread(() -> {
			for(int i=0; i< 5; i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("T2");
			}
		});
		
		thread.setDaemon(true);
		thread.start();
		thread2.start();
		System.out.println("after join");
	}

}
