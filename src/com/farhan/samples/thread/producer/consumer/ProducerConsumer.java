package com.farhan.samples.thread.producer.consumer;

import java.util.LinkedList;

public class ProducerConsumer {

	private LinkedList<Integer> queue = new LinkedList<>();
	private static Object mutex = new Object();
	private final int LIMIT = 10;
	
	public void produce() throws InterruptedException {
		int val = 1;
		while(true) {
			synchronized (mutex) {
				Thread.sleep(1000);
				mutex.notify();
				while(queue.size() == LIMIT) {
					mutex.wait();
				}
				System.out.println("Producing value: "+val);
				queue.add(val++);
			}
		}
	}
	
	public void consume() throws InterruptedException {
		while(true) {
			synchronized (mutex) {
				Thread.sleep(1000);
				mutex.notify();
				while(queue.size() == 0) {
					mutex.wait();
				}
				int readValue = queue.removeFirst();
				System.out.println("Value read: "+readValue);
			}
		}
	}
}
