package com.farhan.samples.thread.create;

public class ImplementsRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Creating thread by implementing runnable interface");
	}

}
