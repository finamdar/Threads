package com.farhan.samples.thread.pingpong;

public class DingDongMain {

	public static void main(String[] args) throws InterruptedException {
		DingDong dingDong = new DingDong();
		Thread t1 = new Thread(() ->  {
			try {
				dingDong.printDing();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Thread t2 = new Thread(() ->  {
			try {
				dingDong.printDong();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		t1.start();
		Thread.sleep(1000);
		t2.start();
	}

}
