package com.farhan.samples.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{
	private int i;
	private CountDownLatch latch;
	
	public Processor(int i, CountDownLatch latch) {
		super();
		this.i = i;
		this.latch = latch;
	}



	@Override
	public void run() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Running: "+i + " latch: "+latch.getCount());
		latch.countDown();
		System.out.println("Finished: "+i + " latch: "+latch.getCount());
	}
	
	
}

public class CountDownLatchMain {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(3);
		Thread t1 = new Thread(new Processor(1, latch));
		Thread t2 = new Thread(new Processor(2, latch));
		Thread t3 = new Thread(new Processor(3, latch));
		Thread t4 = new Thread(new Processor(4, latch));
		t1.start();t2.start();t3.start();
		latch.await();
		t4.start();
		t4.join();
		System.out.println("Completed");
	}

}
