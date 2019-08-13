package com.farhan.samples.thread.pool;

public class RunnableThread implements Runnable {
	private String message;
	
	public RunnableThread(String message) {
		super();
		this.message = message;
	}

	@Override
	public void run() {
		System.out.println("Thread Name: "+Thread.currentThread().getName() + " message: "+message);;
	}

}
