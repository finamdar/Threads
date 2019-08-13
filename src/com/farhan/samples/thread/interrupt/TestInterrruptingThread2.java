package com.farhan.samples.thread.interrupt;

class TestInterruptingThread2 extends Thread{  
public void run(){  
try{  
System.out.println("task");  
Thread.sleep(1000);  
System.out.println("after sleep task");
}catch(InterruptedException e){  
System.out.println("Exception handled "+e);  
}  
for(int i=0; i <4; i++) {
	System.out.println("thread is running...");  
}
}  
  
public static void main(String args[]){  
TestInterruptingThread2 t1=new TestInterruptingThread2();  
t1.start();  
  
t1.interrupt();  
  
}  
}  
