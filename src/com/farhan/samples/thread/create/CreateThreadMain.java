package com.farhan.samples.thread.create;

public class CreateThreadMain {
	public static void main(String args[]) {
		ExtendingThread thread = new ExtendingThread();
		thread.start();
		
		Thread thread2 = new Thread(new ImplementsRunnable());
		thread2.start();
		
		Thread thread3 = new Thread(() -> System.out.println("Creating thread by lambda expressions"));
		thread3.start();
	}
}
