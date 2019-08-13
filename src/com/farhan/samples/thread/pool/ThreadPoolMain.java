package com.farhan.samples.thread.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		RunnableThread runnableThread = null;
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for(int i = 0; i<=10; i++) {
			runnableThread = new RunnableThread("message: "+i);
			executorService.execute(runnableThread);
		}
		executorService.shutdown();
		ExecutorService executorService2 = Executors.newSingleThreadExecutor();
		Future<Integer> future = executorService2.submit(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 22;
		});
		System.out.println("adbasjhdvasvdgv");
		System.out.println(future.get());
		executorService2.shutdown();
		
	}

}
