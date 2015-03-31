package com.nullcognition.javagenericsandcollections.collections.queue;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by ersin on 30/03/15 at 11:08 PM
 */
public class ClassSynchronousQueue {

   SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>(true); // fair scheduling


   public void method(){
   	new Thread(new Runnable() {

	   @Override
	   public void run(){
		  try{
			 synchronousQueue.put(1); // will wait until another thread recieves it
		  }
		  catch(InterruptedException e){
			 e.printStackTrace();
		  }
	   }
	}).start();

	  new Thread(new Runnable() {

		 @Override
		 public void run(){
			try{
			   Thread.currentThread().sleep(100); // cause this thread to sleep, take and cause first thread to wait, put
			   synchronousQueue.take(); // will wait for another thread to put
			}
			catch(InterruptedException e){
			   e.printStackTrace();
			}
		 }
	  }).start();
   }
}
