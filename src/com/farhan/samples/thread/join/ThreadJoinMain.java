package com.farhan.samples.thread.join;

public class ThreadJoinMain {
	public static int count = 0;
	
	public static synchronized void incCount() {
		count++;
	}
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			System.out.println("Thread 1 started");
			for(int i =0; i <5; i++) {
				try {
					if(i>2) {
					Thread.sleep(2);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread1:" + i);
				incCount();
			}
		});
		
		Thread t2 = new Thread(() -> {
			System.out.println("Thread 2 started");
			for(int i =0; i <5; i++) {
				try {
					if(i>2) {
					Thread.sleep(1);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread2:" + i);
				incCount();
			}
		});
		
		t1.start();
		
		t2.start();
		
		try {
			//t1.join(6);
			t1.join();
			System.out.println(count);
			//t2.join();
			System.out.println("after join");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Value: "+count);
	}

}
