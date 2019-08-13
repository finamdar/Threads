package com.farhan.samples.thread.producer.consumer;

public class ProducerConsumerMain {

	public static void main(String[] args) throws InterruptedException {
		ProducerConsumer producerConsumer = new ProducerConsumer();
		Thread t1 = new Thread(() -> {
			try {
				producerConsumer.produce();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Thread t2 = new Thread(() -> {
			try {
				producerConsumer.consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		Thread.sleep(2000);
		t2.start();
	}

}
