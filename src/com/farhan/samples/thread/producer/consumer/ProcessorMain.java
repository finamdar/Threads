package com.farhan.samples.thread.producer.consumer;

public class ProcessorMain {

	public static void main(String[] args) throws InterruptedException {
		Processor processor = new Processor();

		Thread t1 = new Thread(() -> {
			try {
				processor.produce();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			;
		});
		
		Thread t2 = new Thread(() -> {
			try {
				processor.consume();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			;
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		System.out.println("thread1 fimished");
		t2.join();
	}

}
