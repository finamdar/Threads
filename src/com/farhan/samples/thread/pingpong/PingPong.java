package com.farhan.samples.thread.pingpong;

public class PingPong {
	
	private Object mutex = new Object();

	public void printPing() throws InterruptedException {
		while(true) {
			synchronized (mutex) {
				mutex.notify();//t2 awake
				System.out.println("Ping");
				mutex.wait();//t1 releases lock
			}
		}
	}
	
	public void printPong() throws InterruptedException {
		
		while(true) {
			synchronized (mutex) {
				mutex.notify();//t1 awake 
				System.out.println("Pong");
				mutex.wait();//t2 releases lock
				
				
			}
		}
	}
}
