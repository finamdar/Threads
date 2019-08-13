package com.farhan.samples.thread.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {

	public static void main(String[] args) throws InterruptedException {
		RunnableImpl impl = new RunnableImpl();
		Semaphore semaphore = new Semaphore(2);
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for(int i =0; i<= 5; i++) {
			semaphore.acquire();
			executorService.submit(() -> {
				impl.printStatement("thread");
			});
			System.out.println("finished executing: "+i);
			semaphore.release();
		}
		executorService.shutdown();
	}

}

class RunnableImpl{

	public void printStatement(String str) {
		System.out.println("Executing thread: "+str);
	}
	
}
