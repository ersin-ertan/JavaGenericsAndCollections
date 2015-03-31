package com.nullcognition.javagenericsandcollections.collections.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by ersin on 30/03/15 at 11:07 PM
 */
public class ClassArrayBlockingQueue {

   ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<Integer>(3);

   public void blocking(){
	  new Thread(new Runnable() {

		 @Override
		 public void run(){
			arrayBlockingQueue.add(0); // return true, else throw exc if full
			try{
			   arrayBlockingQueue.offer(1,100, TimeUnit.NANOSECONDS); // return true, else false
			}
			catch(InterruptedException e){
			   e.printStackTrace();
			}
			try{
			   arrayBlockingQueue.put(2); // waits/blocks till possible
			arrayBlockingQueue.put(3); // will block and not add, will add after 2nd threads remove is call
			}
			catch(InterruptedException e){
			   e.printStackTrace();
			}
			arrayBlockingQueue.add(1);

		 }
	  }).start();

	  new Thread(new Runnable() {

		 @Override
		 public void run(){
			try{
			   Thread.sleep(1000);
			}
			catch(InterruptedException e){
			   e.printStackTrace();
			}// generics allow for interger instead of object
			Integer i = arrayBlockingQueue.remove(); // will throw if empty
			try{
			   i = arrayBlockingQueue.take(); // removes head will wait
			}
			catch(InterruptedException e){
			   e.printStackTrace();
			}
			try{
			   arrayBlockingQueue.poll(100, TimeUnit.NANOSECONDS); // will wait x time, or return null
			}
			catch(InterruptedException e){
			   e.printStackTrace();
			}
		 }
	  }).start();

   }

}
