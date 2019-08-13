package com.farhan.samples.thread.pingpong;

public class PingPingMain {

	public static void main(String[] args) throws InterruptedException {
		PingPong pingPong = new PingPong();
		Thread t1 = new Thread(() -> {
			try {
				pingPong.printPing();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Thread t2 = new Thread(() -> {
			try {
				pingPong.printPong();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		t1.start();
		Thread.sleep(1000);
		t2.start();
		
		t1.join();
		t2.join();
	}

}
