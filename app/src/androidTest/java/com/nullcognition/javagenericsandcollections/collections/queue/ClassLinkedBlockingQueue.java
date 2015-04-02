package com.nullcognition.javagenericsandcollections.collections.queue;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by ersin on 30/03/15 at 11:07 PM
 */
public class ClassLinkedBlockingQueue {
   // dont forget the drainTo methods for removing the queues contents to another collection

   ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();

   public void start(){

	  new Thread(new Runnable() {

		 @Override
		 public void run(){
			for(int i = 0; i < 5; i++){
			   concurrentLinkedQueue.add(new Random(1).nextInt());
			   concurrentLinkedQueue.add(new Random(1).nextInt());
			   try{
				  Thread.currentThread()
						.sleep(100);
			   }
			   catch(InterruptedException e){
				  e.printStackTrace();
			   }
			}


		 }
	  }).start();

	  new Thread(new Runnable() {

		 @Override
		 public void run(){

			for(int i = 0; i < 5; i++){
			   if(concurrentLinkedQueue.poll() == null){
				  try{
					 Thread.currentThread()
						   .sleep(200);
				  }
				  catch(InterruptedException e){
					 e.printStackTrace();
				  }
			   }


			}


		 }
	  }).start();
   }
}
