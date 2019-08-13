package com.farhan.samples.thread.producer.consumer;

import java.util.LinkedList;


public class Processor {
	
	LinkedList<Integer> list = new LinkedList();
	private Object mutex = new Object();
	private final int LIMIT = 10;
	
	public void produce() throws InterruptedException {
		System.out.println("Thread started producing");
		int i = 0;
		while(true) {
			synchronized (mutex) {
				/*System.out.println("producer acq lock");*/
				/*Thread.sleep(2000);*/
				while(list.size()==LIMIT) {
					System.out.println("Limit reached");
					mutex.wait();
				}
				/*System.out.println("Adding value");*/
				list.add(i++);
				mutex.notify();
				/*System.out.println("after waiting produce");*/
				Thread.sleep(3000);
				/*System.out.println("after sleeping produce");*/
				mutex.wait();
				System.out.println("waiting for relock");
			}
		}
	}
	
	public void consume() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Thread started consuming");
		while(true) {
			Thread.sleep(2000);
			synchronized (mutex) {
				/*System.out.println("consume acq lock");*/
				while(list.size() == 0) {
					mutex.wait();
				}
				int value = list.removeFirst();
				System.out.println("Value: "+value);
				mutex.notify();
			}
		}
	}
}
