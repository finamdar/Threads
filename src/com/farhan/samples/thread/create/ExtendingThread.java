package com.farhan.samples.thread.create;

public class ExtendingThread extends Thread{

	@Override
	public void run() {
		System.out.println("Created a thread by extending thread class");
	}
}
